package controller;

import DataBaseController.*;
import db.DbConnection;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import view.tm.CartTM;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class AddOrderController {

    public ComboBox<String> cmbCustomerID;
    public ComboBox<String> cmbCateID;
    public TextField txtCName;
    public TextField txtCAddress;
    public Label lblTotal;
    public Label lblOrderId;
    public AnchorPane PlaceOrderFormContext;
    public Label Time;
    public TextField txtCTel;
    public TextField txtCustNic;
    public TextField txtICategoryName;
    public ComboBox<String> cmbItemID;
    public TextField txtItemName;
    public TextField txtItemDesc;
    public TextField txtItemPrice;
    public TableView<CartTM> tblCart;
    public TableColumn ColItemID;
    public TableColumn CoICustomerName;
    public TableColumn colDescription;
    public TableColumn colUnitPrice;
    public TableColumn colTotal;
    public Label Date;
    public Label orderLabel;
    int cartSelectedRowForRemove = -1;

    public void initialize() {

        ColItemID.setCellValueFactory(new PropertyValueFactory<>("itemID"));
        CoICustomerName.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("desc"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        colTotal.setCellValueFactory(new PropertyValueFactory<>("total"));


        java.util.Date date = new Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        Date.setText(f.format(date));

        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

            Time.setText(LocalDateTime.now().format(formatter));

        }), new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
        setOrderId();

        try {

            loadCustomerIds();
            loadCategoryIds();
            loadPetIds();



        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        cmbCustomerID.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            try {
                setCustomerData(newValue);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
        cmbCateID.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            try {
                setCategoryData(newValue);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
        cmbItemID.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            try {
                setPetData(newValue);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
        tblCart.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            cartSelectedRowForRemove = (int) newValue;
        });

    }

    /*===============================================*/
    private void setCustomerData(String customerId) throws SQLException, ClassNotFoundException {
        Customer c1 = new CustomerController().getCustomer(customerId);
        if (c1 == null) {
            new Alert(Alert.AlertType.WARNING, "Empty Result Set");
        } else {
            txtCName.setText(c1.getName());
            txtCAddress.setText(c1.getAddress());
            txtCTel.setText(c1.getTelephone());
            txtCustNic.setText(c1.getNic());
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
            txtICategoryName.setText(i1.getProVerite());

        }

    }

    private void loadCategoryIds() throws SQLException, ClassNotFoundException {
        List<String> itemIds = new ProductCategoryController().getAllItemIds();
        cmbCateID.getItems().addAll(itemIds);
    }

    /*===============================================*/
    private void setPetData(String PetId) throws SQLException, ClassNotFoundException {
        Pet u1 = new petController().getPet(PetId);
        if (u1 == null) {
            new Alert(Alert.AlertType.WARNING, "Empty Result Set");
        } else {
            txtItemName.setText(u1.getPetName());
            txtItemDesc.setText(u1.getPetDesc());
            txtItemPrice.setText(u1.getPetPrice());
        }

    }

    private void loadPetIds() throws SQLException, ClassNotFoundException {
        List<String> petIds = new petController().getAllpetIds();
        cmbItemID.getItems().addAll(petIds);

    }



    /*===============================================*/

    public void BackDashBorad(MouseEvent mouseEvent) throws IOException {
        URL resource = getClass().getResource("/view/DashBoard.fxml");
        Parent load = FXMLLoader.load(resource);
        PlaceOrderFormContext.getChildren().clear();
        PlaceOrderFormContext.getChildren().add(load);
    }

    public void AddCustomer(MouseEvent mouseEvent) throws IOException {
        Parent load1 = FXMLLoader.load(getClass().getResource("/view/AddNewCustomer.fxml"));
        Scene scene1 = new Scene(load1);
        Stage stage = new Stage();
        stage.setScene(scene1);
        stage.show();
    }

    /*===============================================*/
    public void ClearOrder(ActionEvent actionEvent) {
        if (cartSelectedRowForRemove == -1) {
            new Alert(Alert.AlertType.WARNING, "Please Select a row").show();
        } else {
            obList.remove(cartSelectedRowForRemove);
            calculateCost();
            tblCart.refresh();
        }

    }

    /*===============================================*/
    ObservableList<CartTM> obList = FXCollections.observableArrayList();

    public void AddtoCart(ActionEvent actionEvent) {
        String customerName = txtCName.getText();
        String desc = txtItemDesc.getText();
        double unitPrice = Double.parseDouble(txtItemPrice.getText());
        double total = Double.parseDouble(txtItemPrice.getText());


        CartTM tm = new CartTM(
                cmbItemID.getValue(),
                customerName,
                desc,
                unitPrice,
                total
        );


        int rowNumber = isExists(tm);

        if (rowNumber == -1) {// new Add
            obList.add(tm);
        } else {
            // update
            CartTM temp = obList.get(rowNumber);
            CartTM newTm = new CartTM(
                    temp.getItemID(),
                    temp.getCustomerName(),
                    temp.getDesc(),
                    unitPrice,
                    total + temp.getTotal()
            );

            obList.remove(rowNumber);
            obList.add(newTm);
        }
        tblCart.setItems(obList);
        calculateCost();


    }

    private void calculateCost() {
        double ttl = 0;
        for (CartTM tm : obList
        ) {
            ttl += tm.getTotal();
        }
        lblTotal.setText(ttl + " /=");
    }

    private int isExists(CartTM tm) {
        for (int i = 0; i < obList.size(); i++) {
            if (tm.getItemID().equals(obList.get(i).getItemID())) {
                return i;
            }
        }
        return -1;
    }


    /*===============================================*/


    public void saveOrder(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        ArrayList<OrderDetails> items= new ArrayList<>();
        double total=0;
        for (CartTM tempTm:obList
        ) {
            total+=tempTm.getTotal();
            items.add(new OrderDetails(tempTm.getItemID(),tempTm.getDesc(),tempTm.getTotal()));
        }


        Order order= new Order(orderLabel.getText(), cmbCustomerID.getValue(),
                Date.getText(),
                Time.getText(),
                total,
                items
        );


        if (new OrderController().placeOrder(order)){
            new Alert(Alert.AlertType.CONFIRMATION, "Success").show();
            setOrderId();
        }else{
            new Alert(Alert.AlertType.WARNING, "Try Again").show();
        }
        tblCart.getItems().clear();

    }

    private void setOrderId()   {
        try{
            orderLabel.setText(new OrderController().getOrderId());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


    public void JasperReport(ActionEvent actionEvent) {
        try {

            JasperDesign design = JRXmlLoader.load(this.getClass().getResourceAsStream("/view/report/Bill.jrxml"));
            JasperReport compileReport = JasperCompileManager.compileReport(design);

            ObservableList<CartTM> items = tblCart.getItems();
            String orderId = orderLabel.getText();

            HashMap map = new HashMap();
            map.put("OrderId",orderId);

            JasperPrint jasperPrint = JasperFillManager.fillReport(compileReport,map, new JRBeanArrayDataSource(items.toArray()));
            JasperViewer.viewReport(jasperPrint, false);


        } catch (JRException e) {
            e.printStackTrace();
        }


    }


    public void playMouseEnterAnimation(MouseEvent event){
        if (event.getSource() instanceof javafx.scene.image.ImageView){
            javafx.scene.image.ImageView icon = (javafx.scene.image.ImageView) event.getSource();
            ScaleTransition scaleT = new ScaleTransition(Duration.millis(200), icon);
            scaleT.setToX(1.2);
            scaleT.setToY(1.2);
            scaleT.play();

            DropShadow glow = new DropShadow();
            glow.setColor(Color.CORNFLOWERBLUE);
            glow.setWidth(20);
            glow.setHeight(20);
            glow.setRadius(20);
            icon.setEffect(glow);

        }

    }

    public void playMouseExitAnimation(MouseEvent event) {
        if (event.getSource() instanceof javafx.scene.image.ImageView) {
            javafx.scene.image.ImageView icon = (javafx.scene.image.ImageView) event.getSource();
            ScaleTransition scaleT = new ScaleTransition(Duration.millis(200), icon);
            scaleT.setToX(1);
            scaleT.setToY(1);
            scaleT.play();

            icon.setEffect(null);
        }
    }

    public void Customer_Report(ActionEvent actionEvent) {
        try {

            JasperDesign design = JRXmlLoader.load(this.getClass().getResourceAsStream("/view/report/SQL_CustomerReport.jrxml"));
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

