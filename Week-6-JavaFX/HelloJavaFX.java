import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelloJavaFX extends Application {

    @Override
    public void start(Stage primaryStage) {
        Label label = new Label("Ready for Week 6: JavaFX");
        Button button = new Button("Click Me");

        button.setOnAction(e -> label.setText("JavaFX is working!"));

        VBox layout = new VBox(15, label, button);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 350, 200);
        primaryStage.setTitle("JavaFX Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}