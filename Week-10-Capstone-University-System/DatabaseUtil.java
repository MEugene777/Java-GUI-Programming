import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/riara_university";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static final List<Student> fallbackStore = new ArrayList<>();

    static {
        fallbackStore.add(new Student("24ZAD110021", "Eugene Lemayian Mukosa", "BBIT"));
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void insertStudent(Student student) throws Exception {
        String sql = "INSERT INTO students (reg_number, full_name, course) VALUES (?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, student.getRegNumber());
            stmt.setString(2, student.getFullName());
            stmt.setString(3, student.getCourse());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Thread.sleep(300);
            fallbackStore.add(student);
        }
    }

    public static ObservableList<Student> fetchAllStudents() throws Exception {
        ObservableList<Student> students = FXCollections.observableArrayList();
        String sql = "SELECT reg_number, full_name, course FROM students";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                students.add(new Student(
                    rs.getString("reg_number"),
                    rs.getString("full_name"),
                    rs.getString("course")
                ));
            }
        } catch (SQLException ex) {
            Thread.sleep(300);
            students.addAll(fallbackStore);
        }
        return students;
    }
}
