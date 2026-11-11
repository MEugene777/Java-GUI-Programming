import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ButtonClickDemo {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Event Handling Demo");

        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JLabel label = new JLabel("Click the button below!");

        JButton button = new JButton("Click Me");

        button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                label.setText("You clicked the button!");

            }

        });

        frame.add(label);
        frame.add(button);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}