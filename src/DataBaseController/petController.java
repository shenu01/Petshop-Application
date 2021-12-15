package DataBaseController;

import db.DbConnection;
import model.Customer;
import model.Pet;
import model.PetProduct;
import view.tm.PetTM;

import java.lang.reflect.Executable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class petController {

    public boolean AddPet(Pet pet) throws SQLException, ClassNotFoundException {
        PreparedStatement rtm = DbConnection.getInstance().getConnection().prepareStatement("INSERT INTO Pet VALUES (?,?,?,?,?,?)");
        rtm.setObject(1, pet.getId());
        rtm.setObject(2, pet.getPetSize());
        rtm.setObject(3, pet.getPetName());
        rtm.setObject(4, pet.getPetPrice());
        rtm.setObject(5, pet.getPetDesc());
        rtm.setObject(6, pet.getPetCateId());
        return rtm.executeUpdate() > 0;

    }

    public boolean Update(Pet pet) throws SQLException, ClassNotFoundException {
        PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("UPDATE Pet SET PetSize=?,PetName=?,PetPrice=?,PetDesc=?,PetCateId=? WHERE PetId=?");
        stm.setObject(1, pet.getPetSize());
        stm.setObject(2, pet.getPetName());
        stm.setObject(3, pet.getPetPrice());
        stm.setObject(4, pet.getPetDesc());
        stm.setObject(5, pet.getPetCateId());
        stm.setObject(6, pet.getId());
        return stm.executeUpdate() > 0;
    }

    public boolean Delete(String pet) throws SQLException, ClassNotFoundException {
        PreparedStatement mtm = DbConnection.getInstance().getConnection().prepareStatement("DELETE FROM Pet WHERE PetId=?");
        mtm.setObject(1, pet);
        return mtm.executeUpdate() > 0;

    }

    public Pet getPet(String petId) throws SQLException, ClassNotFoundException {
        PreparedStatement mtm = DbConnection.getInstance().getConnection().prepareStatement("SELECT * FROM Pet WHERE PetId=?");
        mtm.setObject(1, petId);
        ResultSet ntm = mtm.executeQuery();
        if (ntm.next()) {
            return new Pet(
                    ntm.getString(1),
                    ntm.getString(2),
                    ntm.getString(3),
                    ntm.getString(4),
                    ntm.getString(5),
                    ntm.getString(6)
            );
        } else {
            return null;
        }
    }

    public ArrayList<PetTM> getAllPet() throws SQLException, ClassNotFoundException {
        PreparedStatement mtm = DbConnection.getInstance().getConnection().prepareStatement("SELECT * FROM Pet  ");
        ArrayList<PetTM> petTMS = new ArrayList<>();
        ResultSet ntm = mtm.executeQuery();
        while (ntm.next()) {
            petTMS.add(new PetTM(
                    ntm.getString(1),
                    ntm.getString(2),
                    ntm.getString(3),
                    ntm.getString(4),
                    ntm.getString(5),
                    ntm.getString(6))

            );


        }
        return petTMS;
    }

    public PetProduct getProduct(String petPID) throws SQLException, ClassNotFoundException {
        PreparedStatement mtm =DbConnection.getInstance().getConnection().prepareStatement("SELECT * FROM PetProduct WHERE PetPId=?");
         mtm.setObject(1,petPID);
         ResultSet rtm = mtm.executeQuery();
         if (rtm.next()){
             return new PetProduct(
                     rtm.getString(1),
                     rtm.getString(2),
                     rtm.getString(3),
                     rtm.getString(4),
                     rtm.getString(5),
                     rtm.getString(6)
             );
         }else {
             return null;
         }
    }

    public List<String> getAllpetIds() throws SQLException, ClassNotFoundException {
        ResultSet rst = DbConnection.getInstance().
                getConnection().prepareStatement("SELECT * FROM Pet").executeQuery();
        List<String> ids = new ArrayList<>();
        while (rst.next()){
            ids.add(
                    rst.getString(1)
            );
        }
        return ids;
    }
}



