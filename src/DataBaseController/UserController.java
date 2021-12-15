package DataBaseController;

import controller.AddUserController;
import db.DbConnection;
import model.Customer;
import model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserController {
    public boolean AddUser(User user) throws SQLException, ClassNotFoundException {
        PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("INSERT INTO USER VALUES (?,?,?)");
        stm.setObject(1, user.getUserId());
        stm.setObject(2,user.getUserName());
        stm.setObject(3,user.getUserPassword());

        return stm.executeUpdate() > 0;
    }
    public boolean Remove(String user) throws SQLException, ClassNotFoundException {
        PreparedStatement rtm =DbConnection.getInstance().getConnection().prepareStatement("DELETE FROM User WHERE UserId=?");
        rtm.setObject(1,user);
        return  rtm.executeUpdate()>0;
        }

    public User getUser(String userId) throws SQLException, ClassNotFoundException {
        PreparedStatement stm =DbConnection.getInstance().getConnection().prepareStatement("SELECT * FROM User WHERE UserId=?");
        stm.setObject(1,userId);
        ResultSet rtm = stm.executeQuery();
        if (rtm.next()){
            return new User(
                    rtm.getString(1),
                    rtm.getString(2),
                    rtm.getString(3)
            );
        }else {
            return null;
        }
    }

    public List<String> getAllItemIds() throws SQLException, ClassNotFoundException {
        ResultSet rst = DbConnection.getInstance().
                getConnection().prepareStatement("SELECT * FROM User").executeQuery();
        List<String> ids = new ArrayList<>();
        while (rst.next()){
            ids.add(
                    rst.getString(1)
            );
        }
        return ids;
    }
}
