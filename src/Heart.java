import com.jogamp.opengl.GL2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Heart {
    final static boolean[][] heartBitMap;//new boolean[8][8];

    static {
        try {
            heartBitMap = readHeartFile();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    final static int x = Renderer.WIDTH/2 -100;
    final static int y = Renderer.HEIGHT/2 -50;
    static int count = 3;

//    public Heart(boolean[][] heartBitMap, int x, int y, int count) {
//        this.heartBitMap = heartBitMap;
//        this.x = x;
//        this.y = y;
//        this.count = count;
//    }

    public static void increase() {
        count++;
    }

    public static void decrease() {
        count--;

    }

    public static void drawHearts() {
        int newX = x;
        int newY = y;
        EventListener.gl.glColor3f(1, 0, 0);
        EventListener.gl.glBegin(GL2.GL_POINTS);
        for (int z = 0; z < count; z++) {
            for (int j = newY, countery = 0; countery < 16; countery += 2) {
                for (int i = newX, counterx = 0; counterx < 16; counterx += 2) {
                    if (heartBitMap[countery / 2][counterx / 2]) {

                        EventListener.gl.glVertex2f(i + counterx, j - countery);

                        EventListener.gl.glVertex2f(i + counterx + 1, j - countery);

                        EventListener.gl.glVertex2f(i + counterx, j - countery + 1);

                        EventListener.gl.glVertex2f(i + counterx + 1, j - countery + 1);

                    }
                }
            }
            newX = newX + 20;
        }
        EventListener.gl.glEnd();
    }

    public static boolean[][] readHeartFile() throws FileNotFoundException {
        File file = new File("Characters.txt");
        Scanner scan = new Scanner(file);
        String line = "";

        boolean arr[][] = new boolean[8][8];
        line = scan.nextLine();
        line = line.substring(2);
        String[] str = line.split(",");
        for (int j = 0; j < str.length; j++) {
            int num = Integer.parseInt(str[j], 16);
            String binary = Integer.toBinaryString(num);
            if (binary.length() < 8) {
                while (binary.length() != 8) {
                    binary = '0' + binary;
                }
            }
            for (int k = 0; k < binary.length(); k++) {
                if (binary.charAt(k) == '0') {
                    arr[j][k] = false;
                } else {
                    arr[j][k] = true;
                }
            }

        }
        return arr;
    }

}
