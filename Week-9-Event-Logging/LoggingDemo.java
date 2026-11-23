import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.util.logging.*;

public class LoggingDemo {
    private static final Logger logger = Logger.getLogger(LoggingDemo.class.getName());

    public static void main(String[] args) {
        logger.setLevel(Level.FINE);
        ConsoleHandler handler = new ConsoleHandler();
        handler.setLevel(Level.FINE);
        logger.addHandler(handler);
        logger.setUseParentHandlers(false);

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Week 9 - Event Logging Demo");
            frame.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 15));

            JTextField textField = new JTextField(18);
            JButton button = new JButton("Click Me");

            button.addActionListener(e ->
                logger.info("Button clicked: " + e.getActionCommand() + " | Thread: " + Thread.currentThread().getName())
            );
            textField.addKeyListener(new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent e) { logger.fine("Key released: " + e.getKeyChar()); }
            });
            textField.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) { logger.info("Text field gained focus"); }
            });

            frame.add(new JLabel("Input:"));
            frame.add(textField);
            frame.add(button);
            frame.setSize(340, 140);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
