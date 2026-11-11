
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WindowListenerDemo {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Window Listener Demo");

        JLabel label = new JLabel("Interact with this window.");

        frame.setLayout(new FlowLayout());
        frame.add(label);

        frame.addWindowListener(new WindowListener() {

            public void windowOpened(WindowEvent e) {
                System.out.println("Window opened.");
            }

            public void windowClosing(WindowEvent e) {
                System.out.println("Window is closing.");
            }

            public void windowClosed(WindowEvent e) {
                System.out.println("Window closed.");
            }

            public void windowIconified(WindowEvent e) {
                System.out.println("Window minimized.");
            }

            public void windowDeiconified(WindowEvent e) {
                System.out.println("Window restored.");
            }

            public void windowActivated(WindowEvent e) {
                System.out.println("Window activated.");
            }

            public void windowDeactivated(WindowEvent e) {
                System.out.println("Window deactivated.");
            }
        });

        frame.setSize(400, 180);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }
}
