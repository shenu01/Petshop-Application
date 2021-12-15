package model;

public class PetFood {
    private String  petFId;
    private String  petFName;
    private String  petFPrice;
    private String  petFDesc;
    private String  petPSize;
    private String  foodCateId;

    public PetFood(String petFId, String petFName, String petFPrice, String petFDesc, String petPSize, String foodCateId) {
        this.petFId = petFId;
        this.petFName = petFName;
        this.petFPrice = petFPrice;
        this.petFDesc = petFDesc;
        this.petPSize = petPSize;
        this.foodCateId = foodCateId;
    }

    public String getPetFId() {
        return petFId;
    }

    public void setPetFId(String petFId) {
        this.petFId = petFId;
    }

    public String getPetFName() {
        return petFName;
    }

    public void setPetFName(String petFName) {
        this.petFName = petFName;
    }

    public String getPetFPrice() {
        return petFPrice;
    }

    public void setPetFPrice(String petFPrice) {
        this.petFPrice = petFPrice;
    }

    public String getPetFDesc() {
        return petFDesc;
    }

    public void setPetFDesc(String petFDesc) {
        this.petFDesc = petFDesc;
    }

    public String getPetPSize() {
        return petPSize;
    }

    public void setPetPSize(String petPSize) {
        this.petPSize = petPSize;
    }

    public String getFoodCateId() {
        return foodCateId;
    }

    public void setFoodCateId(String foodCateId) {
        this.foodCateId = foodCateId;
    }

    public PetFood(String petFId) {
        this.petFId = petFId;
    }
}
