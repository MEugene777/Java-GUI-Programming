
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class JFileChooserDemo {

    public static void main(String[] args) {

        JFrame frame = new JFrame("File Chooser Demo");
        frame.setSize(500, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JButton openButton = new JButton("Open File");
        JLabel fileLabel = new JLabel("No file selected");

        openButton.addActionListener(e -> {

            JFileChooser fileChooser = new JFileChooser();

            int result = fileChooser.showOpenDialog(frame);

            if (result == JFileChooser.APPROVE_OPTION) {

                File selectedFile = fileChooser.getSelectedFile();

                fileLabel.setText("Selected: " + selectedFile.getName());

            }
        });

        frame.add(openButton);
        frame.add(fileLabel);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
