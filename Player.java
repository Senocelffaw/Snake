package Snake;

import java.awt.Color;
import java.awt.Graphics;

public class Player extends GameObject{

    public Player(int x, int y) {
        super(x, y);
        setWidth(10);
        setHeight(10);
        setxVel(0);
        setyVel(0);
    }
    
    public void update() {
        
    }
    
    public void render(Graphics g) {
        
        g.setColor(Color.black);
        g.fillRect(getX(), getY(), getWidth(), getHeight());
        
    }
    
}
