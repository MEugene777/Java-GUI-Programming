
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FocusListenerDemo {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Focus Listener Demo");

        JLabel label = new JLabel("Click inside the text field.");

        JTextField textField = new JTextField(15);

        textField.addFocusListener(new FocusListener() {

            public void focusGained(FocusEvent e) {
                label.setText("Text field gained focus!");
            }

            public void focusLost(FocusEvent e) {
                label.setText("Text field lost focus!");
            }
        });

        frame.setLayout(new FlowLayout());

        frame.add(textField);
        frame.add(label);

        frame.setSize(400, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
