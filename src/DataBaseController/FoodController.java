package DataBaseController;

import db.DbConnection;
import model.Pet;
import model.PetFood;
import view.tm.FoodTM;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FoodController {
    public boolean AddFood(PetFood petfood) throws SQLException, ClassNotFoundException {
        PreparedStatement rtm = DbConnection.getInstance().getConnection().prepareStatement("INSERT INTO PetFood VALUES (?,?,?,?,?,?)");
        rtm.setObject(1,petfood.getPetFId());
        rtm.setObject(2,petfood.getPetFName());
        rtm.setObject(3,petfood.getPetFPrice());
        rtm.setObject(4,petfood.getPetFDesc());
        rtm.setObject(5,petfood.getPetPSize());
        rtm.setObject(6,petfood.getFoodCateId());
        return rtm.executeUpdate()>0;

    }

    public PetFood getFood(String petFoodId) throws SQLException, ClassNotFoundException {
        PreparedStatement vtm = DbConnection.getInstance().getConnection().prepareStatement("SELECT * FROM PetFood WHERE PetFId=?");
        vtm.setObject(1,petFoodId);
        ResultSet utm =vtm.executeQuery();
        if (utm.next()){
            return new PetFood(
                    utm.getString(1),
                    utm.getString(2),
                    utm.getString(3),
                    utm.getString(4),
                    utm.getString(5),
                    utm.getString(6)
            );
        }else {
            return null;
        }
    }
    public boolean update(PetFood petFood) throws SQLException, ClassNotFoundException {
        PreparedStatement rtm = DbConnection.getInstance().getConnection().prepareStatement("UPDATE PetFood SET PetFName=?,PetFPrice=?,PetFDesc=?,PetProSize=?,FoodCateId=? WHERE PetFId=?");
        rtm.setObject(1,petFood.getPetFName());
        rtm.setObject(2,petFood.getPetFPrice());
        rtm.setObject(3,petFood.getPetFDesc());
        rtm.setObject(4,petFood.getPetPSize());
        rtm.setObject(5,petFood.getFoodCateId());
        rtm.setObject(6,petFood.getPetFId());
        return rtm.executeUpdate()>0;
    }

        public ArrayList<FoodTM> getAllFood() throws SQLException, ClassNotFoundException {
        PreparedStatement atm = DbConnection.getInstance().getConnection().prepareStatement("SELECT * FROM PetFood");
        ArrayList<FoodTM> foodTMS = new ArrayList<>();
        ResultSet btm=atm.executeQuery();
        while (btm.next()){
            foodTMS.add(new FoodTM(
                            btm.getString(1),
                            btm.getString(2),
                            btm.getString(3),
                            btm.getString(4),
                            btm.getString(5),
                            btm.getString(6))
                    );
        }
       return foodTMS;
        }

        public boolean Remove(String food) throws SQLException, ClassNotFoundException {
            PreparedStatement ctm= DbConnection.getInstance().getConnection().prepareStatement("DELETE FROM PetFood WHERE PetFId=?");
            ctm.setObject(1,food);
            return ctm.executeUpdate()>0;
        }

}
