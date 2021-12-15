package controller;

import DataBaseController.OrderController;
import db.DbConnection;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class AdminDashBoardController {
    public AnchorPane AddminDashBoardContext;
    public Label lblTotalIncome;
    public Label lblNoOfOrders;
    public DatePicker txtTo;
    public DatePicker txtForm;
    public Label Date;
    public Label Time;


    public void initialize(){

        java.util.Date date = new Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        Date.setText(f.format(date));

        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

            Time.setText(LocalDateTime.now().format(formatter));

        }), new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();

        txtForm.valueProperty().addListener((observable, oldValue, newValue1) -> {
            txtTo.valueProperty().addListener((observable1, oldValue1, newValue2) -> {
                int total=0;
                try {
                    List<String> orderId = new OrderController().getDate(String.valueOf(newValue1), String.valueOf(newValue2));
                    lblNoOfOrders.setText(String.valueOf(orderId.size()));

                    for (String oId:orderId) {
                        total+= new OrderController().getSumOfTotal(oId);
                    }

                    lblTotalIncome.setText("Rs : "+String.valueOf(total));

                } catch (SQLException | ClassNotFoundException throwables) {
                    throwables.printStackTrace();
                }
            });

        });

    }

    public void LoginWindow(MouseEvent mouseEvent) throws IOException {
        URL resource = getClass().getResource("/view/LoginWindow.fxml");
        Parent load = FXMLLoader.load(resource);
        AddminDashBoardContext.getChildren().clear();
        AddminDashBoardContext.getChildren().add(load);
    }

    public void EditPet(MouseEvent mouseEvent) throws IOException {
        Parent load1 = FXMLLoader.load(getClass().getResource("/view/PetEditRemoveUpdate.fxml"));
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

    public void EditPetFood(MouseEvent mouseEvent) throws IOException {
        Parent load1 = FXMLLoader.load(getClass().getResource("/view/PetFoodEditRemoveUpdate.fxml"));
        Scene scene1 = new Scene(load1);
        Stage stage = new Stage();
        stage.setScene(scene1);
        stage.show();
    }

    public void UserManage(MouseEvent mouseEvent) throws IOException {
        Parent load1 = FXMLLoader.load(getClass().getResource("/view/AddUser.fxml"));
        Scene scene1 = new Scene(load1);
        Stage stage = new Stage();
        stage.setScene(scene1);
        stage.show();
    }

    public void IncomeReport(MouseEvent mouseEvent) throws IOException {
        try {

            JasperDesign design = JRXmlLoader.load(this.getClass().getResourceAsStream("/view/report/SQL_Chart.jrxml"));
            JasperReport compileReport = JasperCompileManager.compileReport(design);
            JasperPrint jasperPrint = JasperFillManager.fillReport(compileReport, null, DbConnection.getInstance().getConnection());
            JasperViewer.viewReport(jasperPrint, false);


        } catch (JRException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void EditRemovePetFood(MouseEvent mouseEvent) throws IOException {
        Parent load1 = FXMLLoader.load(getClass().getResource("/view/AllPetFood.fxml"));
        Scene scene1 = new Scene(load1);
        Stage stage = new Stage();
        stage.setScene(scene1);
        stage.show();
    }

    public void EditRemovePet(MouseEvent mouseEvent) throws IOException {
        Parent load1 = FXMLLoader.load(getClass().getResource("/view/AllPet.fxml"));
        Scene scene1 = new Scene(load1);
        Stage stage = new Stage();
        stage.setScene(scene1);
        stage.show();
    }

    public void EditRemovePetProduct(MouseEvent mouseEvent) throws IOException {
        Parent load1 = FXMLLoader.load(getClass().getResource("/view/AllPetProduct.fxml"));
        Scene scene1 = new Scene(load1);
        Stage stage = new Stage();
        stage.setScene(scene1);
        stage.show();
    }

    public void playMouseEnterAnimation(MouseEvent event) {
        if (event.getSource() instanceof Button){
            Button icon =(Button)event.getSource();
            ScaleTransition scaleT = new ScaleTransition(Duration.millis(200), icon);
            scaleT.setToX(1.2);
            scaleT.setToY(1.2);
            scaleT.play();

            DropShadow glow = new DropShadow();
            glow.setColor(Color.CORNFLOWERBLUE);
            glow.setWidth(20);
            glow.setHeight(20);
            glow.setRadius(20);
            icon.setEffect(glow);

        }
    }

    public void playMouseExitAnimation(MouseEvent event) {
        if (event.getSource()instanceof Button){
            Button icon =(Button) event.getSource();
            ScaleTransition scaleT = new ScaleTransition(Duration.millis(200), icon);
            scaleT.setToX(1);
            scaleT.setToY(1);
            scaleT.play();
            icon.setEffect(null);

        }

    }
}
