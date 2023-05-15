import com.jogamp.opengl.*;

public class EventListener implements GLEventListener {

    static GL2 gl = null;

    static int score = 0;

    static int step = 1;


    public void display(GLAutoDrawable drawable) {
        gl = drawable.getGL().getGL2();
        EventListener.gl.glClearColor(0,0,0f,0);
        EventListener.gl.glClear(GL.GL_COLOR_BUFFER_BIT); //These two clear the screen for every frame

//        Bresenham.drawLine(100, 100, -90, 0, 1, 1, 0);
//        Bresenham.drawLine(-100, 0, 0, 100, 1, 1, 0);
//        Bresenham.drawLine(0, 100, 100, 0, 1, 1, 0);

//        Bresenham.drawPolygon(new int[]{-100, 100, 100, -100}, new int[]{100, 100, -100, -100}, 1, 1, 0);
//        Bresenham.drawPolygon(new int[]{-100, 0, 100}, new int[]{0, 100, 0}, 1, 1, 0);
//        EventListener.gl.glBegin(gl.GL_POINTS);
//        EventListener.gl.glColor3f(1, 1, 1);
//        EventListener.gl.glVertex2i(0, 0);
//        EventListener.gl.glEnd();

//        gl.glBegin(gl.GL_QUADS);
//        gl.glColor3f(1, 1, 1);
//        gl.glVertex2i(-50, 50);
//        gl.glVertex2i(50, 50);
//        gl.glVertex2i(50, -50);
//        gl.glVertex2i(-50, -50);
//        gl.glEnd();
        Background.drawStars();
        Background.drawGround();
        score+=step;
        NewString.draw(String.valueOf(score), Renderer.WIDTH/-2 + 20, Renderer.HEIGHT/2 - 20);
        if (score%10000 == 0) {
            step++;
        }
//        Bresenham.getPixel(0, 0);
        Heart.drawHearts();
        Obstacle.drawObstacles();
//        Player.drawPlayer(-100, 0);
        Character.runCharacter();
        Token.drawToken();
//        QuestionFrame.draw(Question.questions[1]);
//        Renderer.animator.pause();
    }
    public void dispose(GLAutoDrawable drawable) {
        //
    }
    public void init(GLAutoDrawable drawable) {
        //
    }
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL2 gl = drawable.getGL().getGL2();
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        gl.glOrtho(-Renderer.WIDTH/2.0,Renderer.WIDTH/2.0,-Renderer.HEIGHT/2.0,Renderer.HEIGHT/2.0,-1,1);
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity();
//        glu.gluOrtho2D(-Renderer.WIDTH/2.0,Renderer.WIDTH/2.0,-Renderer.HEIGHT/2.0,Renderer.HEIGHT/2.0);


    }


}
