package kodlama.io.rentACar.business.rules;

import kodlama.io.rentACar.business.abstructs.CarService;
import kodlama.io.rentACar.core.exceptions.BusinessException;
import kodlama.io.rentACar.entities.concretes.Car;
import kodlama.io.rentACar.entities.enums.CarState;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class RentalBusinessRules {
    CarService carService;

    public RentalBusinessRules(CarService carService) {
        this.carService = carService;
    }


    public void checkIfCarAvailable(int id){
        Car car =this.carService.getCarEntityById(id);
        if (car.getState() != CarState.AVAILABLE){
            throw new BusinessException("The car is not available for rent.");
        }

    }

    public void checkIfKilometerValid(int id, int startKilometer){
        Car car =this.carService.getCarEntityById(id);
        if(startKilometer< car.getCurrentKilometer()){
            throw new BusinessException("Start kilometer cannot be less than current kilometer.");
        }
    }

    public void checkIfRentDateBeforeToday(LocalDate rentDate){
        LocalDate today = LocalDate.now();
        if(rentDate.isBefore(today)){
            throw new BusinessException("Rent date cannot be before today.");
        }
    }

    public void checkIfReturnDateBeforeRentDate( LocalDate rentDate,LocalDate returnDate){
        if(returnDate.isBefore(rentDate)){
            throw new BusinessException(" Return date cannot be before rent date.");
        }

    }


    public void checkMaxRentDay(LocalDate rentDate, LocalDate returnDate){
        if(ChronoUnit.DAYS.between(returnDate,rentDate)>25){
            throw new BusinessException("Maximum rent duration is 25 days.");
        }
    }


}
