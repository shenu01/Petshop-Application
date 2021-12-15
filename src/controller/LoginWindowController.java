package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import view.tm.LoginTM;

import java.io.IOException;
import java.net.URL;

public class LoginWindowController {


    public AnchorPane loginContext;
    public TextField txtName;
    public PasswordField txtPassword;


    public void LoginAdminDash(ActionEvent actionEvent) throws IOException {
        if (txtName.getText().equals(LoginTM.getAddminName()) && txtPassword.getText().equals(LoginTM.getAddminPassword())) {

            if (txtName.getText().isEmpty() || txtPassword.getText().isEmpty()) {
                new Alert(Alert.AlertType.ERROR, "Fill All Text Field ");

            } else {
                if (txtName.getText().matches("[A-Z][a-z]{3,6}")) {
                    if (txtPassword.getText().matches("[A-Z][a-z]{5,10}|[0-9]{2,5}")) {

                        Parent load = FXMLLoader.load(getClass().getResource("/view/AdminDashBoard.fxml"));
                        Scene scene = new Scene(load);
                        Stage window = (Stage) loginContext.getScene().getWindow();
                        window.setScene(scene);
                        return;

                    } else {
                        new Alert(Alert.AlertType.INFORMATION, "Incorrect. Admin Password !", ButtonType.CLOSE).show();

                    }
                } else {
                    new Alert(Alert.AlertType.INFORMATION, " Incorrect. Admin Name", ButtonType.CLOSE).show();

                }
            }

        } else if (txtName.getText().equals(LoginTM.getUserName()) && txtPassword.getText().equals(LoginTM.getUserPassword())) {

            if (txtName.getText().isEmpty() || txtPassword.getText().isEmpty()) {
                new Alert(Alert.AlertType.ERROR, "Fill All Text Field ");

            } else {
                if (txtName.getText().matches("[A-Z][a-z]{2,6}")) {
                    if (txtPassword.getText().matches("[A-Z][a-z]{5,10}|[0-9]{2,5}")) {

                        Parent load1 = FXMLLoader.load(getClass().getResource("/view/DashBoard.fxml"));
                        Scene scene1 = new Scene(load1);
                        Stage window1 = (Stage) loginContext.getScene().getWindow();
                        window1.setScene(scene1);
                        return;
                    } else {
                        new Alert(Alert.AlertType.INFORMATION, "Incorrect. User Password !", ButtonType.CLOSE).show();

                    }
                } else {
                    new Alert(Alert.AlertType.INFORMATION, " Incorrect. User Name", ButtonType.CLOSE).show();

                }
            }

        }else{
            new Alert(Alert.AlertType.WARNING,"The user name or password that you entered is incorrect.Try Again.. ", ButtonType.CLOSE).showAndWait();
        }

        }

    }

