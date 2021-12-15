package controller;

import DataBaseController.FoodController;
import DataBaseController.UserController;
import DataBaseController.petController;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import model.Pet;
import model.PetFood;
import model.User;

import java.sql.SQLException;
import java.util.ArrayList;

public class PetFoodEditRemoveUpdateController {
    public AnchorPane AddFoodContext;

    public ComboBox cmbPDCatego;
    public TextField txtPfid3;
    public TextField txtPfN3;

    public ComboBox cmbPDCateg;
    public TextField txtPfid2;
    public TextField txtPfN2;
    public TextField txtPfp2;
    public TextField txtPFD2;
    public TextField txtPFPS2;
    public TextField txtPFCI2;

    public ComboBox cmbPDCate;
    public TextField txtPfid;
    public TextField txtPFCI;
    public TextField txtPfN;
    public TextField txtPFD;
    public TextField txtPFPS;
    public TextField txtPfp;
    public Button AddNewPet;

    public void initialize(){
        cmbPDCatego.getItems().addAll("DogFood","CatFood","BirdFood","FishFood");
        cmbPDCateg.getItems().addAll("DogFood","CatFood","BirdFood","FishFood");
        cmbPDCate.getItems().addAll("DogFood","CatFood","BirdFood","FishFood");
    }


    public void SelectPetFood(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String petFoodId = txtPfid2.getText();
         PetFood petFood = new FoodController().getFood(petFoodId);
         if (petFood==null){
             new Alert(Alert.AlertType.INFORMATION,"Empty Information").show();
         }else {
             setData(petFood);
         }

    }

    private void setData(PetFood petFood) {
        txtPfid2.setText(petFood.getPetFId());
        txtPfN2.setText(petFood.getPetFName());
        txtPfp2.setText(petFood.getPetFPrice());
        txtPFD2.setText(petFood.getPetFDesc());
        txtPFPS2.setText(petFood.getPetPSize());
        txtPFCI2.setText(petFood.getFoodCateId());
    }
    //==================================================
    public void RemoveFood(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        if (txtPfid3.getText().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Fill All Text Field ", ButtonType.CLOSE).showAndWait();
        } else {
            if (txtPfid3.getText().matches("^[A][0-9]{3}$")) {


   //=====================
                if (new FoodController().Remove(txtPfid3.getText())) ;
                {
                    new Alert(Alert.AlertType.INFORMATION, "Successful.Remove Pet").show();
                }
   //======================
            } else {
                new Alert(Alert.AlertType.INFORMATION, "Invalid, Pet Food ID", ButtonType.CLOSE).show();
            }
        }
    }
    //==================================================
    public void UpdateFood(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        if (txtPfid2.getText().isEmpty()||txtPfN2.getText().isEmpty()||txtPfp2.getText().isEmpty()
                ||txtPFD2.getText().isEmpty()||txtPFPS2.getText().isEmpty()||txtPFCI2.getText().isEmpty()){
            new Alert(Alert.AlertType.ERROR, "Fill All Text Field ", ButtonType.CLOSE).showAndWait();
        }else {
            if (txtPfid2.getText().matches("^[A][0-9]{3}$")){
                if (txtPfN2.getText().matches("^[A-Z]\\w{3,10}$")){
                    if (txtPfp2.getText().matches("^[0-9]{4,6}[.][0][0]$")){
                        if (txtPFD2.getText().matches("^[A-Z]\\w{3,15}$")){
                            if (txtPFPS2.getText().matches("[A-Z][a-z]{4,7}$")){
                                if (txtPFCI2.getText().matches("^[F][0-9]{3}$")){


                                    PetFood petFood = new PetFood(txtPfid2.getText(),txtPfN2.getText(),txtPfp2.getText()
                                            ,txtPFD2.getText(),txtPFPS2.getText(),txtPFCI2.getText());
                                    boolean c=new FoodController().update(petFood);
                                    if (c)
                                        new Alert(Alert.AlertType.INFORMATION,"Successful. Update Pet").show();
                                    else {
                                        new Alert(Alert.AlertType.WARNING, "Empty Pet Details").show();
                                    }


                                }else{
                                    new Alert(Alert.AlertType.INFORMATION, "Is,incorrect PetFood Category ID", ButtonType.CLOSE).show();
                                }
                            }else {
                                new Alert(Alert.AlertType.INFORMATION, "PetFood Name is out of range", ButtonType.CLOSE).show();
                            }
                        }else {
                            new Alert(Alert.AlertType.INFORMATION, "Description is out of range", ButtonType.CLOSE).show();
                        }
                    }else {
                        new Alert(Alert.AlertType.INFORMATION, "Is,incorrect PetFood Price", ButtonType.CLOSE).show();
                    }
                }else {
                    new Alert(Alert.AlertType.INFORMATION, "PetFood Name is out of range", ButtonType.CLOSE).show();
                }
            }else {
                new Alert(Alert.AlertType.INFORMATION, "Invalid, PetFood ID", ButtonType.CLOSE).show();
            }
        }




    }
//==================================================

    public void AddNewFood(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        if (txtPfid.getText().isEmpty() || txtPfN.getText().isEmpty() || txtPfp.getText().isEmpty() ||
                txtPFD.getText().isEmpty() || txtPFPS.getText().isEmpty() || txtPFCI.getText().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Fill All Text Field " );

  //===============

        } else {
            if (txtPfid.getText().matches("^[A][0-9]{3}$")) {
                if (txtPfN.getText().matches("^[A-Z]\\w{3,10}$")) {
                    if (txtPfp.getText().matches("^[0-9]{4,6}[.][0][0]$")) {
                            if (txtPFD.getText().matches("^[A-Z]\\w{3,15}$")) {
                            if (txtPFPS.getText().matches("^[A-Z][a-z]{4,7}$")) {
                                if (txtPFCI.getText().matches("^[F][0-9]{3}$")) {

  //==================
                                    PetFood petFood = new PetFood(txtPfid.getText(), txtPfN.getText(), txtPfp.getText(), txtPFD.getText(), txtPFPS.getText(), txtPFCI.getText());
                                    boolean b = new FoodController().AddFood(petFood);
                                    if (b) {
                                        new Alert(Alert.AlertType.CONFIRMATION, "Successful.Added New User").show();
                                        AddNewPet.setDisable(true);
                                    } else {
                                        new Alert(Alert.AlertType.WARNING, "Empty").show();
                                    }
  //=================
                                }else{
                                    new Alert(Alert.AlertType.INFORMATION, "Is,incorrect PetFood Category ID", ButtonType.CLOSE).show();
                                }
                            }else {
                                new Alert(Alert.AlertType.INFORMATION, "PetFood Size is out of range", ButtonType.CLOSE).show();
                            }
                        }else {
                            new Alert(Alert.AlertType.INFORMATION, "Description is out of range", ButtonType.CLOSE).show();
                        }
                    }else {
                        new Alert(Alert.AlertType.INFORMATION, "Is,incorrect PetFood Price", ButtonType.CLOSE).show();
                    }
                }else {
                    new Alert(Alert.AlertType.INFORMATION, "PetFood Name is out of range", ButtonType.CLOSE).show();
                }
            }else {
                new Alert(Alert.AlertType.INFORMATION, "Invalid, PetFood ID", ButtonType.CLOSE).show();
            }
        }
    }
}



