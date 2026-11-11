
import javax.swing.*;
import java.awt.*;

public class JToolBarDemo {

    public static void main(String[] args) {

        JFrame frame = new JFrame("JToolBar Demo");
        frame.setSize(550, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JToolBar toolBar = new JToolBar();

        JButton newButton = new JButton("New");
        JButton openButton = new JButton("Open");
        JButton saveButton = new JButton("Save");

        newButton.addActionListener(e ->
                JOptionPane.showMessageDialog(frame, "New document created"));

        openButton.addActionListener(e ->
                JOptionPane.showMessageDialog(frame, "Open button clicked"));

        saveButton.addActionListener(e ->
                JOptionPane.showMessageDialog(frame, "Document saved"));

        toolBar.add(newButton);
        toolBar.add(openButton);
        toolBar.add(saveButton);

        JTextArea textArea = new JTextArea();
        textArea.setText("Welcome to the toolbar demonstration!");

        frame.add(toolBar, BorderLayout.NORTH);
        frame.add(new JScrollPane(textArea), BorderLayout.CENTER);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
