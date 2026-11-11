
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class ListSelectionDemo {

    public static void main(String[] args) {

        JFrame frame = new JFrame("List Selection Demo");

        String[] languages = {
            "Java",
            "Python",
            "JavaScript",
            "C++",
            "PHP"
        };

        JList<String> list = new JList<>(languages);

        list.setSelectionMode(
            ListSelectionModel.SINGLE_SELECTION
        );

        JLabel result = new JLabel("Select a programming language.");

        list.addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {

                if (!e.getValueIsAdjusting()) {

                    String selected = list.getSelectedValue();

                    result.setText("Selected: " + selected);
                }
            }
        });

        frame.setLayout(new FlowLayout());

        frame.add(new JScrollPane(list));
        frame.add(result);

        frame.setSize(350, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
