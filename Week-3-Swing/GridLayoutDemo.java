import javax.swing.*;
import java.awt.*;

public class GridLayoutDemo {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Grid Layout Demo");

        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(3, 2, 10, 10));

        panel.add(new JButton("Button 1"));
        panel.add(new JButton("Button 2"));
        panel.add(new JButton("Button 3"));
        panel.add(new JButton("Button 4"));

        frame.add(panel);

        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}