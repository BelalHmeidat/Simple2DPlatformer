import com.jogamp.opengl.GL2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Background {
    static int xStart=-Renderer.WIDTH/2;
    static int yStart=-Renderer.HEIGHT/2;
    static int xEnd=Renderer.WIDTH/2;
    static int yEnd=(int)Obstacle.OBSTACLE_BOTTOM;
    static int arr [][]=new int [100][2];
    static  {
        for(int i=0;i<arr.length;i++) {
            for(int j=0;j<arr[i].length;j++) {
                if(j==0) {
                    arr[i][j]=(int)(Math.random()*1200-600);
                }
                else {
                    arr[i][j]=(int)(Math.random()*210-360);
                }
            }
        }

    }
    public static void  drawGround() {
        GL2 gln = EventListener.gl;
        gln.glColor3f(0.75f, 0.75f, 0.75f);
        gln.glBegin(GL2.GL_LINE_STRIP);
        gln.glVertex2f(xStart, yStart);
        gln.glVertex2f(xEnd, yStart);
        gln.glVertex2f(xEnd, yEnd);
        gln.glVertex2f(xStart,yEnd);
        gln.glVertex2f(xStart,yStart);
        gln.glEnd();
        gln.glBegin(GL2.GL_POINTS);
        for (int i = 0; i < arr.length; i++) {

            gln.glVertex2f(arr[i][0],arr[i][1]);

            gln.glVertex2f(arr[i][0]+1,arr[i][1]);

            gln.glVertex2f(arr[i][0],arr[i][1]+1);

            gln.glVertex2f(arr[i][0]+1,arr[i][1]+1);

        }
        gln.glEnd();

    }

    static int ySkyStart=0;
    static int ySkyEnd=360;

    static int skyArray [][]=new int [10][2];
    static boolean[][] arr2=new boolean[8][8];
    static {
        try {
            arr2 = readFile();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    static  {
        for(int i=0;i<skyArray.length;i++) {
            for(int j=0;j<skyArray[i].length;j++) {
                if(j==0) {
                    skyArray[i][j]=(int)(Math.random()*1200-600);
                }
                else {
                    skyArray[i][j]=(int)(Math.random()*210+100);
                }
            }
        }

    }
    public static boolean[][] readFile() throws FileNotFoundException {
        boolean arr2[][]=new boolean[8][8];
        File file = new File("Characters.txt");
        Scanner scan = new Scanner(file);
        String line = "";
        for(int s=0;s<38;s++) {
            line = scan.nextLine();
        }


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
                    arr2[j][k] = false;
                } else {
                    arr2[j][k] = true;
                }
            }

        }


        return arr2;

    }
    public static void drawStars() {
        for(int z=0;z<skyArray.length;z++) {
            int newX = skyArray[z][0];
            int newY = skyArray[z][1];
            GL2 gln = EventListener.gl;
            gln.glColor3f(1, 1, 1);
            gln.glBegin(GL2.GL_POINTS);


            for (int j = newY, countery = 0; countery < 8; countery += 1) {
                for (int i = newX, counterx = 0; counterx < 8; counterx += 1) {
                    if (arr2[countery ][counterx ] == true) {

                        gln.glVertex2f(i + counterx, j - countery);

                    }
                }
            }


            gln.glEnd();
        }

    }
}

