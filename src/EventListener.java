import com.jogamp.opengl.*;

public class EventListener implements GLEventListener {

    static GL2 gl = null;

    public void display(GLAutoDrawable drawable) {
        gl = drawable.getGL().getGL2();
        EventListener.gl.glClearColor(0,0,0,1);
        EventListener.gl.glClear(GL.GL_COLOR_BUFFER_BIT); //These two clear the screen for every frame

        Obstacle.drawObstacles();
    }
    public void dispose(GLAutoDrawable drawable) {
        //
    }
    public void init(GLAutoDrawable drawable) {
        System.out.println("Initialized!");
    }
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL2 gl = drawable.getGL().getGL2();
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        gl.glOrtho(-Renderer.WIDTH/2.0,Renderer.WIDTH/2.0,-Renderer.HEIGHT/2.0,Renderer.HEIGHT/2.0,-1,1);
        gl.glMatrixMode(GL2.GL_MODELVIEW);
    }
}
