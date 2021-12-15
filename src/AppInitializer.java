import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        URL resource = getClass().getResource("view/LoginWindow.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene= new Scene(load);
        scene.getStylesheets().add("style/Viper.css");
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image("assert/icon.jpg"));
        primaryStage.setTitle("Anima Pet Shop Desktop Application ");
        primaryStage.show();

    }
}
