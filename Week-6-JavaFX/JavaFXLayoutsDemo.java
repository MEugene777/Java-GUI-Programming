import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class JavaFXLayoutsDemo extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();

        HBox topBar = new HBox(10);
        topBar.setPadding(new Insets(10));
        topBar.setAlignment(Pos.CENTER);
        topBar.getChildren().addAll(
            new Button("Home"),
            new Button("Profile"),
            new Button("Settings")
        );
        root.setTop(topBar);

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setAlignment(Pos.CENTER);

        grid.add(new Label("Username:"), 0, 0);
        grid.add(new TextField(), 1, 0);
        grid.add(new Label("Email:"), 0, 1);
        grid.add(new TextField(), 1, 1);
        root.setCenter(grid);

        Label statusLabel = new Label("Layout: BorderPane + HBox + GridPane");
        BorderPane.setAlignment(statusLabel, Pos.CENTER);
        BorderPane.setMargin(statusLabel, new Insets(10));
        root.setBottom(statusLabel);

        Scene scene = new Scene(root, 400, 250);
        primaryStage.setTitle("JavaFX Layouts Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
