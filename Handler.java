package Snake;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {

    private LinkedList<GameObject> list;
    private boolean up = true;
    private boolean down = false;
    private boolean left = false;
    private boolean right = false;
    private int food = 0;
    
    public Handler() {
        
        list = new LinkedList<GameObject>();
        
    }
    
    
    public void render(Graphics g) {
        
        int listSize = list.size();
        GameObject temp;
        
        for(int i = 0; i < listSize; i++) {
            
            temp = list.get(i);
            temp.render(g);
            
        }
        
    }
    
    public void update() {
        
        int listSize = list.size();
        GameObject temp;
        

        for(int i = 0; i < listSize; i++) {
            
            temp = list.get(i);
            temp.update();
            
        }
        
        
    }
    
    public void add(GameObject temp) {
        
        list.add(temp);
        
    }
    
    public void remove(GameObject temp) {
        
        list.remove(temp);
        
    }
    
    public LinkedList<GameObject> getList() {
        return list;
    }


    public void setList(LinkedList<GameObject> list) {
        this.list = list;
    }


    public boolean isUp() {
        return up;
    }


    public void setUp(boolean up) {
        this.up = up;
    }


    public boolean isDown() {
        return down;
    }


    public void setDown(boolean down) {
        this.down = down;
    }


    public boolean isLeft() {
        return left;
    }


    public void setLeft(boolean left) {
        this.left = left;
    }


    public boolean isRight() {
        return right;
    }


    public void setRight(boolean right) {
        this.right = right;
    }


    public int getFood() {
        return food;
    }


    public void setFood(int food) {
        this.food = food;
    }
    
}
