
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RadioButtonDemo {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Radio Button Demo");

        JLabel label = new JLabel("Select your favourite language:");

        JRadioButton java = new JRadioButton("Java");
        JRadioButton python = new JRadioButton("Python");
        JRadioButton javascript = new JRadioButton("JavaScript");

        ButtonGroup group = new ButtonGroup();

        group.add(java);
        group.add(python);
        group.add(javascript);

        JLabel result = new JLabel("Your selection will appear here.");

        ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                result.setText("You selected: " + e.getActionCommand());
            }
        };

        java.addActionListener(listener);
        python.addActionListener(listener);
        javascript.addActionListener(listener);

        frame.setLayout(new FlowLayout());

        frame.add(label);
        frame.add(java);
        frame.add(python);
        frame.add(javascript);
        frame.add(result);

        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
