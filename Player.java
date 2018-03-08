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
        this.getBody().add(new SnakeBody(this.getX(), this.getY()));
        this.getBody().add(new SnakeBody(this.getX(), this.getY()));
    }
    
    public void update() {
        
        movement();
        follow();        
        
    }
    
    public void render(Graphics g) {
        
        g.setColor(Color.black);
        g.fillRect(getX(), getY(), getWidth(), getHeight());
        
        g.setColor(Color.BLACK);
        int listSize = this.body.size();
        GameObject temp;
        
        for(int i = 0; i < listSize; i++) {
            
            temp = this.body.get(i);
            temp.render(g);
            
        }

    }
    
    public void follow() {
        
        this.body.get(0).update(this.getX(), this.getY());
        
        if(this.body.size() >= 1) {
            for(int i = this.body.size() - 1; i >= 1; i--) {
                this.body.get(i).update(this.body.get(i-1).getX(), this.body.get(i-1).getY());
            }
        }
        
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
