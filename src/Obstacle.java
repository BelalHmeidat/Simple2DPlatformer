import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;

import java.nio.FloatBuffer;
import java.util.Random;

import static com.jogamp.opengl.GL.GL_FLOAT;

public class Obstacle {
//    TODO Add ceiling
    static float displacement = (float) 0;
    static final float OBSTACLE_TIP = -75;
    static float OBSTACLE_BOTTOM = -150;
    static final float OBSTACLE_WIDTH = 20;
    static final float OBSTACLE_TIP_WIDTH = 10;

    static final int RANDOM_BOUND = 1000;
    static float [] obstacleList = new float[5];

    static int pos = Renderer.WIDTH/2;
    float obstacleBeginning = Renderer.WIDTH/2f;

    static float randObs1 = Renderer.WIDTH;
    static float randObs2 = Renderer.WIDTH;

    static final float DISTANCE_BETWEEN_OBSTACLES = Renderer.WIDTH/2f; //only fixed obstacles

    Obstacle (){
    }

    Obstacle (float obstacleBeginning){
        this.obstacleBeginning = obstacleBeginning;
    }

    public static void generateObstacles(){//generated coordinates of obstacles beginning. a certain amount of fixed obstacle and 2 random ones located in between
        Random randLocation = new Random();
        float newBeginning = 0;//randLocation.nextFloat(Renderer.WIDTH/2f, Renderer.WIDTH);
        for (int i = 0; i < obstacleList.length; i++) {
//            newBeginning/=randomInt.nextInt(9);

            newBeginning += DISTANCE_BETWEEN_OBSTACLES; //random.nextInt(Renderer.WIDTH/2, RANDOM_BOUND);
            obstacleList[i] = newBeginning;
            System.out.println(obstacleList[i]);
        }
        Random randRange = new Random();
        int randomObsRange = randRange.nextInt(0, obstacleList.length-2); //the obstacle before last just because it works that way
        randObs1 = randLocation.nextFloat(obstacleList[randomObsRange] +OBSTACLE_WIDTH, obstacleList[randomObsRange] + DISTANCE_BETWEEN_OBSTACLES - OBSTACLE_WIDTH); //first random obtacle between a fixed obstacle and the one following it. The Width of the two obstacles bounding it so it doesn't overlap with them
        randObs2 = randLocation.nextFloat(obstacleList[randomObsRange] + DISTANCE_BETWEEN_OBSTACLES + OBSTACLE_WIDTH, Math.min((obstacleList[randomObsRange] + 3 * DISTANCE_BETWEEN_OBSTACLES), obstacleList[obstacleList.length-1]) - OBSTACLE_WIDTH); //same for the second but the upper bound is the minimum of the last or the random location. This is because the last the obstacles regenerate after the last fixed obstacle passed.

    }

    static float [] getPixelColor(int xPosition){
        FloatBuffer buffer = FloatBuffer.allocate(4);
        EventListener.gl.glReadBuffer(GL.GL_BACK);
        EventListener.gl.glReadPixels( xPosition, (int) OBSTACLE_BOTTOM, 1,1, GL.GL_RGBA, GL_FLOAT, buffer);
        float pixelColors [] = new float[3];
        pixelColors = buffer.array();
        return pixelColors;
    }
    public static void drawObstacle(float obstacleBeginning, int obstacleIndex){
        obstacleBeginning+=displacement;
        EventListener.gl.glColor3f(1,1,1);
        EventListener.gl.glBegin(GL2.GL_TRIANGLES);
        EventListener.gl.glVertex2f(obstacleBeginning, OBSTACLE_BOTTOM);
        EventListener.gl.glVertex2f(obstacleBeginning + OBSTACLE_TIP_WIDTH, OBSTACLE_TIP);
        EventListener.gl.glVertex2f(obstacleBeginning + OBSTACLE_WIDTH, OBSTACLE_BOTTOM);
        EventListener.gl.glEnd();
        if(obstacleBeginning <= Character.CHAR_WIDTH + Character.X_LOC && obstacleBeginning > Renderer.WIDTH/-2f){
            Character.checkLost();
        }
        if (obstacleBeginning + OBSTACLE_WIDTH == (Renderer.WIDTH/-2.0) && obstacleIndex == obstacleList.length-1){
            generateObstacles();
            displacement = 0;
        }
    }

    public static void drawObstacles(){ //all obstacles
        int i = 0;
        while (i < obstacleList.length){
//            while(Obstacle.getPixelColor((int)Obstacle.obstacleList[i])[0] == 1 && Obstacle.getPixelColor((int)Obstacle.obstacleList[i])[1] == 1  && Obstacle.getPixelColor((int)Obstacle.obstacleList[i])[2] == 1){
//                Obstacle.obstacleList[i] = Obstacle.obstacleList[i] + Obstacle.OBSTACLE_WIDTH;
//                System.out.println(true);
//            }
            drawObstacle(obstacleList[i], i);
            i++;
//            if (i == obstacleList.length - 1){
//
//            }
        }
        drawObstacle(randObs1, 0);
        drawObstacle(randObs2, 0);
//        Obstacle.drawObstacle(Obstacle.pos);
//        if (Obstacle.pos == -Renderer.WIDTH/2){
//            Obstacle.pos = Renderer.WIDTH/2;
//            System.out.println(true);
//        }

        displacement +=-1;
    }

}
