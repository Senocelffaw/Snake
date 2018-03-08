package Snake;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class SnakeGame extends Canvas implements Runnable{
    
    private static final long serialVersionUID = 1L;
    private static int width = 993;
    private static int height = 602;
    private static String title = "Snake Game";
    private Thread thread;
    private Handler handler;
    private boolean isRunning;
    
    public static void main(String args[]) {
        
        new SnakeGame();
        
    }
    
    public SnakeGame() {
        
        new Window(width, height, title, this);
        handler = new Handler();
        handler.add(new Player(510, 300, handler));
        this.addKeyListener(new Keyboard(handler));
        handler.add(new Block(570, 360, handler));
        start();
        
    }
    
    public void reset() {
        
        while(handler.getList().size() != 0) {
            handler.getList().remove(0);
        }
        
        handler.add(new Player(510, 300, handler));
        handler.add(new Block(570, 360, handler));
        
    }
    
    public void update() {
        
        handler.update();
        outOfBounds();
        
    }
    
    public void outOfBounds() {
        
        GameObject temp;
            
        for(int i = 0; i < handler.getList().size(); i++) {
            
            temp = handler.getList().get(i);
            
            if(temp.getID() == ObjectID.player) {
                
                if(temp.getX() + temp.getWidth() + 15 > width || temp.getX() < 0) {
                    reset();
                }
                else if(temp.getY() + temp.getHeight()+45 > height || temp.getY() < 0) {
                    reset();
                }
                
            }
        }
        
    }
    
    public void render() {
        
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null) {
            
            this.createBufferStrategy(3);
            bs = this.getBufferStrategy();
            
        }
        
        Graphics g = bs.getDrawGraphics();
        //////////////////////////////////////// 
        ////draw graphics

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);
        
        
        handler.render(g);
        
        ////////////////////////////////////////
        g.dispose();
        bs.show();
        
        
    }


    public void run() {
        
        this.requestFocus();
        
        long lastTime = System.nanoTime();
        double amountOfTicks = 15.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        
        while(isRunning) {
            
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            
            while(delta >= 1) {
                
                update();
                delta--;
                
            }
            
            render();
            
            if(System.currentTimeMillis() - timer > 1000) {
                
                timer += 1000;
                
            }
            
        }
        
        stop();
        
    }
    
    private void start() {
        
        isRunning = true;
        thread = new Thread(this);
        thread.start();
        
    }
    
    private void stop() {
        
        try {
            thread.join();
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
        
    }
    
}
