
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseMotionListenerDemo {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Mouse Motion Demo");

        JPanel panel = new JPanel();

        JLabel label = new JLabel("Move your mouse inside the window.");

        panel.add(label);

        panel.addMouseMotionListener(new MouseMotionListener() {

            public void mouseMoved(MouseEvent e) {
                label.setText("Mouse position: X = "
                    + e.getX() + ", Y = " + e.getY());
            }

            public void mouseDragged(MouseEvent e) {
                label.setText("Mouse is being dragged!");
            }
        });

        frame.add(panel);

        frame.setSize(450, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
