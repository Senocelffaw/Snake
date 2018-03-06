package Snake;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class SnakeGame extends Canvas implements Runnable{
    
    private static final long serialVersionUID = 1L;
    private static int width = 1000;
    private static int height = 600;
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
        handler.add(new Player(500,300, handler));
        this.addKeyListener(new Keyboard(handler));
        start();
        
    }
    
    public void update() {
        handler.update();
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
