
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TextFieldEventDemo {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Text Field Event Demo");

        JLabel label = new JLabel("Enter your name:");

        JTextField textField = new JTextField(15);

        JButton button = new JButton("Submit");

        JLabel result = new JLabel("Your name will appear here.");

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String name = textField.getText();

                result.setText("Welcome, " + name + "!");
            }
        });

        frame.setLayout(new FlowLayout());

        frame.add(label);
        frame.add(textField);
        frame.add(button);
        frame.add(result);

        frame.setSize(400, 180);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
