package DataBaseController;

import db.DbConnection;
import model.Order;
import model.OrderDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderController {
    public boolean placeOrder(Order order) {
        Connection con=null;
        try {
            con= DbConnection.getInstance().getConnection();
            con.setAutoCommit(false);
            PreparedStatement stm =con.
                    prepareStatement("INSERT INTO `Order` VALUES(?,?,?,?,?)");


            stm.setObject(1, order.getOrderID());
            stm.setObject(2, order.getCustomerID());
            stm.setObject(3, order.getOrderDate());
            stm.setObject(4, order.getOrderTime());
            stm.setObject(5, order.getCost());

            if (stm.executeUpdate() > 0){
                if (saveOrderDetail(order.getOrderID(), order.getItems())){
                    con.commit();
                    return true;
                }else{
                    con.rollback();
                    return false;
                }
            }else{
                con.rollback();
                return false;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {

                con.setAutoCommit(true);

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
       return false;
    }

    private boolean saveOrderDetail(String orderID, ArrayList<OrderDetails> Order) throws SQLException, ClassNotFoundException {
        for (OrderDetails temp : Order){
            PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("INSERT  INTO `Order Detail`VALUES (?,?,?)");

            stm.setObject(1,orderID);
            stm.setObject(2,temp.getDesc());
            stm.setObject(3,temp.getTotal());
            if (stm.executeUpdate()>0){

            }else {
                return false;
            }
        }
        return true;
    }



    public String getOrderId() throws SQLException, ClassNotFoundException {
        ResultSet rst = DbConnection.getInstance()
                .getConnection().prepareStatement(
                        "SELECT orderId FROM `Order` ORDER BY orderId DESC LIMIT 1"
                ).executeQuery();
        if (rst.next()){

            int tempId = Integer.
                    parseInt(rst.getString(1).split("-")[1]);
            tempId=tempId+1;
            if (tempId<=9){
                return "O-00"+tempId;
            }else if(tempId<=99){
                return "O-0"+tempId;
            }else{
                return "O-"+tempId;
            }

        }else{
            return "O-001";
        }
    }


    public List<String> getDate(String from, String to) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        String query = "SELECT orderId FROM `Order` WHERE orderDate BETWEEN ? AND ?";
        PreparedStatement stm = connection.prepareStatement(query);
        stm.setObject(1,from);
        stm.setObject(2,to);
        ResultSet resultSet = stm.executeQuery();
        List<String> orderList=new ArrayList<>();
        while (resultSet.next()) {
            orderList.add(resultSet.getString(1));
        }
        return orderList;
    }

    public int getSumOfTotal(String id) throws SQLException, ClassNotFoundException {
        double p=0.0;
        Connection con = DbConnection.getInstance().getConnection();
        String query = "SELECT SUM(cost) Total FROM `Order` WHERE orderId=?";
        PreparedStatement stm = con.prepareStatement(query);
        stm.setObject(1,id);
        ResultSet resultSet = stm.executeQuery();
        if(resultSet.next()){
            p=resultSet.getDouble(1);
        }
        return (int) p;
    }
}

