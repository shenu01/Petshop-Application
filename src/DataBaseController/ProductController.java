package DataBaseController;

import db.DbConnection;
import model.Pet;
import model.PetProduct;
import view.tm.ProductTM;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductController {
    public boolean AddPetProduct(PetProduct petProduct) throws SQLException, ClassNotFoundException {
        PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("INSERT INTO PetProduct VALUES (?,?,?,?,?,?)");
        stm.setObject(1,petProduct.getPetPId());
        stm.setObject(2,petProduct.getPetPName());
        stm.setObject(3,petProduct.getPetPPrice());
        stm.setObject(4,petProduct.getPetPDesc());
        stm.setObject(5,petProduct.getPetPSize());
        stm.setObject(6,petProduct.getProCateId());
        return stm.executeUpdate()>0;


    }
    public ArrayList<ProductTM> getAllProduct() throws SQLException, ClassNotFoundException {
        PreparedStatement rtm = DbConnection.getInstance().getConnection().prepareStatement("SELECT * FROM PetProduct");
        ArrayList<ProductTM> productTMS = new ArrayList<>();
        ResultSet ptm = rtm.executeQuery();
        while (ptm.next()){
            productTMS.add(new ProductTM(
                    ptm.getString(1),
                    ptm.getString(2),
                    ptm.getString(3),
                    ptm.getString(4),
                    ptm.getString(5),
                    ptm.getString(6))
            );
        }
        return productTMS;
    }
    public boolean Remove(String Product) throws SQLException, ClassNotFoundException {
        PreparedStatement vtm= DbConnection.getInstance().getConnection().prepareStatement("DELETE FROM PetProduct WHERE PetPId=?");
        vtm.setObject(1,Product);
        return vtm.executeUpdate()>0;
    }
    public boolean upDate(PetProduct petProduct) throws SQLException, ClassNotFoundException {
        PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("UPDATE PetProduct SET PetPName=?,PetPPrice=?,PetPDesc=?,PetProSize=?,ProCateId=? WHERE PetPId=?");
        stm.setObject(1,petProduct.getPetPName());
        stm.setObject(2,petProduct.getPetPSize());
        stm.setObject(3,petProduct.getPetPDesc());
        stm.setObject(4,petProduct.getPetPSize());
        stm.setObject(5,petProduct.getProCateId());
        stm.setObject(6,petProduct.getPetPId());
        return stm.executeUpdate()>0;

    }


}
