package controller;

import DataBaseController.CustomerController;
import DataBaseController.petController;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import model.Customer;
import model.Pet;

import java.net.URL;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class AddNewCustomerController {

    public TextField txtCustName;
    public TextField txtCustTel;
    public TextField txtCustAddr;
    public TextField txtCustNic;
    public TextField txtCustId;
    public JFXButton btnSaveCustomer;
    public JFXButton AddNewCustContext;
//==================================================


    public void AddNewCustomer(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        if (txtCustId.getText().isEmpty() || txtCustTel.getText().isEmpty() || txtCustName.getText().isEmpty() ||
                txtCustAddr.getText().isEmpty() || txtCustNic.getText().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Fill All Text Field ", ButtonType.CLOSE).showAndWait();


        } else {
            if (txtCustId.getText().matches("^[C][0-9]{3}$")) {
                if (txtCustTel.getText().matches("^[0][7][1|2|5|6|7|8][0-9]{7}$")) {
                    if (txtCustName.getText().matches("^[A-Z]\\w{4,10}$")){
                        if (txtCustAddr.getText().matches("^[A-Z][a-z]{5,15}$")) {
                            if (txtCustNic.getText().matches("^[0-9]{12}|[V]$")) {

//==================================================

                                Customer customer = new Customer(txtCustId.getText(), txtCustTel.getText(), txtCustName.getText(), txtCustAddr.getText(), txtCustNic.getText());
                                boolean b = new CustomerController().AddCustomer(customer);
                                if (b){
                                    new Alert(Alert.AlertType.CONFIRMATION, "Added. New Customer").show();

                                }else{

                                    new Alert(Alert.AlertType.WARNING, "Dublicated ID").show();

                                }


//==================================================



                            } else {
                                new Alert(Alert.AlertType.INFORMATION, "Is,incorrect NIC Number", ButtonType.CLOSE).show();
                            }
                        } else {
                            new Alert(Alert.AlertType.INFORMATION, "Address is out of range", ButtonType.CLOSE).show();
                        }
                    } else {
                        new Alert(Alert.AlertType.INFORMATION, "Incorrect Name", ButtonType.CLOSE).show();
                    }
                } else {
                    new Alert(Alert.AlertType.INFORMATION, "Is,Invalid TEL.PHONE Number", ButtonType.CLOSE).show();
                }
            } else {
                new Alert(Alert.AlertType.INFORMATION, "Is,incorrect ID ", ButtonType.CLOSE).show();
            }
        }
    }
    //==================================================

}