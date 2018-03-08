package Snake;

import java.awt.Color;
import java.awt.Graphics;

public class SnakeBody extends GameObject{

    public SnakeBody(int x, int y) {
        super(x, y);
        setWidth(15);
        setHeight(15);
    }
    
    public void update(int newX, int newY) {
        
        setX(newX);
        setY(newY);
        
    }
    
    public void render(Graphics g) {

        g.setColor(Color.BLACK);
        g.fillRect(getX(), getY(), getWidth(), getHeight());
        
    }
}
