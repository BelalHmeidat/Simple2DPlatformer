import com.jogamp.newt.event.KeyListener;

import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.KeyListener;

public class KeyControl implements KeyListener{

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if(keyEvent.getKeyCode() == KeyEvent.VK_K)
            System.out.println(true);
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}