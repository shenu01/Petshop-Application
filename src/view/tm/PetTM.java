package view.tm;

public class PetTM {
    private String  id;
    private String  petSize;
    private String  petName;
    private String  petPrice;
    private String  petDesc;
    private String  petCateId;

    public PetTM(String id, String petSize, String petName, String petPrice, String petDesc, String petCateId) {
        this.id = id;
        this.petSize = petSize;
        this.petName = petName;
        this.petPrice = petPrice;
        this.petDesc = petDesc;
        this.petCateId = petCateId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPetSize() {
        return petSize;
    }

    public void setPetSize(String petSize) {
        this.petSize = petSize;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getPetPrice() {
        return petPrice;
    }

    public void setPetPrice(String petPrice) {
        this.petPrice = petPrice;
    }

    public String getPetDesc() {
        return petDesc;
    }

    public void setPetDesc(String petDesc) {
        this.petDesc = petDesc;
    }

    public String getPetCateId() {
        return petCateId;
    }

    public void setPetCateId(String petCateId) {
        this.petCateId = petCateId;
    }

    public PetTM(String id) {
        this.id = id;
    }
}
