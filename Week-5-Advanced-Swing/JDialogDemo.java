
import javax.swing.*;
import java.awt.*;

public class JDialogDemo {

    public static void main(String[] args) {

        JFrame frame = new JFrame("JDialog Demo");
        frame.setSize(450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button = new JButton("Open Dialog");

        button.addActionListener(e -> {

            JDialog dialog = new JDialog(frame, "Confirmation", true);

            JLabel message = new JLabel("Welcome! This is a dialog window.");

            JButton closeButton = new JButton("Close");

            closeButton.addActionListener(event -> dialog.dispose());

            dialog.setLayout(new FlowLayout());
            dialog.add(message);
            dialog.add(closeButton);

            dialog.setSize(300, 150);
            dialog.setLocationRelativeTo(frame);
            dialog.setVisible(true);
        });

        frame.setLayout(new FlowLayout());
        frame.add(button);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
