package kodlama.io.rentACar.business.concretes;

import kodlama.io.rentACar.business.abstructs.CarService;
import kodlama.io.rentACar.business.abstructs.RentalService;
import kodlama.io.rentACar.business.requests.CreateRentalRequest;
import kodlama.io.rentACar.business.requests.ReturnRentalRequest;
import kodlama.io.rentACar.business.rules.RentalBusinessRules;
import kodlama.io.rentACar.core.exceptions.BusinessException;
import kodlama.io.rentACar.core.utilies.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstructs.RentalRepository;
import kodlama.io.rentACar.entities.concretes.Car;
import kodlama.io.rentACar.entities.concretes.Rental;
import kodlama.io.rentACar.entities.enums.CarState;
import org.springframework.stereotype.Service;

@Service
public class RentalManager implements RentalService {
    ModelMapperService modelMapperService;
    RentalRepository rentalRepository;
    RentalBusinessRules rentalBusinessRules;
    CarService carService;


    public RentalManager( ModelMapperService modelMapperService,RentalRepository rentalRepository, RentalBusinessRules rentalBusinessRules, CarService carService){
       this.modelMapperService=modelMapperService;
        this.rentalRepository=rentalRepository;
        this.rentalBusinessRules=rentalBusinessRules;
        this.carService= carService;
    }


    @Override
    public void add(CreateRentalRequest createRentalRequest) {
        rentalBusinessRules.checkIfCarAvailable(createRentalRequest.getCarId());
        rentalBusinessRules.checkIfRentDateBeforeToday(createRentalRequest.getRentDate());

        Car car = carService.getCarEntityById(createRentalRequest.getCarId());

        Rental rental = modelMapperService.forRequest().map(createRentalRequest, Rental.class);
        rental.setCar(car);
        rental.setStartKilometer(car.getCurrentKilometer());

        this.carService.markAsRented(car);
        this.rentalRepository.save(rental);

    }



    @Override
    public void returnRental(ReturnRentalRequest returnRentalRequest) {

        Rental rental = rentalRepository.findById(returnRentalRequest.getRentalId()).orElseThrow(() -> new BusinessException("Rental not found"));
        this.rentalBusinessRules.checkIfReturnDateBeforeRentDate(returnRentalRequest.getRentalId(),returnRentalRequest.getReturnDate());
        this.modelMapperService.forRequest().map(returnRentalRequest, rental);

        Car car = rental.getCar();
        car.setCurrentKilometer(returnRentalRequest.getEndKilometer());

        this.carService.markAsAvailable(car);
        this.rentalRepository.save(rental);


    }
}
