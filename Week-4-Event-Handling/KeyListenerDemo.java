
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KeyListenerDemo {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Key Listener Demo");

        JLabel label = new JLabel("Type something below:");

        JTextField textField = new JTextField(20);

        JLabel result = new JLabel("Waiting for keyboard input...");

        textField.addKeyListener(new KeyListener() {

            public void keyTyped(KeyEvent e) {
                result.setText("Key typed: " + e.getKeyChar());
            }

            public void keyPressed(KeyEvent e) {
                System.out.println("Key pressed: " + e.getKeyCode());
            }

            public void keyReleased(KeyEvent e) {
                System.out.println("Key released: " + e.getKeyCode());
            }
        });

        frame.setLayout(new FlowLayout());

        frame.add(label);
        frame.add(textField);
        frame.add(result);

        frame.setSize(400, 180);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
