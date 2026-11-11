
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseListenerDemo {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Mouse Listener Demo");

        JPanel panel = new JPanel();

        JLabel label = new JLabel("Interact with the mouse inside this window.");

        panel.add(label);

        panel.addMouseListener(new MouseListener() {

            public void mouseClicked(MouseEvent e) {
                label.setText("Mouse clicked!");
            }

            public void mousePressed(MouseEvent e) {
                label.setText("Mouse pressed!");
            }

            public void mouseReleased(MouseEvent e) {
                label.setText("Mouse released!");
            }

            public void mouseEntered(MouseEvent e) {
                label.setText("Mouse entered the panel!");
            }

            public void mouseExited(MouseEvent e) {
                label.setText("Mouse exited the panel!");
            }
        });

        frame.add(panel);

        frame.setSize(450, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
