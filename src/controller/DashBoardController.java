package controller;

import javafx.animation.*;
import javafx.collections.transformation.TransformationList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DashBoardController {
    public Label Time;
    public Label date;
    public AnchorPane DashboardContext;


    public void initialize() {
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy:MM:dd");
            Time.setText(LocalDateTime.now().format(formatter));
            date.setText(LocalDateTime.now().format(formatter1));
        }),new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }


    public void BackLogin(MouseEvent mouseEvent) throws IOException {
        URL resource = getClass().getResource("/view/LoginWindow.fxml");
        Parent load = FXMLLoader.load(resource);
        DashboardContext.getChildren().clear();
        DashboardContext.getChildren().add(load);

    }

    public void AllPets(MouseEvent mouseEvent) throws IOException {
        URL resource = getClass().getResource("/view/AllPet.fxml");
        Parent load = FXMLLoader.load(resource);
        DashboardContext.getChildren().clear();
        DashboardContext.getChildren().add(load);
    }

    public void AllPetFood(MouseEvent mouseEvent) throws IOException {
        URL resource = getClass().getResource("/view/AllPetFood.fxml");
        Parent load = FXMLLoader.load(resource);
        DashboardContext.getChildren().clear();
        DashboardContext.getChildren().add(load);
    }

    public void AllPetProduct(MouseEvent mouseEvent) throws IOException {
        URL resource = getClass().getResource("/view/AllPetProduct.fxml");
        Parent load = FXMLLoader.load(resource);
        DashboardContext.getChildren().clear();
        DashboardContext.getChildren().add(load);
    }

    public void EditPetFood(MouseEvent mouseEvent) throws IOException {
        Parent load1 = FXMLLoader.load(getClass().getResource("/view/PetFoodEditRemoveUpdate.fxml"));
        Scene scene1 = new Scene(load1);
        Stage stage = new Stage();
        stage.setScene(scene1);
        stage.show();
    }

    public void EditPetProduct(MouseEvent mouseEvent) throws IOException {
        Parent load1 = FXMLLoader.load(getClass().getResource("/view/PetProductEditRemoveUpdate.fxml"));
        Scene scene1 = new Scene(load1);
        Stage stage = new Stage();
        stage.setScene(scene1);
        stage.show();
    }

    public void EditPet(MouseEvent mouseEvent) throws IOException {
        Parent load1 = FXMLLoader.load(getClass().getResource("/view/PetEditRemoveUpdate.fxml"));
        Scene scene1 = new Scene(load1);
        Stage stage = new Stage();
        stage.setScene(scene1);
        stage.show();
    }

    public void AddOrder(MouseEvent mouseEvent) throws IOException {
        URL resource = getClass().getResource("/view/AddOrder.fxml");
        Parent load = FXMLLoader.load(resource);
        DashboardContext.getChildren().clear();
        DashboardContext.getChildren().add(load);
    }

    public void ManageOrder(MouseEvent mouseEvent) throws IOException {
        URL resource = getClass().getResource("/view/ManageOrder.fxml");
        Parent load = FXMLLoader.load(resource);
        DashboardContext.getChildren().clear();
        DashboardContext.getChildren().add(load);
    }

    public void playMouseEnterAnimation(MouseEvent event) {
        if (event.getSource() instanceof Label){
            Label button =(Label)event.getSource();
            ScaleTransition scaleT = new ScaleTransition(Duration.millis(200), button);
            scaleT.setToX(1.2);
            scaleT.setToY(1.2);
            scaleT.play();

            DropShadow glow = new DropShadow();
            glow.setColor(Color.CORNFLOWERBLUE);
            glow.setWidth(20);
            glow.setHeight(20);
            glow.setRadius(20);
            button.setEffect(glow);

        }

    }

    public void playMouseExitAnimation(MouseEvent event) {
        if (event.getSource()instanceof Label){
            Label button =(Label) event.getSource();
            ScaleTransition scaleT = new ScaleTransition(Duration.millis(200), button);
            scaleT.setToX(1);
            scaleT.setToY(1);
            scaleT.play();
            button.setEffect(null);

        }

    }
}
