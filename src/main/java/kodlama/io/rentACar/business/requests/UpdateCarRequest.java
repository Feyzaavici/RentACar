package kodlama.io.rentACar.business.requests;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class UpdateCarRequest {
    @NotNull
    @Positive
    private int carId;
    private String plate;
    private double dailyPrice;

    public UpdateCarRequest(){

    }

    public UpdateCarRequest(int carId, String plate, double dailyPrice){
        this.carId=carId;
        this.plate=plate;
        this.dailyPrice=dailyPrice;
    }

    public int getCarId() {
        return carId;
    }

    public double getDailyPrice() {
        return dailyPrice;
    }

    public String getPlate() {
        return plate;
    }

    public void setDailyPrice(double dailyPrice) {
        this.dailyPrice = dailyPrice;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }
}
