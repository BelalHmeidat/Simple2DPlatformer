import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {
//        System.out.println((e.getX() -600) + " " + (360 - 10- e.getY()));
//        System.out.println(e.getX() + " " + e.getY());
//        Bresenham.getPixel(e.getX(), e.getY());
        if (QuestionFrame.isUp) {
            if (e.getX() - Renderer.WIDTH / 2 > QuestionFrame.OP1_X_BEGIN && e.getX() - Renderer.WIDTH / 2 < QuestionFrame.OP1_X_END && Renderer.HEIGHT / 2 - 10 - e.getY() < QuestionFrame.OP1_Y_BEGIN && Renderer.HEIGHT / 2 - 10 - e.getY() > QuestionFrame.OP1_Y_END) {
                System.out.println("OP1");
                if (QuestionFrame.answer == 1) {
                    Heart.increase();
                    EventListener.step = 1;
                    System.out.println("CORRECT");
                } else {
                    System.out.println("WRONG");
                }
                QuestionFrame.isUp = false;
                Obstacle.generateObstacles();
                Renderer.animator.resume();
            } else if (e.getX() - Renderer.WIDTH / 2 < QuestionFrame.OP2_X_BEGIN && e.getX() - Renderer.WIDTH / 2 > QuestionFrame.OP2_X_END && Renderer.HEIGHT / 2 - 10 - e.getY() < QuestionFrame.OP2_Y_BEGIN && Renderer.HEIGHT / 2 - 10 - e.getY() > QuestionFrame.OP2_Y_END) {
                System.out.println("OP2");
                if (QuestionFrame.answer == 2) {
                    System.out.println("CORRECT");
                    Heart.increase();
                    EventListener.step = 1;
                } else {
                    System.out.println("WRONG");
                }
                QuestionFrame.isUp = false;
                Obstacle.generateObstacles();
                Renderer.animator.resume();
            } else if (e.getX() - Renderer.WIDTH / 2 < QuestionFrame.OP3_X_BEGIN && e.getX() - Renderer.WIDTH / 2 > QuestionFrame.OP3_X_END && Renderer.HEIGHT / 2 - 10 - e.getY() < QuestionFrame.OP3_Y_BEGIN && Renderer.HEIGHT / 2 - 10 - e.getY() > QuestionFrame.OP3_Y_END) {
                System.out.println("OP3");
                if (QuestionFrame.answer == 3) {
                    System.out.println("CORRECT");
                    Heart.increase();
                    EventListener.step = 1;
                } else {
                    System.out.println("WRONG");
                }
                QuestionFrame.isUp = false;
                Obstacle.generateObstacles();
                Renderer.animator.resume();
            } else if (e.getX() - Renderer.WIDTH / 2 > QuestionFrame.OP4_X_BEGIN && e.getX() - Renderer.WIDTH / 2 < QuestionFrame.OP4_X_END && Renderer.HEIGHT / 2 - 10 - e.getY() < QuestionFrame.OP4_Y_BEGIN && Renderer.HEIGHT / 2 - 10 - e.getY() > QuestionFrame.OP4_Y_END) {
                System.out.println("OP4");
                if (QuestionFrame.answer == 4) {
                    System.out.println("CORRECT");
                    Heart.increase();
                    EventListener.step = 1;
                } else {
                    System.out.println("WRONG");
                }
                QuestionFrame.isUp = false;
                Obstacle.generateObstacles();
                Renderer.animator.resume();
            } else {
                System.out.println("NONE");
            }
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
