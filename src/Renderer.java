import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.awt.GLJPanel;
import com.jogamp.opengl.util.FPSAnimator;
import jogamp.opengl.glu.nurbs.CArrayOfArcs;

import javax.swing.*;
import java.awt.event.KeyListener;

public class Renderer {
    static FPSAnimator animator;
    static int speed = 120;

    final static int WIDTH = 1200;
    final static int HEIGHT = 720;
//    public static GLWindow window = null;
    public static GLJPanel canvas = null;
    public static void initialize() {
        GLProfile.initSingleton();
        GLProfile profile =GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);

//        canvas = new GLCanvas(capabilities);
        canvas = new GLJPanel(capabilities);

//        window.addGLEventListener(new EventListener());
        canvas.addGLEventListener(new EventListener());
//        canvas.addKeyListener(new KeyControl() );
//        window.setSize(640, 320);
        canvas.setSize(WIDTH, HEIGHT);
        animator = new FPSAnimator(canvas, speed);
        animator.start();

//        window.setResizable(false);
        JFrame frame = new JFrame("Platformer");
        frame.getContentPane().add(canvas);
        frame.setResizable(false);
//        frame.addKeyListener(new KeyControl());
        canvas.addKeyListener(new KeyControl());
        canvas.addMouseListener(new MouseInput());
//        window.setVisible(true);
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

}
