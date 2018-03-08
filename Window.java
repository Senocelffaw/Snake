package Snake;

import java.awt.Dimension;
import javax.swing.JFrame;

public class Window{

    public Window(int width, int height, String title, SnakeGame game) {
        
        JFrame frame = new JFrame(title);
        
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        
        frame.add(game);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
//        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
