import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;

import java.util.Random;

public class Token {
    static float xLoc = 0;
    static final float Y_LOC = 0;

    static final int BOTTOM_EDGE = -5;

    static final int TOP_EDGE = 5;
    static int displacement = 0;

    static final float [] COLOR = {0.2f, 0.8f, 0.8f};
    static final int RARITY_OF_TOKEN = 6;

    static float nextLocation = 0;

//    static void drawToken(){
//        EventListener.gl.glColor3f(COLOR[0], COLOR[1], COLOR[2]);
//        EventListener.gl.glBegin(GL2.GL_QUADS);
//        EventListener.gl.glVertex2f(nextLocation-5 + displacement, Y_LOC+BOTTOM_EDGE);
//        EventListener.gl.glVertex2f(nextLocation + 5 + displacement, Y_LOC+BOTTOM_EDGE);
//        EventListener.gl.glVertex2f(nextLocation + 5+ displacement, Y_LOC+TOP_EDGE);
//        EventListener.gl.glVertex2f(nextLocation-5+ displacement, Y_LOC+TOP_EDGE);
//        EventListener.gl.glEnd();
//        displacement--;
//        if (reachedCharacter()){
//            if (Character.checkScoredToken()){
////                Question.showAQuestion();
//                nextLocation = new Random().nextFloat(Renderer.WIDTH/2f, RARITY_OF_TOKEN * Renderer.WIDTH/2f);
//                displacement = 0;
//                Renderer.animator.pause();
//            }
//        }
//        if (nextLocation -5 + displacement <= Renderer.WIDTH/-2f){
//            nextLocation = new Random().nextFloat(Renderer.WIDTH/2f, RARITY_OF_TOKEN * Renderer.WIDTH/2f);
//            displacement = 0;
//        }
//    }

    static void drawToken(){
        EventListener.gl.glColor3f(COLOR[0], COLOR[1], COLOR[2]);
        Circle.draw((int)nextLocation + displacement, (int) Y_LOC, 10);
        displacement--;
        if (reachedCharacter()){
            if (Character.checkScoredToken()){
                Random tokenOutcomeRandom = new Random();
                int tokenOutcome = tokenOutcomeRandom.nextInt(5);
                switch (tokenOutcome) {
                   case  0:
                    case 1:
                    case 2: askQuestion();
                    break;
                   case 3: addScore();
                    break;
                   case 4: punish();
                    break;
                }
                nextLocation = new Random().nextFloat(Renderer.WIDTH/2f, RARITY_OF_TOKEN * Renderer.WIDTH/2f);
                displacement = 0;
            }
        }
        if (nextLocation -5 + displacement <= Renderer.WIDTH/-2f){
            nextLocation = new Random().nextFloat(Renderer.WIDTH/2f, RARITY_OF_TOKEN * Renderer.WIDTH/2f);
            displacement = 0;
        }
    }

    private static void askQuestion(){
        Obstacle.displacement = 0;
        Obstacle.generateObstacles();
        EventListener.gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        Random questionRandom = new Random();
        int questionNumber = questionRandom.nextInt(Question.questions.length-1);
        QuestionFrame.draw(Question.questions[questionNumber]);
        QuestionFrame.isUp = true;
        Renderer.animator.pause();
    }

    private static void addScore(){
        EventListener.score+=100;
    }

    private static void punish(){
        EventListener.step++;
    }

    private static boolean reachedCharacter(){
        if (nextLocation - 5 + displacement >= Character.X_LOC && nextLocation - 5 + displacement <= Character.X_LOC + Character.CHAR_WIDTH){
            return true;
        }
        else if (nextLocation + 5 + displacement >= Character.X_LOC && nextLocation + 5 + displacement <= Character.X_LOC + Character.CHAR_WIDTH){
            return true;
        }
        else if(nextLocation - 5 + displacement >= Character.X_LOC && nextLocation + 5 + displacement <= Character.X_LOC + Character.CHAR_WIDTH){
            return true;
        }
        else return false;
    }
}
