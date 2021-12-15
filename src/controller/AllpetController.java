package controller;

import DataBaseController.petController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import view.tm.PetTM;


import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;


public class AllpetController {
    public AnchorPane AllPetContext;
    public TableView  AllPets;
    public TableColumn colPId;
    public TableColumn colPsize;
    public TableColumn colPname;
    public TableColumn colPdesc;
    public TableColumn colPpri;
    public TableColumn PetCategory;


    public void initialize() throws SQLException, ClassNotFoundException {
        colPId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colPsize.setCellValueFactory(new PropertyValueFactory<>("petSize"));
        colPname.setCellValueFactory(new PropertyValueFactory<>("petName"));
        colPdesc.setCellValueFactory(new PropertyValueFactory<>("petDesc"));
        colPpri.setCellValueFactory(new PropertyValueFactory<>("petPrice"));
        PetCategory.setCellValueFactory(new PropertyValueFactory<>("petCateId"));


        loadTabel();
    }
     ObservableList<PetTM>petTMS=FXCollections.observableArrayList();
    private void loadTabel() throws SQLException, ClassNotFoundException {

        ArrayList<PetTM> allPet = new petController().getAllPet();
        for (PetTM petTM : allPet){
            petTMS.add(petTM);
        }
        AllPets.setItems(petTMS);
    }


    public void BackLogin(MouseEvent mouseEvent) throws IOException {
        URL resource = getClass().getResource("/view/DashBoard.fxml");
        Parent load = FXMLLoader.load(resource);
        AllPetContext.getChildren().clear();
        AllPetContext.getChildren().add(load);
    }

}
