import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Student {
    private final StringProperty regNumber;
    private final StringProperty fullName;
    private final StringProperty course;

    public Student(String regNumber, String fullName, String course) {
        this.regNumber = new SimpleStringProperty(regNumber);
        this.fullName = new SimpleStringProperty(fullName);
        this.course = new SimpleStringProperty(course);
    }

    public String getRegNumber() { return regNumber.get(); }
    public StringProperty regNumberProperty() { return regNumber; }
    public String getFullName() { return fullName.get(); }
    public StringProperty fullNameProperty() { return fullName; }
    public String getCourse() { return course.get(); }
    public StringProperty courseProperty() { return course; }
}
