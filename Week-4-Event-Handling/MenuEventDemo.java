
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuEventDemo {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Menu Event Demo");

        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");

        JMenuItem newItem = new JMenuItem("New");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem exitItem = new JMenuItem("Exit");

        JLabel label = new JLabel("Select an option from the File menu.");

        newItem.addActionListener(e ->
            label.setText("New file selected.")
        );

        saveItem.addActionListener(e ->
            label.setText("Save option selected.")
        );

        exitItem.addActionListener(e ->
            frame.dispose()
        );

        fileMenu.add(newItem);
        fileMenu.add(saveItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        menuBar.add(fileMenu);

        frame.setJMenuBar(menuBar);

        frame.setLayout(new FlowLayout());
        frame.add(label);

        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
