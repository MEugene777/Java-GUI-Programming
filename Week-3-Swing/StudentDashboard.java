
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.ArrayList;

public class StudentDashboard {

    static ArrayList<String[]> students = new ArrayList<>();
    static DefaultTableModel tableModel;
    static JLabel countLabel;

    static Color navyBlue = new Color(25, 45, 75);
    static Color accentBlue = new Color(45, 110, 200);
    static Color lightBackground = new Color(240, 243, 248);
    static Color white = Color.WHITE;

    public static void main(String[] args) {

        students.add(new String[]{
            "Eugene Mukosa",
            "24ZAD110021",
            "BBIT",
            "Final Year"
        });

        JFrame frame = new JFrame("Student Management System");

        frame.setSize(1000, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        frame.getContentPane().setBackground(lightBackground);

        // HEADER
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(navyBlue);
        header.setBorder(BorderFactory.createEmptyBorder(20, 25, 20, 25));

        JLabel title = new JLabel("STUDENT MANAGEMENT SYSTEM");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setForeground(white);

        countLabel = new JLabel();
        countLabel.setFont(new Font("Arial", Font.BOLD, 15));
        countLabel.setForeground(white);

        header.add(title, BorderLayout.WEST);
        header.add(countLabel, BorderLayout.EAST);

        frame.add(header, BorderLayout.NORTH);

        // TABLE
        String[] columns = {
            "Student Name",
            "Admission Number",
            "Course",
            "Year of Study"
        };

        tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        JTable studentTable = new JTable(tableModel);
        studentTable.setRowHeight(32);
        studentTable.setFont(new Font("Arial", Font.PLAIN, 14));
        studentTable.setSelectionBackground(new Color(210, 225, 245));
        studentTable.setSelectionForeground(Color.BLACK);

        JTableHeader tableHeader = studentTable.getTableHeader();
        tableHeader.setBackground(navyBlue);
        tableHeader.setForeground(white);
        tableHeader.setFont(new Font("Arial", Font.BOLD, 14));
        tableHeader.setPreferredSize(new Dimension(100, 40));

        JScrollPane scrollPane = new JScrollPane(studentTable);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());

        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBackground(lightBackground);
        centerPanel.setBorder(
            BorderFactory.createEmptyBorder(25, 25, 25, 25)
        );

        JLabel sectionTitle = new JLabel("Registered Students");
        sectionTitle.setFont(new Font("Arial", Font.BOLD, 20));
        sectionTitle.setForeground(navyBlue);
        sectionTitle.setBorder(
            BorderFactory.createEmptyBorder(0, 0, 15, 0)
        );

        centerPanel.add(sectionTitle, BorderLayout.NORTH);
        centerPanel.add(scrollPane, BorderLayout.CENTER);

        frame.add(centerPanel, BorderLayout.CENTER);

        // ACTION PANEL
        JPanel actionPanel = new JPanel();
        actionPanel.setLayout(
            new BoxLayout(actionPanel, BoxLayout.Y_AXIS)
        );

        actionPanel.setBackground(white);
        actionPanel.setBorder(
            BorderFactory.createEmptyBorder(25, 15, 25, 15)
        );

        JButton addButton = createButton("Add Student");
        JButton viewButton = createButton("View Students");
        JButton updateButton = createButton("Update Student");
        JButton deleteButton = createButton("Delete Student");
        JButton searchButton = createButton("Search Student");

        actionPanel.add(addButton);
        actionPanel.add(Box.createVerticalStrut(15));
        actionPanel.add(viewButton);
        actionPanel.add(Box.createVerticalStrut(15));
        actionPanel.add(updateButton);
        actionPanel.add(Box.createVerticalStrut(15));
        actionPanel.add(deleteButton);
        actionPanel.add(Box.createVerticalStrut(15));
        actionPanel.add(searchButton);

        frame.add(actionPanel, BorderLayout.EAST);

        // ADD STUDENT
        addButton.addActionListener(e -> {

            JTextField nameField = new JTextField();
            JTextField admissionField = new JTextField();
            JTextField courseField = new JTextField();
            JTextField yearField = new JTextField();

            Object[] fields = {
                "Student Name:", nameField,
                "Admission Number:", admissionField,
                "Course:", courseField,
                "Year of Study:", yearField
            };

            int result = JOptionPane.showConfirmDialog(
                frame,
                fields,
                "Register New Student",
                JOptionPane.OK_CANCEL_OPTION
            );

            if (result == JOptionPane.OK_OPTION) {

                String name = nameField.getText().trim();
                String admission = admissionField.getText().trim();
                String course = courseField.getText().trim();
                String year = yearField.getText().trim();

                if (name.isEmpty() || admission.isEmpty()
                        || course.isEmpty() || year.isEmpty()) {

                    JOptionPane.showMessageDialog(
                        frame,
                        "Please fill in all fields."
                    );

                } else if (findStudent(admission) != -1) {

                    JOptionPane.showMessageDialog(
                        frame,
                        "Admission number already exists."
                    );

                } else {

                    students.add(new String[]{
                        name, admission, course, year
                    });

                    refreshTable();

                    JOptionPane.showMessageDialog(
                        frame,
                        "Student registered successfully!"
                    );
                }
            }
        });

        // VIEW STUDENTS
        viewButton.addActionListener(e -> {

            refreshTable();

            JOptionPane.showMessageDialog(
                frame,
                "Total registered students: " + students.size()
            );
        });

        // UPDATE STUDENT
        updateButton.addActionListener(e -> {

            String admission = JOptionPane.showInputDialog(
                frame,
                "Enter admission number:"
            );

            if (admission == null) return;

            int index = findStudent(admission.trim());

            if (index == -1) {

                JOptionPane.showMessageDialog(frame, "Student not found.");

            } else {

                JTextField nameField =
                    new JTextField(students.get(index)[0]);

                JTextField courseField =
                    new JTextField(students.get(index)[2]);

                JTextField yearField =
                    new JTextField(students.get(index)[3]);

                Object[] fields = {
                    "Student Name:", nameField,
                    "Course:", courseField,
                    "Year of Study:", yearField
                };

                int result = JOptionPane.showConfirmDialog(
                    frame,
                    fields,
                    "Update Student",
                    JOptionPane.OK_CANCEL_OPTION
                );

                if (result == JOptionPane.OK_OPTION) {

                    if (nameField.getText().trim().isEmpty()
                            || courseField.getText().trim().isEmpty()
                            || yearField.getText().trim().isEmpty()) {

                        JOptionPane.showMessageDialog(
                            frame,
                            "Please fill in all fields."
                        );

                    } else {

                        students.get(index)[0] =
                            nameField.getText().trim();

                        students.get(index)[2] =
                            courseField.getText().trim();

                        students.get(index)[3] =
                            yearField.getText().trim();

                        refreshTable();

                        JOptionPane.showMessageDialog(
                            frame,
                            "Student updated successfully!"
                        );
                    }
                }
            }
        });

        // DELETE STUDENT
        deleteButton.addActionListener(e -> {

            String admission = JOptionPane.showInputDialog(
                frame,
                "Enter admission number:"
            );

            if (admission == null) return;

            int index = findStudent(admission.trim());

            if (index == -1) {

                JOptionPane.showMessageDialog(frame, "Student not found.");

            } else {

                int choice = JOptionPane.showConfirmDialog(
                    frame,
                    "Delete " + students.get(index)[0] + "?",
                    "Confirm Deletion",
                    JOptionPane.YES_NO_OPTION
                );

                if (choice == JOptionPane.YES_OPTION) {

                    students.remove(index);
                    refreshTable();

                    JOptionPane.showMessageDialog(
                        frame,
                        "Student deleted successfully!"
                    );
                }
            }
        });

        // SEARCH STUDENT
        searchButton.addActionListener(e -> {

            String admission = JOptionPane.showInputDialog(
                frame,
                "Enter admission number to search:"
            );

            if (admission == null) return;

            int index = findStudent(admission.trim());

            if (index == -1) {

                JOptionPane.showMessageDialog(frame, "Student not found.");

            } else {

                String[] student = students.get(index);

                JOptionPane.showMessageDialog(
                    frame,
                    "Name: " + student[0] + "\n"
                    + "Admission Number: " + student[1] + "\n"
                    + "Course: " + student[2] + "\n"
                    + "Year: " + student[3],
                    "Student Details",
                    JOptionPane.INFORMATION_MESSAGE
                );
            }
        });

        refreshTable();

        frame.setVisible(true);
    }

    // CREATE STYLED BUTTONS
    public static JButton createButton(String text) {

        JButton button = new JButton(text);

        button.setFont(new Font("Arial", Font.BOLD, 13));
        button.setBackground(accentBlue);
        button.setForeground(white);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setMaximumSize(new Dimension(170, 40));
        button.setPreferredSize(new Dimension(170, 40));

        return button;
    }

    // REFRESH TABLE AND STUDENT COUNT
    public static void refreshTable() {

        tableModel.setRowCount(0);

        for (String[] student : students) {
            tableModel.addRow(student);
        }

        countLabel.setText("Total Students: " + students.size());
    }

    // FIND STUDENT BY ADMISSION NUMBER
    public static int findStudent(String admission) {

        for (int i = 0; i < students.size(); i++) {

            if (students.get(i)[1].equalsIgnoreCase(admission)) {
                return i;
            }
        }

        return -1;
    }
}
