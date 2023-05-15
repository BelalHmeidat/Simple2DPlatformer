import com.jogamp.opengl.GL2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NewString {
    static boolean[][][] characters;// = new boolean[36][8][8];


    static {
        try {
            characters = readCharactersFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
//    public NewString(boolean[][][] arr, String str, int x, int y) {
//        this.arr = arr;
//        this.str = str;
//        this.x = x;
//        this.y = y;
//    }



//    public NewString(boolean[][][] characters, String str) {
//        this.characters = characters;
//        this.str = str;
//
//    }


    public static boolean[][][] readCharactersFile() throws FileNotFoundException {
        File file = new File("Characters.txt");
        Scanner scan = new Scanner(file);
        String line = "";
        line = scan.nextLine();
        line = scan.nextLine();
        boolean arr[][][] = new boolean[36][8][8];
        for (int i = 0; i < 36; i++) {
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
                        arr[i][j][k] = false;
                    } else {
                        arr[i][j][k] = true;
                    }
                }

            }

        }
        return arr;
    }



    public static void draw(String str, int x, int y) {
        int newX = x;
        int newY = y;
        GL2 gln = EventListener.gl;
        gln.glColor3f(1, 0, 0);
        gln.glBegin(GL2.GL_POINTS);
        for (int z = 0; z < str.length(); z++) {
            if (str.charAt(z) == ' ') {
                newX = newX + 10;
                continue;
            }
//            if (str.charAt(z) == '\n') {
////                System.out.println("hi");
//                newX = x;
//                newY = newY - 25;
//                continue;
//            }
            for (int j = newY, countery = 0; countery < 16; countery += 2) {
                for (int i = newX, counterx = 0; counterx < 16; counterx += 2) {
                    if((char) str.charAt(z)>64&&(char) str.charAt(z)<90) {

                        if (characters[(char) str.charAt(z) - 65][countery / 2][counterx / 2] == true) {
                            gln.glVertex2f(i + counterx, j - countery);

                            gln.glVertex2f(i + counterx + 1, j - countery);

                            gln.glVertex2f(i + counterx, j - countery + 1);

                            gln.glVertex2f(i + counterx + 1, j - countery + 1);

                        }

                    }
                    if((char) str.charAt(z)>47&&(char) str.charAt(z)<58) {
                        if (characters[(char) str.charAt(z) - 22][countery / 2][counterx / 2] == true) {

                            gln.glVertex2f(i + counterx, j - countery);

                            gln.glVertex2f(i + counterx + 1, j - countery);

                            gln.glVertex2f(i + counterx, j - countery + 1);

                            gln.glVertex2f(i + counterx + 1, j - countery + 1);

                        }
                    }
                }
            }
            newX = newX + 20;
            if(newX>600&&x==20) {
                newX = x;
                newY = newY - 25;
            }
            if(newX>270&&x==25) {
                newX = x;
                newY = newY - 25;
            }

            if(newX>600&&x==355) {
                newX = x;
                newY = newY - 25;
            }
        }

        gln.glEnd();

    }

}
