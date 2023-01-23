import com.jogamp.opengl.GL2;

import java.util.Random;

public class Token {
    static float xLoc = 0;
    static final float Y_LOC = 0;

    static int displacement = 0;

    static final float [] COLOR = {0.2f, 0.8f, 0.8f};
    static final int RARITY_OF_TOKEN = 6;

    static float nextLocation = 0;

    static void drawToken(){
        EventListener.gl.glColor3f(COLOR[0], COLOR[1], COLOR[2]);
        EventListener.gl.glBegin(GL2.GL_QUADS);
        EventListener.gl.glVertex2f(nextLocation-5 + displacement, Y_LOC-5);
        EventListener.gl.glVertex2f(nextLocation + 5 + displacement, Y_LOC-5);
        EventListener.gl.glVertex2f(nextLocation + 5+ displacement, Y_LOC+5);
        EventListener.gl.glVertex2f(nextLocation-5+ displacement, Y_LOC+5);
        EventListener.gl.glEnd();
        displacement--;
        if (nextLocation -5 + displacement <= Renderer.WIDTH/-2f){
            nextLocation = new Random().nextFloat(Renderer.WIDTH/2f, RARITY_OF_TOKEN * Renderer.WIDTH/2f);
            displacement = 0;
        }
    }

}
