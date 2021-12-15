package controller;

import DataBaseController.CustomerController;
import DataBaseController.UserController;
import db.DbConnection;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.Customer;
import model.User;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class AddUserController {

    public AnchorPane AddUserContext;
    public TextField txtUserID;
    public TextField txtUserName;
    public TextField txtUserPass;
    public TextField txtUserName01;
    public TextField txtUserID01;
    public ComboBox <String>cmbUser;


    public void initialize() throws SQLException, ClassNotFoundException {
        loadUser();
    }

/*==============================*/
private void loadUser() throws SQLException, ClassNotFoundException {
    List<String> itemIds = new UserController().getAllItemIds();
    cmbUser.getItems().addAll(itemIds);
}

    public void AddUser(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
    if (txtUserID.getText().isEmpty()||txtUserName.getText().isEmpty()|txtUserPass.getText().isEmpty()){
        new Alert(Alert.AlertType.ERROR, "Fill All Text Field ", ButtonType.CLOSE).showAndWait();
    }
    if (txtUserID.getText().matches("^[U][0-9]{3}$")){
           if (txtUserName.getText().matches("[A-Z][a-z]{3,7}")){
               if (txtUserPass.getText().matches("[A-Z][a-z]{4,7}|[0-9]{0,5}")){

                    User user = new User(txtUserID.getText(), txtUserName.getText(), txtUserPass.getText());
                    boolean b = new UserController().AddUser(user);
                    if (b) {
                        new Alert(Alert.AlertType.CONFIRMATION, "Added New User").show();
                    }else {
                        new Alert(Alert.AlertType.CONFIRMATION, "Empty").show();
                    }

                }else {
                   new Alert(Alert.AlertType.INFORMATION, "Again, Type Password", ButtonType.CLOSE).show();
               }
            }else {
               new Alert(Alert.AlertType.INFORMATION, "User Name is out of range", ButtonType.CLOSE).show();
           }
        }else {
            new Alert(Alert.AlertType.INFORMATION, "Is,incorrect User ID", ButtonType.CLOSE).show();
        }

    }

    public void RemoveUser(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
 if (txtUserID01.getText().isEmpty()||txtUserName01.getText().isEmpty()){
     new Alert(Alert.AlertType.ERROR, "Fill All Text Field ", ButtonType.CLOSE).showAndWait();
 }else {
     if (txtUserID01.getText().matches("^[U][0-9]{3}$")){


         if (new UserController().Remove(txtUserID01.getText()));{
             new Alert(Alert.AlertType.INFORMATION,"Successful.Remove User").show();
         }

     }else {
         new Alert(Alert.AlertType.INFORMATION, "Is,incorrect User ID", ButtonType.CLOSE).show();

     }
     }

}

    public void selectUser(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String userId = txtUserID01.getText();
        User user =new UserController().getUser(userId);
        if (user==null){
            new Alert(Alert.AlertType.INFORMATION,"Empty Information").show();
        }else {
            setData(user);
        }
    }

    private void setData(User user) {
        txtUserID01.setText(user.getUserId());
        txtUserName01.setText(user.getUserName());
    }

    public void User_Report(ActionEvent actionEvent) {
        try {

            JasperDesign design = JRXmlLoader.load(this.getClass().getResourceAsStream("/view/report/User_Report.jrxml"));
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
}
