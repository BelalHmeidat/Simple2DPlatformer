import com.jogamp.opengl.GL2;

public class QuestionFrame {


    static int answer = 0;


    static boolean isUp = false;


    static final int X_BEGIN = -Renderer.WIDTH/2 + 20;// Renderer.WIDTH/4;
    static final int Y_BEGIN = -Renderer.HEIGHT/2 + Renderer.HEIGHT/4;
    static final int X_END = Renderer.WIDTH/2 - 20;// Renderer.WIDTH/4;
    static final int Y_END = Renderer.HEIGHT/2 - Renderer.HEIGHT/4;

    static final int FRAME_WIDTH = X_END - X_BEGIN;
    static final int FRAME_HEIGHT = Y_END - Y_BEGIN;

    static final int OP_WIDTH = FRAME_WIDTH/2 - 50;
    static final int OP_HEIGHT = FRAME_HEIGHT/2 - 50;


    static final int OP1_X_BEGIN = X_BEGIN + 10;
    static final int OP1_Y_BEGIN = Y_END - 70;
    static final int OP1_X_END = OP1_X_BEGIN + OP_WIDTH;
    static final int OP1_Y_END = OP1_Y_BEGIN - OP_HEIGHT;

    static final int OP2_X_BEGIN = FRAME_WIDTH/2 - 10;
    static final int OP2_Y_BEGIN = Y_END - 70;
    static final int OP2_X_END = OP2_X_BEGIN - OP_WIDTH;
    static final int OP2_Y_END = OP2_Y_BEGIN - OP_HEIGHT;


    static final int OP3_X_BEGIN = FRAME_WIDTH/2 - 10;
    static final int OP3_Y_BEGIN = Y_END - FRAME_HEIGHT/2 - 40;
    static final int OP3_X_END = OP2_X_BEGIN - OP_WIDTH;
    static final int OP3_Y_END = OP3_Y_BEGIN - OP_HEIGHT;


    static final int OP4_X_BEGIN = X_BEGIN + 10;
    static final int OP4_Y_BEGIN = Y_END - FRAME_HEIGHT/2 - 40;
    static final int OP4_X_END = OP4_X_BEGIN + OP_WIDTH;
    static final int OP4_Y_END = OP4_Y_BEGIN - OP_HEIGHT;



    public static void draw(Question question) {

        answer = question.whoTrue;

        Bresenham.drawPolygon(new int []{X_BEGIN, X_END, X_END, X_BEGIN}, new int[] {Y_BEGIN, Y_BEGIN, Y_END, Y_END},1,0,0);
        NewString.draw(question.question, X_BEGIN + 10, Y_END - 10);
        System.out.println(OP2_X_BEGIN);
        System.out.println(OP2_Y_BEGIN);
        System.out.println(OP2_X_END);
        System.out.println(OP2_Y_END);


        NewString.draw(question.op1, OP1_X_BEGIN+10, OP1_Y_BEGIN - 30);
        Bresenham.drawPolygon(new int []{OP1_X_BEGIN, OP1_X_END, OP1_X_END, OP1_X_BEGIN}, new int[] {OP1_Y_BEGIN, OP1_Y_BEGIN, OP1_Y_END, OP1_Y_END},1,0,0);

        Bresenham.drawPolygon(new int []{OP2_X_BEGIN, OP2_X_END, OP2_X_END, OP2_X_BEGIN}, new int[] {OP2_Y_BEGIN, OP2_Y_BEGIN, OP2_Y_END, OP2_Y_END},1,0,0);
        NewString.draw(question.op2, OP2_X_END+10, OP2_Y_BEGIN - 30);

        Bresenham.drawPolygon(new int []{OP3_X_BEGIN, OP3_X_END, OP3_X_END, OP3_X_BEGIN}, new int[] {OP3_Y_BEGIN, OP3_Y_BEGIN, OP3_Y_END, OP3_Y_END},1,0,0);
        NewString.draw(question.op3, OP3_X_END + 10, OP3_Y_BEGIN - 30);

        Bresenham.drawPolygon(new int []{OP4_X_BEGIN, OP4_X_END, OP4_X_END, OP4_X_BEGIN}, new int[] {OP4_Y_BEGIN, OP4_Y_BEGIN, OP4_Y_END, OP4_Y_END},1,0,0);
        NewString.draw(question.op4, OP4_X_BEGIN + 10, OP4_Y_BEGIN - 30);





    }
}
