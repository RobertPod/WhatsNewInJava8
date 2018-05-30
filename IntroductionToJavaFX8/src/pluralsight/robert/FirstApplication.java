package pluralsight.robert;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class FirstApplication extends Application {

    public static void main(String... args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // a simple UI
        Label message = new Label("Hello world");
        message.setFont(new Font(100));

        primaryStage.setScene(new Scene(message));
        primaryStage.setTitle("Hello");
        primaryStage.show();
    }
}
