package kodlama.io.rentACar.business.requests;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class CreateRentalRequest {


    private int carId;

    @NotNull
    private LocalDate rentDate;

    private int customerId;

    public CreateRentalRequest(int carId, LocalDate rentDate, int customerId ){
        this.carId=carId;
        this.rentDate=rentDate;
        this.customerId=customerId;

    }

    public CreateRentalRequest() {
    }

    public int getCarId() {
        return carId;
    }



    public LocalDate getRentDate() {
        return rentDate;
    }

    public void setCarId(int carId) {
        this.carId=carId;
    }


    public void setRentDate(LocalDate rentDate) {
        this.rentDate=rentDate;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getCustomerId() {
        return customerId;
    }
}
