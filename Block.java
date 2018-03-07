package Snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Block extends GameObject{

    private Handler handler;

    public Block(int x, int y, Handler handler) {
        super(x, y);
        this.handler = handler;
        setWidth(15);
        setHeight(15);
        setxVel(0);
        setyVel(0);
        setID(ObjectID.block);
    }
    
    public void update() {
        GameObject temp;
        
        for(int i = 0; i < handler.getList().size(); i++) {
            
            temp = handler.getList().get(i);
            
            if(temp.getID() == ObjectID.player) {
                
                if(temp.getBounds().intersects(this.getBounds())) {
                    
                    Random rand = new Random(System.currentTimeMillis());
                    int r = rand.nextInt(67) * 15;
                    int ry = rand.nextInt(41) * 15;

                    handler.add( new Block(r, ry, handler) );
                    handler.getList().remove(this);
                    
                }
                
            }
            
        }
        
    }
    
    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(getX(), getY(), getWidth(), getHeight());
    }
    
    public Rectangle getBounds() {
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }

}
