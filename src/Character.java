import com.jogamp.opengl.GL2ES3;

import java.nio.ByteBuffer;

public class Character {
    static final float X_LOC = -Renderer.WIDTH/2f + 20;
    static final float Y_LOC = Obstacle.OBSTACLE_BOTTOM;
    static final float CHAR_HEIGHT = Math.abs(-75.0f)/2;
    static final float CHAR_WIDTH = CHAR_HEIGHT;
    static final float JUMP_LOC = -75 + 20;
    static final int [] CHAR_COLOR = {0,1,0};
    static final int MAX_JUMP = 130;
    static int status = 1;
    static int charDisplacemnt = 0;
    static float currentLocation = Y_LOC;

//    static ByteBuffer touchColorBuffer = ByteBuffer.allocate(4);


    static void drawChar(float elevation) {
//        EventListener.gl.glTranslatef(-X_LOC + -CHAR_WIDTH/2, -Y_LOC + -CHAR_HEIGHT/2, 0);
//        EventListener.gl.glRotatef(45, 0, 0, 1);
        EventListener.gl.glColor3f(CHAR_COLOR[0], CHAR_COLOR[1], CHAR_COLOR[2]);
        EventListener.gl.glBegin(GL2ES3.GL_QUADS);
        EventListener.gl.glVertex2f(X_LOC, elevation);
        EventListener.gl.glVertex2f(X_LOC+CHAR_WIDTH, elevation);
        EventListener.gl.glVertex2f(X_LOC+CHAR_WIDTH, elevation+CHAR_HEIGHT);
        EventListener.gl.glVertex2f(X_LOC, elevation+CHAR_HEIGHT);
        EventListener.gl.glEnd();
        currentLocation = elevation;
//        EventListener.gl.glTranslatef(X_LOC + CHAR_WIDTH/2, Y_LOC + CHAR_HEIGHT/2, 0);

    }
    static void goUp(){
        charDisplacemnt+=EventListener.step;
        drawChar(Y_LOC + charDisplacemnt);
    }
    static void goDown(){
        charDisplacemnt-=EventListener.step;
            drawChar(charDisplacemnt + Y_LOC);
            if (charDisplacemnt <= 0){
                status = 2;
            }
//            else status = 0;
    }
    static void checkStatus() {
        if (charDisplacemnt >= MAX_JUMP) {
            status = 0;
        }
    }
    static void checkLost(){
        System.out.println(currentLocation);
        if (currentLocation <= Obstacle.OBSTACLE_TIP -10){
            Heart.decrease();
//            if (Heart.count ==0){
//                NewString.draw("YOU RAN OUT OF LIVES", -20, 200);
//            }
            if (Heart.count < 0){
                EventListener.gl.glClear(GL2ES3.GL_COLOR_BUFFER_BIT);
                NewString.draw("GAME OVER YOUR SCORE IS " + String.valueOf(EventListener.score), -30, 50);
                Renderer.animator.stop();
            }
            Obstacle.displacement = 0;
            Obstacle.generateObstacles();
        }
    }

//    static void getTouchColor(){
//        for (int i = 0; i < (int) (Obstacle.OBSTACLE_TIP - Y_LOC) ; i++) {
//            EventListener.gl.glReadPixels((int) X_LOC, (int) Y_LOC, 1, 1, GL2ES3.GL_RGB, GL2ES3.GL_FLOAT, touchColorBuffer);
//            System.out.println(touchColorBuffer.get(0) + " " + touchColorBuffer.get(1) + " " + touchColorBuffer.get(2));
//            //two values are enough
//            int r = touchColorBuffer.get(0);
//            int g = touchColorBuffer.get(1);
//        }
//
//    }

//    static boolean touchColorContainsWhite(){
//        for (int i = 0; i < touchColor.length; i++) {
//            if (touchColor[i] == 1){
//                return true;
//            }
//        }
//    }

    public static boolean checkScoredToken(){
        if (currentLocation <= Token.BOTTOM_EDGE && currentLocation+CHAR_HEIGHT >= Token.TOP_EDGE)
            return true;
        else if (currentLocation <= Token.TOP_EDGE && currentLocation >= Token.BOTTOM_EDGE)
            return true;
        else if (currentLocation+CHAR_HEIGHT <= Token.TOP_EDGE && currentLocation+CHAR_HEIGHT >= Token.BOTTOM_EDGE)
            return true;
        else return false;
    }


    public static void runCharacter() {
        checkStatus();
        switch (status){
            case 1: goUp();
                break;
            case 0: goDown();
                break;
            default:
                drawChar(Y_LOC);
                KeyControl.pressCount = 0;
        }
    }
}
