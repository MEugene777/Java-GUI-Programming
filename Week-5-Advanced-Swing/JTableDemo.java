
import javax.swing.*;
import java.awt.*;

public class JTableDemo {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Student Records");
        frame.setSize(600, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] columns = {"ID", "Name", "Course", "Year"};

        String[][] data = {
            {"001", "Eugene", "BBIT", "4"},
            {"002", "Brian", "Computer Science", "3"},
            {"003", "Mary", "Information Technology", "2"},
            {"004", "John", "Software Engineering", "4"}
        };

        JTable table = new JTable(data, columns);

        JScrollPane scrollPane = new JScrollPane(table);

        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
