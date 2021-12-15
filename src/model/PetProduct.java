package model;

public class PetProduct {
    private String  petPId;
    private String  petPName;
    private String  petPPrice;
    private String  petPDesc;
    private String  petPSize;
    private String  proCateId;

    public PetProduct(String petPId, String petPName, String petPPrice, String petPDesc, String petPSize, String proCateId) {
        this.petPId = petPId;
        this.petPName = petPName;
        this.petPPrice = petPPrice;
        this.petPDesc = petPDesc;
        this.petPSize = petPSize;
        this.proCateId = proCateId;
    }

    public String getPetPId() {
        return petPId;
    }

    public void setPetPId(String petPId) {
        this.petPId = petPId;
    }

    public String getPetPName() {
        return petPName;
    }

    public void setPetPName(String petPName) {
        this.petPName = petPName;
    }

    public String getPetPPrice() {
        return petPPrice;
    }

    public void setPetPPrice(String petPPrice) {
        this.petPPrice = petPPrice;
    }

    public String getPetPDesc() {
        return petPDesc;
    }

    public void setPetPDesc(String petPDesc) {
        this.petPDesc = petPDesc;
    }

    public String getPetPSize() {
        return petPSize;
    }

    public void setPetPSize(String petPSize) {
        this.petPSize = petPSize;
    }

    public String getProCateId() {
        return proCateId;
    }

    public void setProCateId(String proCateId) {
        this.proCateId = proCateId;
    }

    public PetProduct(String petPId) {
        this.petPId = petPId;
    }
}
