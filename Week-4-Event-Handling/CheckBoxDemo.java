
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CheckBoxDemo {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Checkbox Event Demo");

        JCheckBox checkBox = new JCheckBox("I agree to the terms");

        JLabel label = new JLabel("Please select the checkbox");

        checkBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (checkBox.isSelected()) {
                    label.setText("You have agreed!");
                } else {
                    label.setText("You have not agreed.");
                }
            }
        });

        frame.setLayout(new FlowLayout());
        frame.add(checkBox);
        frame.add(label);

        frame.setSize(350, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
