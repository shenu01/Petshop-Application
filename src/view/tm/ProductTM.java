package view.tm;

public class ProductTM {
    private String  petPId;
    private String  proCateId;
    private String  petPName;
    private String  petPDesc;
    private String  petPSize;
    private String  petPPrice;

    public ProductTM(String petPId, String proCateId, String petPName, String petPDesc, String petPSize, String petPPrice) {
        this.petPId = petPId;
        this.proCateId = proCateId;
        this.petPName = petPName;
        this.petPDesc = petPDesc;
        this.petPSize = petPSize;
        this.petPPrice = petPPrice;
    }

    public String getPetPId() {
        return petPId;
    }

    public void setPetPId(String petPId) {
        this.petPId = petPId;
    }

    public String getProCateId() {
        return proCateId;
    }

    public void setProCateId(String proCateId) {
        this.proCateId = proCateId;
    }

    public String getPetPName() {
        return petPName;
    }

    public void setPetPName(String petPName) {
        this.petPName = petPName;
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

    public String getPetPPrice() {
        return petPPrice;
    }

    public void setPetPPrice(String petPPrice) {
        this.petPPrice = petPPrice;
    }

    public ProductTM(String petPId) {
        this.petPId = petPId;
    }
}
