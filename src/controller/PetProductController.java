package controller;

import DataBaseController.ProductController;
import db.DbConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.Customer;
import model.ProductCategory;
import view.tm.ProductTM;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PetProductController {
    public AnchorPane AllPetProductsContext;
    public TableView ProductTabel;
    public TableColumn ColPID;
    public TableColumn colPcateID;
    public TableColumn colPName;
    public TableColumn colPDesc;
    public TableColumn colPSize;
    public TableColumn colPPrice;

    public void initialize() throws SQLException, ClassNotFoundException {
        ColPID.setCellValueFactory(new PropertyValueFactory<>("petPId"));
        colPcateID.setCellValueFactory(new PropertyValueFactory<>("proCateId"));
        colPName.setCellValueFactory(new PropertyValueFactory<>("petPName"));
        colPDesc.setCellValueFactory(new PropertyValueFactory<>("petPDesc"));
        colPSize.setCellValueFactory(new PropertyValueFactory<>("petPSize"));
        colPPrice.setCellValueFactory(new PropertyValueFactory<>("petPPrice"));


        loadTabel();
    }
     ObservableList<ProductTM>productTMS= FXCollections.observableArrayList();
    private void loadTabel() throws SQLException, ClassNotFoundException {
        ArrayList<ProductTM>allProduct=new ProductController().getAllProduct();
        for (ProductTM productTM:allProduct) {
            productTMS.add(productTM);
        }
        ProductTabel.setItems(productTMS);
        }



    public void DashBorad(MouseEvent mouseEvent) throws IOException {
        URL resource = getClass().getResource("/view/DashBoard.fxml");
        Parent load = FXMLLoader.load(resource);
        AllPetProductsContext.getChildren().clear();
        AllPetProductsContext.getChildren().add(load);
    }

    public ProductCategory getProduct(String ProductCageId) throws SQLException, ClassNotFoundException {
        PreparedStatement stm = DbConnection.getInstance()
                .getConnection().prepareStatement("SELECT * FROM Productcategory WHERE ProCateId=?");
        stm.setObject(1, ProductCageId);

        ResultSet rst = stm.executeQuery();
        if (rst.next()) {
            return new ProductCategory(
                    rst.getString(1),
                    rst.getString(2)

            );

        } else {
            return null;
        }
    }
}
