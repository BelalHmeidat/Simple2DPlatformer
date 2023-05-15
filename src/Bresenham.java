import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

public class Bresenham {
//    private int [][] points = new int [2][];// = new Point[0]; //Array of points to be returned //initially empty



//    public static void drawLine(int x0, int y0, int x1, int y1, int r, int g, int b) {
//        int dx, dy, p, x, y;
//        EventListener.gl.glColor3f(r, g, b);
//        dx = Math.abs(x1 - x0);
//        dy = Math.abs(y1 - y0);
//        x = x0;
//        y = y0;
//        EventListener.gl.glBegin(EventListener.gl.GL_POINTS);
//        EventListener.gl.glVertex2i(x, y);
//        EventListener.gl.glEnd();
//        p = 2 * dy - dx;
//        if (dx >= dy) {
//            if (x0 > x1){
//                x = x1;
//                while (x <= x0){
//                    if (p >= 0) {
//                        if (y0 > y1)
//                            y = y - 1;
//                        else
//                            y = y + 1;
//                        p = p + 2 * dy - 2 * dx;
//                    } else {
//                        p = p + 2 * dy;
//                    }
//                    x = x + 1;
//                    EventListener.gl.glBegin(EventListener.gl.GL_POINTS);
//                    EventListener.gl.glVertex2i(x, y);
//                    EventListener.gl.glEnd();
//                }
//            }
//            else if (x0 < x1){
//                x = x0;
//                while (x <= x1) {
//                    if (p >= 0) {
//                        if (y0 > y1)
//                            y = y - 1;
//                        else
//                            y = y + 1;
//                        p = p + 2 * dy - 2 * dx;
//                    } else {
//                        p = p + 2 * dy;
//                    }
//                    x = x + 1;
//                    EventListener.gl.glBegin(EventListener.gl.GL_POINTS);
//                    EventListener.gl.glVertex2i(x, y);
//                    EventListener.gl.glEnd();
//                }
//            }
//        }
//        else {
//            if (y0 > y1) {
//                y = y1;
//                while (y <= y0) {
//                    System.out.println("x: " + x + " y: " + y);
//                    if (p >= 0) {
//                        if (x0 > x1)
//                            x = x - 1;
//                        else
//                            x = x + 1;
//                        x = x + 1;
//                        p = p + 2 * dx - 2 * dy;
//                    } else {
//                        p = p + 2 * dx;
//                    }
//                    y = y + 1;
//                    EventListener.gl.glBegin(EventListener.gl.GL_POINTS);
//                    EventListener.gl.glVertex2i(x, y);
//                    EventListener.gl.glEnd();
//                }
//            }
//            else if (y0 < y1) {
//                y = y0;
//                while (y <= y1) {
//                    System.out.println("x: " + x + " y: " + y);
//                    if (p >= 0) {
//                        if (x0 > x1)
//                            x = x - 1;
//                        else
//                            x = x + 1;
//                        x = x + 1;
//                        p = p + 2 * dx - 2 * dy;
//                    } else {
//                        p = p + 2 * dx;
//                    }
//                    y = y + 1;
//                    EventListener.gl.glBegin(EventListener.gl.GL_POINTS);
//                    EventListener.gl.glVertex2i(x, y);
//                    EventListener.gl.glEnd();
//                }
//            }
//        }
//    }
    public static void drawLine(int x0, int y0, int x1, int y1, int r, int g, int b) {
        int dx, dy, p, x, y;
        EventListener.gl.glColor3f(r, g, b);
        EventListener.gl.glBegin(EventListener.gl.GL_POINTS);
        EventListener.gl.glVertex2i(x0, y0);
        EventListener.gl.glEnd();
        dx = Math.abs(x1 - x0);
        dy = Math.abs(y1 - y0);
        x = x0;
        y = y0;
        if (dx >= dy) {
        p = 2 * dy - dx;
            while (x != x1){
                if (p >= 0) {
                    if (y0 > y1)
                        y = y - 1;
                    else
                        y = y + 1;
                    p = p + 2 * dy - 2 * dx;
                } else {
                    p = p + 2 * dy;
                }
                if (x0 > x1)
                    x = x - 1;
                else
                    x = x + 1;
                EventListener.gl.glBegin(EventListener.gl.GL_POINTS);
                EventListener.gl.glVertex2i(x, y);
                EventListener.gl.glEnd();
            }
        }
        else {
            p = -dy + 2*dx;
            while (y != y1) {
                if (p >= 0) {
                    if (x0 > x1)
                        x = x - 1;
                    else
                        x = x + 1;
                    p = p + 2 * dx - 2 * dy;
                } else {
                    p = p + 2 * dx;
                }
                if (y0 > y1)
                    y = y - 1;
                else
                    y = y + 1;
                EventListener.gl.glBegin(EventListener.gl.GL_POINTS);
                EventListener.gl.glVertex2i(x, y);
                EventListener.gl.glEnd();
            }
        }
        EventListener.gl.glBegin(EventListener.gl.GL_POINTS);
        EventListener.gl.glVertex2i(x1, y1);
        EventListener.gl.glEnd();
    }
    public static void drawPolygon(int [] x, int [] y, int r, int g, int b) {
        for (int i = 0; i < x.length - 1; i++) {
            drawLine(x[i], y[i], x[i + 1], y[i + 1], r, g, b);
        }
        drawLine(x[x.length - 1], y[y.length - 1], x[0], y[0], r, g, b);
//        boundaryFill4(0,50, new int [] {1,1,1} , new int [] {1,1,0});
    }

