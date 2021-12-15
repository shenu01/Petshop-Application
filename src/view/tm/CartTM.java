package view.tm;

public class CartTM {
    private String itemID;
    private String customerName;
    private  String desc;
    private  double unitPrice;
    private double total;

    public CartTM(String itemID, String desc, double unitPrice ) {
        this.itemID = itemID;
        this.desc = desc;
        this.unitPrice = unitPrice;

    }



    public CartTM(String itemID, String customerName, String desc, double unitPrice, double total) {
        this.itemID = itemID;
        this.customerName = customerName;
        this.desc = desc;
        this.unitPrice = unitPrice;
        this.total = total;
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public CartTM(String itemID) {
        this.itemID = itemID;
    }
}
