import javax.swing.*;
import java.awt.*;
// todo [secondary timer for falling pieces so that refresh timer can be much faster]

public class Tetris {
    public static void main(String[] args){
        JFrame frame = new JFrame("Tetris");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        DrawingPanel mainPanel = new DrawingPanel();
        mainPanel.setPreferredSize(new Dimension(400,600));
        mainPanel.setBackground(Color.white);
        frame.getContentPane().add(mainPanel);
        frame.pack();

        Timer t = new Timer(40,mainPanel);
        t.start();

        mainPanel.addMouseListener(mainPanel);
        mainPanel.addMouseMotionListener(mainPanel);
        frame.addKeyListener(mainPanel);

        //Player player = new Player("P1");


    }
}