    public static void boundaryFill4(int x, int y, float [] fill_color, float [] boundary_color)
    {
        if(!compareColors(getPixel(x, y),boundary_color) && (!compareColors(getPixel(x, y), fill_color)))
        {
            putPixel(x, y, fill_color);
            boundaryFill4(x + 1, y, fill_color, boundary_color);
            boundaryFill4(x, y + 1, fill_color, boundary_color);
            boundaryFill4(x - 1, y, fill_color, boundary_color);
            boundaryFill4(x, y - 1, fill_color, boundary_color);
        }
    }

    public static float [] getPixel(int x, int y) {
        ByteBuffer pixelColor = ByteBuffer.allocate(3);
        EventListener.gl.glReadPixels(x + Renderer.WIDTH/2 , y + Renderer.HEIGHT/2, 1, 1, GL2.GL_RGB, GL2.GL_UNSIGNED_BYTE, pixelColor);
        float r = (pixelColor.get(0));//-255f;
        float g = (pixelColor.get(1));//-255f;
        float b = (pixelColor.get(2));//-255f;
        System.out.println("r: " + r + " g: " + g + " b: " + b);
        return new float[] {r, g, b};
    }

    private static boolean compareColors(float [] color1, float [] color2) {
        return color1[0] == color2[0] && color1[1] == color2[1] && color1[2] == color2[2];
    }

    private static void putPixel(int x, int y, float [] fillColor) {
        EventListener.gl.glColor3f(fillColor[0], fillColor[1], fillColor[2]);
        EventListener.gl.glBegin(EventListener.gl.GL_POINTS);
        EventListener.gl.glVertex2i(x, y);
        EventListener.gl.glEnd();
    }
    private static int [] getPointInsidePolygon(int [] x, int [] y) {
        int xMin = x[0];
        int xMax = x[0];
        int yMin = y[0];
        int yMax = y[0];
        for (int i = 1; i < x.length; i++) {
            if (x[i] < xMin)
                xMin = x[i];
            if (x[i] > xMax)
                xMax = x[i];
            if (y[i] < yMin)
                yMin = y[i];
            if (y[i] > yMax)
                yMax = y[i];
        }
        int xPoint = (xMin + xMax) / 2;
        int yPoint = (yMin + yMax) / 2;
        return new int [] {xPoint, yPoint};
    }


}