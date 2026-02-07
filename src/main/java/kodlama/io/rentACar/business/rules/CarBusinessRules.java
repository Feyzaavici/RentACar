package kodlama.io.rentACar.business.rules;

import kodlama.io.rentACar.core.exceptions.BusinessException;
import kodlama.io.rentACar.dataAccess.abstructs.CarRepository;

import kodlama.io.rentACar.entities.concretes.Car;
import kodlama.io.rentACar.entities.enums.CarState;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarBusinessRules {
    private CarRepository carRepository;

    public CarBusinessRules(CarRepository carRepository){
        this.carRepository=carRepository;
    }

    public void checkIfCarPlateAlreadyExists(String plate){
        if(this.carRepository.existsByPlate( plate)){
            throw new BusinessException("Plate already exists.");
        }
    }


    public void checkIfPlateFormatIsValid(String plate){
        String regex = "^[0-9]{2}[A-Z]{1,3}[0-9]{2,4}$";

        if(plate == null||!plate.matches(regex)){
            throw new BusinessException("Invalid plate format.");

        }
    }


    /* public void checkIfCarIsAvailableForRent(int id){
       Car car= this.carRepository.findById(id)
               .orElseThrow(() -> new BusinessException("Car is not exist."));
       if(car.getState()== CarState.RENTED || car.getState()==CarState.MAINTENANCE){
           throw new BusinessException("Car is not available for rent.");
       }
     }*/


     public void checkIfCarCanBeUpdate(int id){
        Car car =this.carRepository.findById(id).orElseThrow(() -> new BusinessException("Car is not exists."));
        if(car.getState()==CarState.MAINTENANCE || car.getState()==CarState.RENTED){
            throw new BusinessException("Car is not available for update.");
        }

     }

    public void checkIfCarCanBeDelete(int id){
        Car car =this.carRepository.findById(id).orElseThrow(() -> new BusinessException("Car is not exists."));
        if(car.getState()==CarState.MAINTENANCE || car.getState()==CarState.RENTED){
            throw new BusinessException("Car is not available for delete.");
        }

    }
}
