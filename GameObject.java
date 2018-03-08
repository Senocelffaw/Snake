package Snake;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {
    
    private int x;
    private int y;
    private int xVel;
    private int yVel;
    private int width;
    private int height;
    private ObjectID ID;
    
    public GameObject(int x, int y) {
        
        this.x = x;
        this.y = y;
        
    }
    
    public void update() {
        
    }
    
    public void update(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public void render(Graphics g) {
        
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getxVel() {
        return xVel;
    }

    public void setxVel(int xVel) {
        this.xVel = xVel;
    }

    public int getyVel() {
        return yVel;
    }

    public void setyVel(int yVel) {
        this.yVel = yVel;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
    public Rectangle getBounds() {
        return null;
    }

    public ObjectID getID() {
        return ID;
    }

    public void setID(ObjectID iD) {
        ID = iD;
    }
}
