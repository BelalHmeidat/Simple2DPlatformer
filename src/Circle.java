import com.jogamp.opengl.GL2;

public class Circle {


    public static void draw(int xc, int yc, int radius ) {
        int x, y, p;
        x = 0;
        y = radius;

        duplicateCirlce(x, y, xc, yc);

        p = 1 - radius;
        while (x < y) {
            x = x + 1;
            if (p < 0) {
                p = p + 2 * x + 1;
            } else {
                y = y - 1;
                p = p + 2 * x + 1 - 2 * y;
            }
            duplicateCirlce(x, y, xc, yc);
        }

    }

    public static void duplicateCirlce(int x, int y, int xc, int yc) {
        GL2 gln = EventListener.gl;
        gln.glBegin(GL2.GL_POINTS);
        gln.glVertex2f(xc + x, yc + y);
        gln.glVertex2f(xc + x, yc - y);
        gln.glVertex2f(xc - x, yc + y);
        gln.glVertex2f(xc - x, yc - y);
        gln.glVertex2f(xc + y, yc + x);
        gln.glVertex2f(xc + y, yc - x);
        gln.glVertex2f(xc - y, yc + x);
        gln.glVertex2f(xc - y, yc - x);
        gln.glEnd();
    }
}
