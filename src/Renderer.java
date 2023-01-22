import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.FPSAnimator;
import jogamp.opengl.glu.nurbs.CArrayOfArcs;

import javax.swing.*;

public class Renderer {
    static int speed = 240;

    final static int WIDTH = 640;
    final static int HEIGHT = 320;
//    public static GLWindow window = null;
    public static GLCanvas canvas = null;
    public static void initialize() {
        GLProfile.initSingleton();
        GLProfile profile =GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);

        canvas = new GLCanvas(capabilities);

//        window.addGLEventListener(new EventListener());
        canvas.addGLEventListener(new EventListener());

//        window.setSize(640, 320);
        canvas.setSize(WIDTH, HEIGHT);
        FPSAnimator animator = new FPSAnimator(canvas, speed);
        animator.start();

//        window.setResizable(false);
        JFrame frame = new JFrame("Platformer");
        frame.getContentPane().add(canvas);
        frame.setResizable(false);
//        window.setVisible(true);
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

}
