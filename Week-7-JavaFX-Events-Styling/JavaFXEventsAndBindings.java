import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFXEventsAndBindings extends Application {

    @Override
    public void start(Stage primaryStage) {
        Label titleLabel = new Label("Week 7: JavaFX Events, Properties & CSS");
        titleLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: #1B365D;");

        TextField nameInput = new TextField();
        nameInput.setPromptText("Enter your full name...");
        nameInput.setMaxWidth(260);

        Label livePreview = new Label();
        livePreview.textProperty().bind(
            Bindings.when(nameInput.textProperty().isEmpty())
                .then("Waiting for input...")
                .otherwise(Bindings.concat("Hello, ", nameInput.textProperty(), "!"))
        );

        Button submitButton = new Button("Confirm Registration");
        submitButton.setStyle("-fx-background-color: #1B365D; -fx-text-fill: white; -fx-font-weight: bold;");
        submitButton.disableProperty().bind(nameInput.textProperty().isEmpty());

        Label statusLabel = new Label();
        submitButton.setOnAction(e -> statusLabel.setText("Registered: " + nameInput.getText().trim()));

        VBox root = new VBox(12, titleLabel, nameInput, livePreview, submitButton, statusLabel);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));
        root.setStyle("-fx-background-color: #F4F6F9;");

        Scene scene = new Scene(root, 400, 260);
        primaryStage.setTitle("Week 7 - JavaFX Events & Bindings");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
