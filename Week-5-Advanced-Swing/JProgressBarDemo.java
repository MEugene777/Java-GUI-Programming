
import javax.swing.*;
import java.awt.*;

public class JProgressBarDemo {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Progress Bar Demo");
        frame.setSize(450, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JProgressBar progressBar = new JProgressBar(0, 100);
        progressBar.setValue(0);
        progressBar.setStringPainted(true);

        JButton startButton = new JButton("Start Task");

        startButton.addActionListener(e -> {
            startButton.setEnabled(false);

            Timer timer = new Timer(100, null);

            timer.addActionListener(event -> {
                int value = progressBar.getValue();

                if (value < 100) {
                    progressBar.setValue(value + 5);
                } else {
                    timer.stop();
                    startButton.setEnabled(true);
                    startButton.setText("Completed");
                }
            });

            timer.start();
        });

        frame.setLayout(new FlowLayout());
        frame.add(new JLabel("Task Progress:"));
        frame.add(progressBar);
        frame.add(startButton);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
