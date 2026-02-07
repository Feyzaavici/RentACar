package kodlama.io.rentACar.business.requests;

import java.time.LocalDate;

public class ReturnRentalRequest {

    private int rentalId;
    private long endKilometer;
    private LocalDate returnDate;

    public ReturnRentalRequest(){

    }

    public ReturnRentalRequest(int rentalId, long endKilometer, LocalDate returnDate){
        this.rentalId=rentalId;
        this.returnDate=returnDate;
        this.endKilometer=endKilometer;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public void setEndKilometer(long endKilometer) {
        this.endKilometer = endKilometer;
    }

    public void setRentalId(int rentalId) {
        this.rentalId = rentalId;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public int getRentalId() {
        return rentalId;
    }

    public long getEndKilometer() {
        return endKilometer;
    }
}
