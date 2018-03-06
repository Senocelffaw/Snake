package Snake;

public class Block extends GameObject{

    private Handler handler;

    public Block(int x, int y, Handler handler) {
        super(x, y);
        this.handler = handler;
        setWidth(15);
        setHeight(15);
        setxVel(0);
        setyVel(0);
    }

}
