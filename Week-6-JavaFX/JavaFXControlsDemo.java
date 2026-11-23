import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFXControlsDemo extends Application {

    @Override
    public void start(Stage primaryStage) {
        TextField nameField = new TextField();
        nameField.setPromptText("Enter your full name");

        ComboBox<String> courseBox = new ComboBox<>();
        courseBox.getItems().addAll("Computer Science", "Software Engineering", "Information Technology");
        courseBox.setPromptText("Select Course");

        RadioButton fullTimeRadio = new RadioButton("Full-Time");
        RadioButton partTimeRadio = new RadioButton("Part-Time");
        ToggleGroup modeGroup = new ToggleGroup();
        fullTimeRadio.setToggleGroup(modeGroup);
        partTimeRadio.setToggleGroup(modeGroup);
        fullTimeRadio.setSelected(true);
        HBox radioRow = new HBox(15, fullTimeRadio, partTimeRadio);

        CheckBox termsCheck = new CheckBox("Confirm details are accurate");
        Button submitBtn = new Button("Register");
        Label outputLabel = new Label();

        submitBtn.setOnAction(e -> {
            if (!termsCheck.isSelected()) {
                outputLabel.setText("Please check the confirmation box first.");
                return;
            }
            RadioButton selectedMode = (RadioButton) modeGroup.getSelectedToggle();
            outputLabel.setText("Registered: " + nameField.getText() + " | "
                    + courseBox.getValue() + " (" + selectedMode.getText() + ")");
        });

        VBox layout = new VBox(12,
                new Label("Student Registration"),
                nameField,
                courseBox,
                radioRow,
                termsCheck,
                submitBtn,
                outputLabel
        );
        layout.setPadding(new Insets(20));

        Scene scene = new Scene(layout, 380, 320);
        primaryStage.setTitle("JavaFX Controls Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
