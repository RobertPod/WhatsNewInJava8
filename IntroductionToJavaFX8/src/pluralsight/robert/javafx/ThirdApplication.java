package pluralsight.robert.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class ThirdApplication extends Application {

    public static void main(String... args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ihm.fxml"));

            Parent root = loader.load();
            primaryStage.setScene(new Scene(root));
            primaryStage.show();


        }catch (IOException ioe){
            System.out.println(ioe.toString());
        }
    }
}
