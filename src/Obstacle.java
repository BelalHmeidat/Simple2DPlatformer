import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;

import java.nio.FloatBuffer;
import java.util.Random;

import static com.jogamp.opengl.GL.GL_FLOAT;

public class Obstacle {
    static float displacement = (float) 0;
    static final float OBSTACLE_TIP = -100;
    static float OBSTACLE_BOTTOM = -150;
    static final float OBSTACLE_WIDTH = 20;
    static final float OBSTACLE_TIP_WIDTH = 10;

    static final int RANDOM_BOUND = 1000;
    static float [] obstacleList = new float[5];

    static int pos = Renderer.WIDTH/2;
    float obstacleBeginning = Renderer.WIDTH/2f;

    Obstacle (){
    }

    Obstacle (float obstacleBeginning){
        this.obstacleBeginning = obstacleBeginning;
    }

    public static void generateObstacles(){//coordinates of obstacles beginning
        Random random = new Random();
        Random randomInt = new Random();

        float newBeginning = 0;
        for (int i = 0; i < obstacleList.length; i++) {
//            newBeginning/=randomInt.nextInt(9);

            newBeginning += i * Renderer.WIDTH/2.0; //random.nextInt(Renderer.WIDTH/2, RANDOM_BOUND);
            obstacleList[i] = newBeginning;
            System.out.println(obstacleList[i]);
        }
//        return newBeginning;
    }

    static float [] getPixelColor(int xPosition){
        FloatBuffer buffer = FloatBuffer.allocate(4);
        EventListener.gl.glReadBuffer(GL.GL_BACK);
        EventListener.gl.glReadPixels( xPosition, (int) OBSTACLE_BOTTOM, 1,1, GL.GL_RGBA, GL_FLOAT, buffer);
        float pixelColors [] = new float[3];
        pixelColors = buffer.array();
        return pixelColors;
    }
    public static void drawObstacle(float obstacleBeginning){
//        generateNewBeginning();

        obstacleBeginning+=displacement;
        EventListener.gl.glColor3f(1,1,1);
        EventListener.gl.glBegin(GL2.GL_TRIANGLES);
//        EventListener.gl.glVertex2f(obstacleBeginning + displacement, OBSTACLE_BOTTOM);
//        EventListener.gl.glVertex2f(obstacleBeginning + OBSTACLE_TIP_WIDTH + displacement, OBSTACLE_TIP);
//        EventListener.gl.glVertex2f(obstacleBeginning + OBSTACLE_WIDTH + displacement, OBSTACLE_BOTTOM);
        EventListener.gl.glVertex2f(obstacleBeginning, OBSTACLE_BOTTOM);
        EventListener.gl.glVertex2f(obstacleBeginning + OBSTACLE_TIP_WIDTH, OBSTACLE_TIP);
        EventListener.gl.glVertex2f(obstacleBeginning + OBSTACLE_WIDTH, OBSTACLE_BOTTOM);
        EventListener.gl.glEnd();

    }

    public static void drawObstacles(){ //all obstacles
        int i = 0;
        while (i < obstacleList.length){
//            while(Obstacle.getPixelColor((int)Obstacle.obstacleList[i])[0] == 1 && Obstacle.getPixelColor((int)Obstacle.obstacleList[i])[1] == 1  && Obstacle.getPixelColor((int)Obstacle.obstacleList[i])[2] == 1){
//                Obstacle.obstacleList[i] = Obstacle.obstacleList[i] + Obstacle.OBSTACLE_WIDTH;
//                System.out.println(true);
//            }
            drawObstacle(obstacleList[i]);
            i++;
//            if (i == obstacleList.length - 1){
//
//            }
        }
//        Obstacle.drawObstacle(Obstacle.pos);
//        if (Obstacle.pos == -Renderer.WIDTH/2){
//            Obstacle.pos = Renderer.WIDTH/2;
//            System.out.println(true);
//        }

        displacement +=-1;
    }

}
