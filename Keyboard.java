package Snake;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Keyboard extends KeyAdapter{
    
    private Handler handler;
    
    public Keyboard(Handler handler) {
        this.handler = handler;
    }
    
    public void keyPressed(KeyEvent e) {
        
        int temp = e.getKeyCode();
        
        if(temp == KeyEvent.VK_UP && !handler.isDown()) {
            handler.setUp(true);
            handler.setDown(false);
            handler.setLeft(false);
            handler.setRight(false);
        }
        else if(temp == KeyEvent.VK_DOWN && !handler.isUp()) {
            handler.setUp(false);
            handler.setDown(true);
            handler.setLeft(false);
            handler.setRight(false);
        }
        else if(temp == KeyEvent.VK_LEFT && !handler.isRight()) {
            handler.setUp(false);
            handler.setDown(false);
            handler.setLeft(true);
            handler.setRight(false);
        }
        else if(temp == KeyEvent.VK_RIGHT && !handler.isLeft()) {
            handler.setUp(false);
            handler.setDown(false);
            handler.setLeft(false);
            handler.setRight(true);
        }
        
    }
    
}
