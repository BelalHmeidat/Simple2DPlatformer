import com.jogamp.opengl.GL2ES3;

import java.security.Key;

public class Character {
    //TODO Fix character speed
    //TODO Reshape character (circle?)
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
        drawChar(Y_LOC + charDisplacemnt++);
    }
    static void goDown(){
            drawChar(--charDisplacemnt + Y_LOC);
            if (charDisplacemnt == 0){
                status = 2;
            }
//            else status = 0;
    }
    static void checkStatus() {
        if (charDisplacemnt == MAX_JUMP) {
            status = 0;
        }
    }
    static void checkLost(){
        System.out.println(currentLocation);
        if (currentLocation <= Obstacle.OBSTACLE_TIP -10){
            Renderer.animator.pause();
            System.out.println(true);
        }
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
