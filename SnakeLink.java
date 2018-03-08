package Snake;

import java.util.LinkedList;

public class SnakeLink extends GameObject{
    
    private Handler handler;
    private LinkedList<GameObject> snake;

    public SnakeLink(int x, int y, Handler handler) {
        super(x, y);
        this.handler = handler;
        this.snake = new LinkedList<GameObject>();
        this.snake.add(new Player(this.getX(), this.getY(),handler));
    }
    
    public void update() {

        if(this.snake.size() > 1) {
            for(int i = this.snake.size(); i > 1; i++) {
//                this.snake.get(i)
            }
        }
        
    }
}
