package controller;

import DataBaseController.ProductController;
import DataBaseController.petController;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import model.Pet;
import model.PetProduct;

import java.sql.SQLException;

public class PetProductEditRemoveUpdateController {

    public ComboBox cmbProd;
    public TextField txtppId;
    public TextField txtppPrice;
    public TextField txtppName;
    public TextField ppSize;
    public TextField txtppDesc;
    public TextField ppCateId;
     
    public AnchorPane productContext;
    public ComboBox cmbProdc;
    public TextField txtpp2Id;
    public TextField txtpp2Name;
    public TextField txtpp2Price;
    public TextField txtpp2Desc;
    public TextField pp2Size;
    public TextField pp2CateId;
     
    public ComboBox cmbProduct;
    public TextField txtpp3Id;
    public Button AddNewProductContext;


    public void initialize(){
        cmbProd.getItems().addAll("DogProduct","CatProduct","FishProduct");
        cmbProdc.getItems().addAll("DogProduct","CatProduct","FishProduct");
        cmbProduct.getItems().addAll("DogProduct","CatProduct","FishProduct");
    }



    public void AddNewProduct(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        if (txtppId.getText().isEmpty()||txtppPrice.getText().isEmpty()||txtppName.getText().isEmpty()
                ||ppSize.getText().isEmpty()||txtppDesc.getText().isEmpty()||ppCateId.getText().isEmpty()){
            new Alert(Alert.AlertType.ERROR,"Fill All Text Field ");
        }else {
            if (txtppId.getText().matches("^[B][0-9]{3}$")){
                if (txtppName.getText().matches("^[A-Z]\\w{3,10}$")) {
                    if (txtppPrice.getText().matches("^[0-9]{4,6}[.][0][0]$")){
                        if (txtppDesc.getText().matches("^[A-Z]\\w{3,15}$")){
                            if (ppSize.getText().matches("^[A-Z][a-z]{4,7}$")){
                                if (ppCateId.getText().matches("^[P][C][0-9]{3}$")){

                                    PetProduct petProduct = new PetProduct(txtppId.getText(),txtppPrice.getText(),txtppName.getText(),ppSize.getText(),txtppDesc.getText(),ppCateId.getText());
                                    boolean b = new ProductController().AddPetProduct(petProduct);
                                    if (b){
                                        new Alert(Alert.AlertType.CONFIRMATION, "Added New Product").show();
                                        AddNewProductContext.setDisable(true);
                                    }else {
                                        new Alert(Alert.AlertType.CONFIRMATION, "Empty").show();
                                    }


                                }else {
                                    new Alert(Alert.AlertType.INFORMATION,"Is,incorrect PetProduct Category ID", ButtonType.CLOSE).show();
                                }
                            }else {
                                new Alert(Alert.AlertType.INFORMATION,"PetProduct Size is out of range", ButtonType.CLOSE).show();
                            }
                        }else {
                            new Alert(Alert.AlertType.INFORMATION,"Description is out of range", ButtonType.CLOSE).show();
                        }
                    }else {
                        new Alert(Alert.AlertType.INFORMATION,"Is,incorrect PetProduct Price", ButtonType.CLOSE).show();
                    }
                }else {
                    new Alert(Alert.AlertType.INFORMATION,"PetProduct Name is out of range", ButtonType.CLOSE).show();
                }
            }else {
                new Alert(Alert.AlertType.INFORMATION,"Invalid, PetProduct ID", ButtonType.CLOSE).show();
            }
        }


    }


    public void UpdateProduct(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        if (txtpp2Id.getText().isEmpty()||txtpp2Name.getText().isEmpty()||txtpp2Price.getText().isEmpty()
                ||txtpp2Desc.getText().isEmpty()||pp2Size.getText().isEmpty()||pp2CateId.getText().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Fill All Text Field ", ButtonType.CLOSE).showAndWait();
        }else {
            if (txtppId.getText().matches("^[B][0-9]{3}$")){
                if (txtppName.getText().matches("^[A-Z]\\w{3,10}$")) {
                    if (txtppPrice.getText().matches("^[0-9]{4,6}[.][0][0]$")){
                        if (txtppDesc.getText().matches("^[A-Z]\\w{3,15}$")){
                            if (ppSize.getText().matches("^[A-Z][a-z]{4,7}$")){
                                if (ppCateId.getText().matches("^[P][C][0-9]{3}$")){

                                    PetProduct petProduct = new PetProduct(txtpp2Id.getText(),txtpp2Name.getText(),txtpp2Price.getText(),txtpp2Desc.getText(),pp2Size.getText(),pp2CateId.getText());
                                    boolean c = new ProductController().upDate(petProduct);
                                    if (c)
                                        new Alert(Alert.AlertType.INFORMATION,"Successful. Update Pet").show();
                                    else {
                                        new Alert(Alert.AlertType.WARNING, "Empty Pet Details").show();
                                    }


                                }else {
                                    new Alert(Alert.AlertType.INFORMATION,"Is,incorrect PetProduct Category ID", ButtonType.CLOSE).show();
                                }
                            }else {
                                new Alert(Alert.AlertType.INFORMATION,"PetProduct Size is out of range", ButtonType.CLOSE).show();
                            }
                        }else {
                            new Alert(Alert.AlertType.INFORMATION,"Description is out of range", ButtonType.CLOSE).show();
                        }
                    }else {
                        new Alert(Alert.AlertType.INFORMATION,"Is,incorrect PetProduct Price", ButtonType.CLOSE).show();
                    }
                }else {
                    new Alert(Alert.AlertType.INFORMATION,"PetProduct Name is out of range", ButtonType.CLOSE).show();
                }
            }else {
                new Alert(Alert.AlertType.INFORMATION,"Invalid, PetProduct ID", ButtonType.CLOSE).show();
            }
        }



    }

//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void RemoveProduct(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        if (txtpp3Id.getText().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Fill All Text Field ", ButtonType.CLOSE).showAndWait();
        } else {
            if (txtpp3Id.getText().matches("^[B][0-9]{3}$")) {

                if (new ProductController().Remove(txtpp3Id.getText())) ;
                {
                    new Alert(Alert.AlertType.INFORMATION, "Successful.Remove Pet").show();
                }
            } else {
                new Alert(Alert.AlertType.INFORMATION, "Invalid, PetProduct ID", ButtonType.CLOSE).show();
            }
        }
    }
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void SelectProduct(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String petPID = txtpp2Id.getText();
        PetProduct petProduct = new petController().getProduct(petPID);
         if (petProduct==null){
            new Alert(Alert.AlertType.INFORMATION,"Empty Information").show();
        }else {
            setData(petProduct);
        }
    }
     private void setData(PetProduct petProduct){
         txtpp2Id.setText(petProduct.getPetPId());
         txtpp2Name.setText(petProduct.getPetPName());
         txtpp2Price.setText(petProduct.getPetPPrice());
         txtpp2Desc.setText(petProduct.getPetPDesc());
         pp2Size.setText(petProduct.getPetPSize());
         pp2CateId.setText(petProduct.getProCateId());

     }


}
