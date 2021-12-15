package model;

import java.util.ArrayList;

public class Order {
    private String orderID;
    private String customerID;
    private String orderDate;
    private String orderTime;
    private double cost;
    private ArrayList<OrderDetails> items;

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public ArrayList<OrderDetails> getItems() {
        return items;
    }

    public void setItems(ArrayList<OrderDetails> items) {
        this.items = items;
    }

    public Order(String orderID, String customerID, String orderDate, String orderTime, double cost, ArrayList<OrderDetails> items) {
        this.orderID = orderID;
        this.customerID = customerID;
        this.orderDate = orderDate;
        this.orderTime = orderTime;
        this.cost = cost;
        this.items = items;
    }

    public Order(String orderID) {
        this.orderID = orderID;
    }
}