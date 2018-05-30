package pluralsight.robert;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class SecondApplication extends Application {

    public static void main(String... args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // a simple UI
        Label message1 = new Label("Hello world");
        message1.setFont(new Font(100));

        Label message2 = new Label("Hello world");
        message2.setFont(new Font(100));

        VBox vbox = new VBox(message1, message2);

        primaryStage.setScene(new Scene(vbox));
        primaryStage.setTitle("Hello");
        primaryStage.show();
    }
}
