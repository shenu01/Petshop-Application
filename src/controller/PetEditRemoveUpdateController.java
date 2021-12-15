package controller;

import DataBaseController.CustomerController;
import DataBaseController.petController;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import model.Pet;
import model.PetProduct;
import sun.security.util.DisabledAlgorithmConstraints;
import util.ValidationUtil;

import java.net.URL;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class PetEditRemoveUpdateController {



    public AnchorPane CrudContext;
    public TextField txtPid;
    public TextField txtPSize;
    public TextField txtName;
    public TextField txtPPrice;
    public TextField txtPDesc;
    public TextField petCateg;
    public TextField txt1pId;
    public TextField txt1pSize;
    public TextField txt1pName;
    public TextField txt1pPrice;
    public TextField txt1Descrip;
    public TextField txt1Pcategory;
    public ComboBox cmbName;
    public ComboBox cmbCateId;
    public ComboBox cmbname;
    public TextField txt2pID;
    public Button AddNewPEt;



    public void initialize( ){


        cmbCateId.getItems().addAll("Dog","Cat","Bird","Fish");
        cmbName.getItems().addAll("Dog","Cat","Bird","Fish");
        cmbname.getItems().addAll("Dog","Cat","Bird","Fish");
    }


//========================================================================================
    public void AddNewPet(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
 if (txtPid.getText().isEmpty()||txtPSize.getText().isEmpty()||txtName.getText().isEmpty()||
         txtPPrice.getText().isEmpty()||txtPDesc.getText().isEmpty()||petCateg.getText().isEmpty()){
     new Alert(Alert.AlertType.ERROR, "Fill All Text Field ", ButtonType.CLOSE).showAndWait();
   //==================================================

 }else {
     if (txtPid.getText().matches("^[S][0-9]{3}$")) {
         if (txtPSize.getText().matches("^[A-Z][a-z]{4,7}$")){
             if (txtName.getText().matches("^[A-Z]\\w{3,10}$")){
                 if (txtPPrice.getText().matches("^[0-9]{4,6}[.][0][0]$")){
                     if (txtPDesc.getText().matches("^[A-Z][a-z]{3,15}$")){
                         if (petCateg.getText().matches("^[P][0-9]{3}$")){
//==================================================

                             Pet pet = new Pet(txtPid.getText(),txtPSize.getText(),txtName.getText(),txtPPrice.getText(),txtPDesc.getText(),petCateg.getText());
                             boolean b = new petController().AddPet(pet);
                             if (b){
                                 new Alert(Alert.AlertType.INFORMATION, "Successful.Added New Pet").showAndWait();
                                 AddNewPEt.setDisable(true);
                             }else{
                                 new Alert(Alert.AlertType.WARNING, "Empty").show();
                             }
//==================================================

                         }else{
                             new Alert(Alert.AlertType.INFORMATION, "Is,incorrect Pet Category ID", ButtonType.CLOSE).show();
                         }
                     }else{
                         new Alert(Alert.AlertType.INFORMATION, "Description is out of range", ButtonType.CLOSE).show();
                     }
                 }else{
                     new Alert(Alert.AlertType.INFORMATION, "Is,incorrect Pet Price", ButtonType.CLOSE).show();
                 }
             }else{
                 new Alert(Alert.AlertType.INFORMATION, "Pet Name is out of range", ButtonType.CLOSE).show();
             }
         }else{
             new Alert(Alert.AlertType.INFORMATION, "Pet Size is out of range", ButtonType.CLOSE).show();
         }
     }else{
         new Alert(Alert.AlertType.INFORMATION, "Invalid, Pet ID", ButtonType.CLOSE).show();
     }
 }
    }

    //========================================================================================
    public void UpdatePet(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        if (txt1pId.getText().isEmpty()||txt1pSize.getText().isEmpty()||txt1pName.getText().isEmpty()||
                txt1pPrice.getText().isEmpty()||txt1Descrip.getText().isEmpty()||txt1Pcategory.getText().isEmpty()){
            new Alert(Alert.AlertType.ERROR, "Fill All Text Field ", ButtonType.CLOSE).showAndWait();
        }else {
            if (txt1pId.getText().matches("^[S][0-9]{3}$")) {
                if (txt1pSize.getText().matches("^[A-Z][a-z]{4,7}$")) {
                    if (txt1pName.getText().matches("^[A-Z]\\w{3,10}$")) {
                        if (txt1pPrice.getText().matches("^[0-9]{4,6}[.][0][0]$")) {
                            if (txt1Descrip.getText().matches("^[A-Z]\\w{3,15}$")) {
                                if (txt1Pcategory.getText().matches("^[P][0-9]{3}$")) {
     //==================================================



                                    Pet pet = new Pet(txt1pId.getText(), txt1pSize.getText(), txt1pName.getText(), txt1pPrice.getText(), txt1Descrip.getText(), txt1Pcategory.getText());
                                    boolean c = new petController().Update(pet);
                                    if (c)
                                        new Alert(Alert.AlertType.INFORMATION, "Successful. Update Pet").show();
                                    else {
                                        new Alert(Alert.AlertType.WARNING, "Empty Pet Details").show();
                                    }
     //==================================================

                                } else {
                                    new Alert(Alert.AlertType.INFORMATION, "Is,incorrect Pet Category ID", ButtonType.CLOSE).show();
                                }
                            } else {
                                new Alert(Alert.AlertType.INFORMATION, "Description is out of range", ButtonType.CLOSE).show();
                            }
                        } else {
                            new Alert(Alert.AlertType.INFORMATION, "Is,incorrect Pet Price", ButtonType.CLOSE).show();
                        }
                    } else {
                        new Alert(Alert.AlertType.INFORMATION, "Pet Name is out of range", ButtonType.CLOSE).show();
                    }
                } else {
                    new Alert(Alert.AlertType.INFORMATION, "Pet Size is out of range", ButtonType.CLOSE).show();
                }
            } else {
                new Alert(Alert.AlertType.INFORMATION, "Invalid, Pet ID", ButtonType.CLOSE).show();
            }

        }


    }
    //========================================================================================
    public void PetRemove(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
       if (txt2pID.getText().isEmpty()){
            new Alert(Alert.AlertType.ERROR, "Fill All Text Field ", ButtonType.CLOSE).showAndWait();
        }else{
            if (txt2pID.getText().matches("^[S][0-9]{3}$")){
      //==================================


                if (new petController().Delete(txt2pID.getText()));{
            new Alert(Alert.AlertType.INFORMATION,"Successful.Remove Pet").show();

                   }
    //=====================================

            }else{
                new Alert(Alert.AlertType.INFORMATION, "Invalid, Pet ID", ButtonType.CLOSE).show();
            }
       }
    }

//==================================================

    public void selectPet(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String petId = txt1pId.getText();
        Pet pet =new petController().getPet(petId);
        if (pet==null){
            new Alert(Alert.AlertType.INFORMATION,"Empty Information").show();
        }else {
            setData(pet);
        }
    }
//==================================================

    private void setData(Pet pet) {
        txt1pId.setText(pet.getId());
        txt1pSize.setText(pet.getPetSize());
        txt1pName.setText(pet.getPetName());
        txt1pPrice.setText(pet.getPetPrice());
        txt1Descrip.setText(pet.getPetDesc());
        txt1Pcategory.setText(pet.getPetCateId());
    }


}

