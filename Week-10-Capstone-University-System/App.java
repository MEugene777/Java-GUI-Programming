import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class App extends Application {
    private ScheduledExecutorService scheduler;

    @Override
    public void start(Stage primaryStage) throws Exception {
        // LO3: Schedule periodic background heartbeat at a fixed rate
        scheduler = Executors.newScheduledThreadPool(1);
        Runnable heartbeat = () ->
            System.out.println("System Heartbeat: Checking for updates at " + new Date());
        scheduler.scheduleAtFixedRate(heartbeat, 0, 5, TimeUnit.SECONDS);

        Parent root = FXMLLoader.load(getClass().getResource("StudentView.fxml"));
        primaryStage.setTitle("Riara University Management System — Capstone");
        primaryStage.setScene(new Scene(root, 540, 440));
        primaryStage.show();
    }

    @Override
    public void stop() {
        if (scheduler != null && !scheduler.isShutdown()) {
            scheduler.shutdownNow();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
