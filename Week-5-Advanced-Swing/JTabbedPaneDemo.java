
import javax.swing.*;
import java.awt.*;

public class JTabbedPaneDemo {

    public static void main(String[] args) {

        JFrame frame = new JFrame("JTabbedPane Demo");
        frame.setSize(500, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane tabs = new JTabbedPane();

        JPanel homePanel = new JPanel();
        homePanel.add(new JLabel("Welcome to the Home Page"));

        JPanel profilePanel = new JPanel();
        profilePanel.add(new JLabel("This is the Profile Page"));

        JPanel settingsPanel = new JPanel();
        settingsPanel.add(new JLabel("Application Settings"));

        tabs.addTab("Home", homePanel);
        tabs.addTab("Profile", profilePanel);
        tabs.addTab("Settings", settingsPanel);

        frame.add(tabs, BorderLayout.CENTER);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
