package controller;

import DataBaseController.FoodController;
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
import view.tm.FoodTM;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;

public class AllPetFoodController {
    public AnchorPane AllPetFoodContext;
    public TableView FoodTabel;
    public TableColumn colFId;
    public TableColumn colFcategory;
    public TableColumn colFSize;
    public TableColumn colFName;
    public TableColumn colFDesc;
    public TableColumn colFPri;

    public void initialize() throws SQLException, ClassNotFoundException {
        colFId.setCellValueFactory(new PropertyValueFactory<>("petFId"));
        colFcategory.setCellValueFactory(new PropertyValueFactory<>("foodCateId"));
        colFSize.setCellValueFactory(new PropertyValueFactory<>("petPSize"));
        colFName.setCellValueFactory(new PropertyValueFactory<>("petFName"));
        colFDesc.setCellValueFactory(new PropertyValueFactory<>("petFDesc"));
        colFPri.setCellValueFactory(new PropertyValueFactory<>("petFPrice"));


        loadTabel();
    }
     ObservableList<FoodTM>foodTMS= FXCollections.observableArrayList();
    private void loadTabel() throws SQLException, ClassNotFoundException {
        ArrayList<FoodTM> allFood = new FoodController().getAllFood();
        for (FoodTM foodTM: allFood) {
            foodTMS.add(foodTM);
        }
        FoodTabel.setItems(foodTMS);
        }


    public void DashBoard(MouseEvent mouseEvent) throws IOException {
        URL resource = getClass().getResource("/view/DashBoard.fxml");
        Parent load = FXMLLoader.load(resource);
        AllPetFoodContext.getChildren().clear();
        AllPetFoodContext.getChildren().add(load);
    }
}
