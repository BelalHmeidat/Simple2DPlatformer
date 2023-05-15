import java.util.ArrayList;

import com.jogamp.opengl.*;

public class Number {
    boolean arr[][][] = new boolean[10][8][8];
    int number;
    int x;
    int y;

    public Number(boolean arr[][][], int number, int x, int y) {
        this.arr = arr;
        this.number = number;
        this.x = x;
        this.y = y;
    }

    public void draw() {
        int digit;
        int newX = x;
        int newY = y;
        GL2 gln = EventListener.gl;
        gln.glColor3f(1, 0, 0);
        gln.glBegin(GL2.GL_POINTS);
        // int tempNumber=number;
        int l[] = dividIndexes(number);
        // number=tempNumber;
        for (int z = 0; z < l.length; z++) {
            digit = l[z];
            for (int j = newY, countery = 0; countery < 16; countery += 2) {
                for (int i = newX, counterx = 0; counterx < 16; counterx += 2) {
                    if (arr[digit][countery / 2][counterx / 2] == true) {

                        gln.glVertex2f(i + counterx, j - countery);

                        gln.glVertex2f(i + counterx + 1, j - countery);

                        gln.glVertex2f(i + counterx, j - countery + 1);

                        gln.glVertex2f(i + counterx + 1, j - countery + 1);

                    }
                }
            }
            newX = newX + 20;
        }

        gln.glEnd();
    }

    public int[] dividIndexes(int num) {
        ArrayList<Integer> digits = new ArrayList<>();
        while (num > 0) {
            int digit = num % 10;
            digits.add(0, digit);
            num /= 10;
        }
        int[] result = new int[digits.size()];
        for (int i = 0; i < digits.size(); i++) {
            result[i] = digits.get(i);

        }

        return result;
    }

    public void increase() {
        number++;

    }

}
