import javax.swing.*;
import java.awt.*;

public class MyFirstSwingApp {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            JFrame frame = new JFrame("My First Swing Application");

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500, 400);
            frame.setLocationRelativeTo(null);

            JPanel panel = new JPanel();
            panel.setLayout(new FlowLayout());

            JLabel label = new JLabel("Welcome to Java Swing!");

            JButton button = new JButton("Click Me");

            button.addActionListener(e ->
                label.setText("You clicked the button!")
            );

            panel.add(label);
            panel.add(button);

            frame.add(panel);
            frame.setVisible(true);

        });
    }
}