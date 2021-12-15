package model;

public class ProductCategory {
    private String proCateId;
    private String ProVerite;

    public ProductCategory(String proCateId, String proVerite) {
        this.proCateId = proCateId;
        ProVerite = proVerite;
    }

    public String getProCateId() {
        return proCateId;
    }

    public void setProCateId(String proCateId) {
        this.proCateId = proCateId;
    }

    public String getProVerite() {
        return ProVerite;
    }

    public void setProVerite(String proVerite) {
        ProVerite = proVerite;
    }

    public ProductCategory(String proCateId) {
        this.proCateId = proCateId;
    }
}
