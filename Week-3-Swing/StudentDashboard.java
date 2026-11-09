
import javax.swing.*;
import java.awt.*;

public class StudentDashboard {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Student Dashboard");

        frame.setSize(700, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // Student information
        String[] student = {
            "Eugene Mukosa",
            "24ZAD110021",
            "BBIT",
            "Final Year"
        };

        // Main header
        JPanel header = new JPanel(
            new FlowLayout(FlowLayout.CENTER)
        );

        JLabel title = new JLabel("STUDENT MANAGEMENT SYSTEM");
        title.setFont(new Font("Arial", Font.BOLD, 22));

        header.add(title);

        // Navigation buttons
        JPanel navigationPanel = new JPanel(
            new FlowLayout(FlowLayout.CENTER, 15, 10)
        );

        JButton homeButton = new JButton("Home");
        JButton studentsButton = new JButton("Students");
        JButton coursesButton = new JButton("Courses");
        JButton reportsButton = new JButton("Reports");

        navigationPanel.add(homeButton);
        navigationPanel.add(studentsButton);
        navigationPanel.add(coursesButton);
        navigationPanel.add(reportsButton);

        // Top section
        JPanel topPanel = new JPanel();

        topPanel.setLayout(
            new BoxLayout(topPanel, BoxLayout.Y_AXIS)
        );

        topPanel.add(header);
        topPanel.add(navigationPanel);

        frame.add(topPanel, BorderLayout.NORTH);

        // Student information panel
        JPanel studentPanel = new JPanel(
            new GridLayout(4, 2, 10, 10)
        );

        studentPanel.setBorder(
            BorderFactory.createEmptyBorder(30, 20, 30, 20)
        );

        studentPanel.add(new JLabel("Student Name:"));
        JLabel studentNameValue = new JLabel(student[0]);
        studentPanel.add(studentNameValue);

        studentPanel.add(new JLabel("Admission Number:"));
        JLabel admissionValue = new JLabel(student[1]);
        studentPanel.add(admissionValue);

        studentPanel.add(new JLabel("Course:"));
        JLabel courseValue = new JLabel(student[2]);
        studentPanel.add(courseValue);

        studentPanel.add(new JLabel("Year of Study:"));
        JLabel yearValue = new JLabel(student[3]);
        studentPanel.add(yearValue);

        frame.add(studentPanel, BorderLayout.CENTER);

        // Quick actions panel
        JPanel actionPanel = new JPanel();

        actionPanel.setLayout(
            new BoxLayout(actionPanel, BoxLayout.Y_AXIS)
        );

        JButton addButton = new JButton("Add Student");
        JButton viewButton = new JButton("View Students");
        JButton updateButton = new JButton("Update Student");
        JButton deleteButton = new JButton("Delete Student");

        actionPanel.add(addButton);
        actionPanel.add(Box.createVerticalStrut(10));

        actionPanel.add(viewButton);
        actionPanel.add(Box.createVerticalStrut(10));

        actionPanel.add(updateButton);
        actionPanel.add(Box.createVerticalStrut(10));

        actionPanel.add(deleteButton);

        actionPanel.setBorder(
            BorderFactory.createEmptyBorder(20, 10, 20, 15)
        );

        frame.add(actionPanel, BorderLayout.EAST);

        // Add student functionality
        addButton.addActionListener(e -> {

            String name = JOptionPane.showInputDialog(
                frame,
                "Enter Student Name:"
            );

            if (name != null && !name.trim().isEmpty()) {

                student[0] = name.trim();
                studentNameValue.setText(student[0]);

                JOptionPane.showMessageDialog(
                    frame,
                    "Student added successfully!"
                );
            }
        });

        // View student functionality
        viewButton.addActionListener(e -> {

            JOptionPane.showMessageDialog(
                frame,
                "Student Name: " + student[0] + "\n" +
                "Admission Number: " + student[1] + "\n" +
                "Course: " + student[2] + "\n" +
                "Year of Study: " + student[3],
                "Student Details",
                JOptionPane.INFORMATION_MESSAGE
            );
        });

        // Update student functionality
        updateButton.addActionListener(e -> {

            String newName = JOptionPane.showInputDialog(
                frame,
                "Enter the new student name:",
                student[0]
            );

            if (newName != null && !newName.trim().isEmpty()) {

                student[0] = newName.trim();
                studentNameValue.setText(student[0]);

                JOptionPane.showMessageDialog(
                    frame,
                    "Student updated successfully!"
                );
            }
        });

        // Delete student functionality
        deleteButton.addActionListener(e -> {

            int choice = JOptionPane.showConfirmDialog(
                frame,
                "Are you sure you want to delete this student?",
                "Delete Student",
                JOptionPane.YES_NO_OPTION
            );

            if (choice == JOptionPane.YES_OPTION) {

                student[0] = "No student registered";
                studentNameValue.setText(student[0]);

                JOptionPane.showMessageDialog(
                    frame,
                    "Student deleted successfully!"
                );
            }
        });

        // Navigation functionality
        homeButton.addActionListener(e ->
            JOptionPane.showMessageDialog(frame, "Welcome to Home!")
        );

        studentsButton.addActionListener(e ->
            JOptionPane.showMessageDialog(frame, "Student Management Section")
        );

        coursesButton.addActionListener(e ->
            JOptionPane.showMessageDialog(frame, "BBIT Course Section")
        );

        reportsButton.addActionListener(e ->
            JOptionPane.showMessageDialog(frame, "Reports Section")
        );

        // Display application
        frame.setVisible(true);
    }
}
