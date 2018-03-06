package Snake;

import java.awt.Color;
import java.awt.Graphics;

public class Player extends GameObject{
    
    private Handler handler;
    private static int speed = 15;

    public Player(int x, int y, Handler handler) {
        super(x, y);
        this.handler = handler;
        setWidth(15);
        setHeight(15);
        setxVel(0);
        setyVel(0);
    }
    
    public void update() {
       setX(getX() + getxVel());
       setY(getY() + getyVel());
       
       if(handler.isUp()) {
           setyVel(-speed);
           setxVel(0);
       }
       else if(handler.isDown()) {
           setyVel(speed);
           setxVel(0);
       }
       else if(handler.isRight()) {
           setxVel(speed);
           setyVel(0);
       }
       else {
           setxVel(-speed);
           setyVel(0);
       }
    }
    
    public void render(Graphics g) {
        
        g.setColor(Color.black);
        g.fillRect(getX(), getY(), getWidth(), getHeight());
        
    }
    
}
