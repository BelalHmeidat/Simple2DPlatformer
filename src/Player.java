import com.jogamp.opengl.GL2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Player {
    static boolean[][] arr = new boolean[8][8];


    static {
        try {
            arr = readPlayerFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static boolean[][] readPlayerFile() throws FileNotFoundException {
        File file = new File("Characters.txt");
        Scanner scan = new Scanner(file);
        String line = "";

        boolean arr[][] = new boolean[8][8];
        line = scan.nextLine();
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



    public static void drawPlayer(int x, int y) {
        int newX = x;
        int newY = y;
        GL2 gln = EventListener.gl;
        gln.glColor3f(0, 0, 1);
        gln.glBegin(GL2.GL_POINTS);


        for (int j = newY, countery = 0; countery < 32; countery += 4) {
            for (int i = newX, counterx = 0; counterx < 32; counterx += 4) {
                if (arr[countery / 4][counterx / 4]) {

                    gln.glVertex2f(i + counterx, j - countery);
                    gln.glVertex2f(i + counterx , j - countery+1);
                    gln.glVertex2f(i + counterx , j - countery+2);
                    gln.glVertex2f(i + counterx , j - countery+3);

                    gln.glVertex2f(i + counterx+1, j - countery );
                    gln.glVertex2f(i + counterx+1, j - countery + 1);
                    gln.glVertex2f(i + counterx+1, j - countery + 2);
                    gln.glVertex2f(i + counterx+1, j - countery + 3);

                    gln.glVertex2f(i + counterx + 2, j - countery );
                    gln.glVertex2f(i + counterx + 2, j - countery + 1);
                    gln.glVertex2f(i + counterx + 2, j - countery + 2);
                    gln.glVertex2f(i + counterx + 2, j - countery + 3);

                    gln.glVertex2f(i + counterx + 3, j - countery );
                    gln.glVertex2f(i + counterx + 3, j - countery + 1);
                    gln.glVertex2f(i + counterx + 3, j - countery + 2);
                    gln.glVertex2f(i + counterx + 3, j - countery + 3);


                }
            }
        newX = newX + 40;
        }


        gln.glEnd();

    }


}
