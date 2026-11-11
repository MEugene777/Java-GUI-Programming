
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ComboBoxEventDemo {

    public static void main(String[] args) {

        JFrame frame = new JFrame("ComboBox Event Demo");

        JLabel label = new JLabel("Select your course:");

        String[] courses = {
            "Cybersecurity",
            "Software Engineering",
            "Data Science",
            "Networking"
        };

        JComboBox<String> comboBox = new JComboBox<>(courses);

        JLabel result = new JLabel("Your course will appear here.");

        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String selectedCourse =
                    (String) comboBox.getSelectedItem();

                result.setText("Selected course: " + selectedCourse);
            }
        });

        frame.setLayout(new FlowLayout());

        frame.add(label);
        frame.add(comboBox);
        frame.add(result);

        frame.setSize(400, 180);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
