import com.jogamp.opengl.GL2;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class KeyControl implements KeyListener {
static int pressCount = 0;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == KeyEvent.VK_SPACE) {
//            System.out.println(true);
            if (pressCount < 2) {
                Character.status = 1;
                pressCount++;
            }
        }
        //escape key
      if (keyEvent.getKeyCode() == KeyEvent.VK_ESCAPE) {
          if (Renderer.animator.isPaused() && !QuestionFrame.isUp) {
                Renderer.animator.resume();
            } else {
//                NewString.draw("PAUSED", -30, 100);
                Renderer.animator.pause();
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}