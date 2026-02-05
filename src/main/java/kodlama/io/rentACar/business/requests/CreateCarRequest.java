package kodlama.io.rentACar.business.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class CreateCarRequest {

    @NotNull
    @NotBlank
    private String plate;
   @Positive
    private double dailyPrice;
    private int modelYear;
   @Positive
    private int modelId;
   @Positive
    private int brandId;

    public double getDailyPrice() {
        return dailyPrice;
    }

    public int getModelYear() {
        return modelYear;
    }

    public int getModelId() {
        return modelId;
    }

    public String getPlate() {
        return plate;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setPlate(String plate){
        this.plate=plate;
    }

    public void setDailyPrice(double dailyPrice){
        this.dailyPrice=dailyPrice;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    public CreateCarRequest(){

    }

    public CreateCarRequest(String plate, double dailyPrice, int modelYear, int modelId, int brandId){
        this.plate=plate;
        this.dailyPrice=dailyPrice;
        this.modelYear=modelYear;
        this.modelId=modelId;
        this.brandId=brandId;
    }
}
