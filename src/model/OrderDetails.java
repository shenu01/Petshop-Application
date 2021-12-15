package model;

public class OrderDetails {
    private String itemId;
    private String Desc;
    private double total;
    private String customerName;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public OrderDetails(String itemId, String desc, double total ) {
        this.itemId = itemId;
        Desc = desc;
        this.total = total;

    }

    public OrderDetails(String customerName) {
        this.customerName = customerName;
    }
}