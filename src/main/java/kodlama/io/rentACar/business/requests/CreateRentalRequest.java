package kodlama.io.rentACar.business.requests;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class CreateRentalRequest {


    private int carId;

    @NotNull
    private LocalDate rentDate;

    public CreateRentalRequest(int carId, LocalDate rentDate ){
        this.carId=carId;
        this.rentDate=rentDate;

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
}
