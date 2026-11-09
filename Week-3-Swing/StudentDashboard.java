
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class StudentDashboard {

    // Store multiple student records
    static ArrayList<String[]> students = new ArrayList<>();

    // Table used to display students
    static DefaultTableModel tableModel;

    public static void main(String[] args) {

        // Add the first student
        students.add(new String[]{
            "Eugene Mukosa",
            "24ZAD110021",
            "BBIT",
            "Final Year"
        });

        // Create the main window
        JFrame frame = new JFrame("Student Dashboard");

        frame.setSize(850, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        // Header
        JLabel title = new JLabel(
            "STUDENT MANAGEMENT SYSTEM",
            SwingConstants.CENTER
        );

        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));

        frame.add(title, BorderLayout.NORTH);

        // Student table
        String[] columns = {
            "Student Name",
            "Admission Number",
            "Course",
            "Year of Study"
        };

        tableModel = new DefaultTableModel(columns, 0);

        JTable studentTable = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(studentTable);

        frame.add(scrollPane, BorderLayout.CENTER);

        // Load existing students into the table
        refreshTable();

        // Navigation panel
        JPanel navigationPanel = new JPanel(
            new FlowLayout(FlowLayout.CENTER)
        );

        JButton homeButton = new JButton("Home");
        JButton studentsButton = new JButton("Students");
        JButton coursesButton = new JButton("Courses");
        JButton reportsButton = new JButton("Reports");

        navigationPanel.add(homeButton);
        navigationPanel.add(studentsButton);
        navigationPanel.add(coursesButton);
        navigationPanel.add(reportsButton);

        // Quick actions panel
        JPanel actionPanel = new JPanel();

        actionPanel.setLayout(
            new BoxLayout(actionPanel, BoxLayout.Y_AXIS)
        );

        actionPanel.setBorder(
            BorderFactory.createEmptyBorder(20, 10, 20, 15)
        );

        JButton addButton = new JButton("Add Student");
        JButton viewButton = new JButton("View Students");
        JButton updateButton = new JButton("Update Student");
        JButton deleteButton = new JButton("Delete Student");
        JButton searchButton = new JButton("Search Student");

        actionPanel.add(addButton);
        actionPanel.add(Box.createVerticalStrut(10));

        actionPanel.add(viewButton);
        actionPanel.add(Box.createVerticalStrut(10));

        actionPanel.add(updateButton);
        actionPanel.add(Box.createVerticalStrut(10));

        actionPanel.add(deleteButton);
        actionPanel.add(Box.createVerticalStrut(10));

        actionPanel.add(searchButton);

        // Combine navigation and actions
        JPanel bottomPanel = new JPanel(new BorderLayout());

        bottomPanel.add(navigationPanel, BorderLayout.CENTER);
        bottomPanel.add(actionPanel, BorderLayout.EAST);

        frame.add(bottomPanel, BorderLayout.SOUTH);

        // Add student
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
                        "Please fill in all student details."
                    );

                } else if (findStudent(admission) != -1) {

                    JOptionPane.showMessageDialog(
                        frame,
                        "That admission number already exists."
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

        // View students
        viewButton.addActionListener(e -> {

            refreshTable();

            JOptionPane.showMessageDialog(
                frame,
                "Total registered students: " + students.size()
            );
        });

        // Update student
        updateButton.addActionListener(e -> {

            String admission = JOptionPane.showInputDialog(
                frame,
                "Enter the admission number of the student to update:"
            );

            if (admission == null) {
                return;
            }

            int index = findStudent(admission.trim());

            if (index == -1) {

                JOptionPane.showMessageDialog(
                    frame,
                    "Student not found."
                );

            } else {

                JTextField nameField = new JTextField(students.get(index)[0]);
                JTextField courseField = new JTextField(students.get(index)[2]);
                JTextField yearField = new JTextField(students.get(index)[3]);

                Object[] fields = {
                    "New Student Name:", nameField,
                    "New Course:", courseField,
                    "New Year of Study:", yearField
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

                        students.get(index)[0] = nameField.getText().trim();
                        students.get(index)[2] = courseField.getText().trim();
                        students.get(index)[3] = yearField.getText().trim();

                        refreshTable();

                        JOptionPane.showMessageDialog(
                            frame,
                            "Student updated successfully!"
                        );
                    }
                }
            }
        });

        // Delete student
        deleteButton.addActionListener(e -> {

            String admission = JOptionPane.showInputDialog(
                frame,
                "Enter the admission number of the student to delete:"
            );

            if (admission == null) {
                return;
            }

            int index = findStudent(admission.trim());

            if (index == -1) {

                JOptionPane.showMessageDialog(
                    frame,
                    "Student not found."
                );

            } else {

                int choice = JOptionPane.showConfirmDialog(
                    frame,
                    "Are you sure you want to delete "
                        + students.get(index)[0] + "?",
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

        // Search student
        searchButton.addActionListener(e -> {

            String admission = JOptionPane.showInputDialog(
                frame,
                "Enter admission number to search:"
            );

            if (admission == null) {
                return;
            }

            int index = findStudent(admission.trim());

            if (index == -1) {

                JOptionPane.showMessageDialog(
                    frame,
                    "Student not found."
                );

            } else {

                String[] student = students.get(index);

                JOptionPane.showMessageDialog(
                    frame,
                    "Student Name: " + student[0] + "\n"
                    + "Admission Number: " + student[1] + "\n"
                    + "Course: " + student[2] + "\n"
                    + "Year of Study: " + student[3],
                    "Student Details",
                    JOptionPane.INFORMATION_MESSAGE
                );
            }
        });

        // Navigation buttons
        homeButton.addActionListener(e ->
            JOptionPane.showMessageDialog(frame, "Welcome to Home!")
        );

        studentsButton.addActionListener(e ->
            JOptionPane.showMessageDialog(
                frame,
                "Registered Students: " + students.size()
            )
        );

        coursesButton.addActionListener(e ->
            JOptionPane.showMessageDialog(frame, "BBIT Course Section")
        );

        reportsButton.addActionListener(e ->
            JOptionPane.showMessageDialog(
                frame,
                "Total Students: " + students.size()
            )
        );

        // Display window
        frame.setVisible(true);
    }

    // Refresh the student table
    public static void refreshTable() {

        tableModel.setRowCount(0);

        for (String[] student : students) {
            tableModel.addRow(student);
        }
    }

    // Find a student using admission number
    public static int findStudent(String admission) {

        for (int i = 0; i < students.size(); i++) {

            if (students.get(i)[1].equalsIgnoreCase(admission)) {
                return i;
            }
        }

        return -1;
    }
}
