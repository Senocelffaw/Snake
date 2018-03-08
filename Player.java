package Snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

public class Player extends GameObject{
    
    private Handler handler;
    private static int speed = 15;
    private LinkedList<SnakeBody> body;
    public int snakeLength;
    
    public Player(int x, int y, Handler handler) {
        super(x, y);
        this.handler = handler;
        setWidth(15);
        setHeight(15);
        setxVel(0);
        setyVel(0);
        setID(ObjectID.player);
        snakeLength = 0;
        setBody(new LinkedList<SnakeBody>());
    }
    
    public void update() {
        
        movement();
        
    }
    
    public void render(Graphics g) {
        
        g.setColor(Color.black);
        g.fillRect(getX(), getY(), getWidth(), getHeight());

    }
    
    
    public void movement() {
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
    
    public Rectangle getBounds() {
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }

    public LinkedList<SnakeBody> getBody() {
        return body;
    }

    public void setBody(LinkedList<SnakeBody> linkedList) {
        this.body = linkedList;
    }
    
}
