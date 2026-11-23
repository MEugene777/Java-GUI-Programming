import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class StudentController {

    @FXML private TextField regNumberField;
    @FXML private TextField fullNameField;
    @FXML private TextField courseField;
    @FXML private Button saveButton;
    @FXML private Label statusLabel;
    @FXML private TableView<Student> studentTable;
    @FXML private TableColumn<Student, String> regCol;
    @FXML private TableColumn<Student, String> nameCol;
    @FXML private TableColumn<Student, String> courseCol;

    @FXML
    public void initialize() {
        regCol.setCellValueFactory(data -> data.getValue().regNumberProperty());
        nameCol.setCellValueFactory(data -> data.getValue().fullNameProperty());
        courseCol.setCellValueFactory(data -> data.getValue().courseProperty());

        // Week 8 Property Binding: disable Save button until required fields are filled
        saveButton.disableProperty().bind(
            regNumberField.textProperty().isEmpty()
                .or(fullNameField.textProperty().isEmpty())
                .or(courseField.textProperty().isEmpty())
        );

        loadStudents();
    }

    @FXML
    public void handleSaveStudent() {
        Student student = new Student(
            regNumberField.getText().trim(),
            fullNameField.getText().trim(),
            courseField.getText().trim()
        );

        statusLabel.setText("Saving student in background...");

        // LO2 & LO4: Multi-threaded Producer-Consumer Task
        Task<Void> saveTask = new Task<>() {
            @Override
            protected Void call() throws Exception {
                DatabaseUtil.insertStudent(student);
                return null;
            }
        };

        saveTask.setOnSucceeded(e -> {
            regNumberField.clear();
            fullNameField.clear();
            courseField.clear();
            statusLabel.setText("Student saved successfully.");
            loadStudents();
        });

        saveTask.setOnFailed(e ->
            statusLabel.setText("Error saving student: " + saveTask.getException().getMessage())
        );

        new Thread(saveTask).start();
    }

    @FXML
    public void loadStudents() {
        statusLabel.setText("Loading student records...");

        Task<ObservableList<Student>> loadTask = new Task<>() {
            @Override
            protected ObservableList<Student> call() throws Exception {
                return DatabaseUtil.fetchAllStudents();
            }
        };

        loadTask.setOnSucceeded(e -> {
            studentTable.setItems(loadTask.getValue());
            statusLabel.setText("Loaded " + loadTask.getValue().size() + " record(s).");
        });

        loadTask.setOnFailed(e ->
            statusLabel.setText("Failed to load records.")
        );

        new Thread(loadTask).start();
    }
}
