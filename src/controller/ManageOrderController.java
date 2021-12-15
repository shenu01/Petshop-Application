package controller;

import DataBaseController.CustomerController;
import DataBaseController.ProductCategoryController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.Customer;
import model.ProductCategory;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;

public class ManageOrderController {
    public AnchorPane ManageOrderContext;
    public ComboBox cmbCateID;
    public ComboBox cmbCustomerID;
    public TextField txtCName;
    public TextField txtCAddress;
    public TextField txtTotal;
    public TextField txtItemDesc;
    public TextField txtItemSize;
    public TableView tblCart;


    public void initialize() {


            cmbCustomerID.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                try {
                    setCustomerData((String) newValue);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            });
            cmbCateID.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                try {
                    setCategoryData((String) newValue);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            });

        }

    /*===============================================*/


    private void setCustomerData(String customerId) throws SQLException, ClassNotFoundException {
        Customer c2 = new CustomerController().getCustomer(customerId);
        if (c2 == null) {
            new Alert(Alert.AlertType.WARNING, "Empty Result Set");
        } else {
            txtCName.setText(c2.getName());
            txtCAddress.setText(c2.getAddress());

        }

    }

    private void loadCustomerIds() throws SQLException, ClassNotFoundException {

        List<String> customerIds = new CustomerController().getCustomerIds();
        cmbCustomerID.getItems().addAll(customerIds);

    }

    /*===============================================*/
    private void setCategoryData(String ProductCageId) throws SQLException, ClassNotFoundException {
        ProductCategory i1 = new PetProductController().getProduct(ProductCageId);
        if (i1 == null) {
            new Alert(Alert.AlertType.WARNING, "Empty Result Set");
        } else {
            txtItemSize.setText(i1.getProVerite());

        }

    }

    private void loadCategoryIds() throws SQLException, ClassNotFoundException {
        List<String> itemIds = new ProductCategoryController().getAllItemIds();
        cmbCateID.getItems().addAll(itemIds);
    }
    /*===============================================*/

    public void BackDashBorad(MouseEvent mouseEvent) throws IOException {
        URL resource = getClass().getResource("/view/DashBoard.fxml");
        Parent load = FXMLLoader.load(resource);
        ManageOrderContext.getChildren().clear();
        ManageOrderContext.getChildren().add(load);
    }

    public void AddtoCart(ActionEvent actionEvent) {
    }

    public void ClearOrder(ActionEvent actionEvent) {
    }
}
