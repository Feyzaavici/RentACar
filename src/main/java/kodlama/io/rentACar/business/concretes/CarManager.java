package kodlama.io.rentACar.business.concretes;


import kodlama.io.rentACar.business.abstructs.CarService;
import kodlama.io.rentACar.business.rules.CarBusinessRules;
import kodlama.io.rentACar.core.utilies.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstructs.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarManager implements CarService {

    @Autowired
    private ModelMapperService modelMapperService;
    private CarRepository carRepository;
    private CarBusinessRules carBusinessRules;

    public CarManager (ModelMapperService modelMapperService, CarRepository carRepository,CarBusinessRules carBusinessRules ){
        this.carBusinessRules=carBusinessRules;
        this.carRepository=carRepository;
        this.modelMapperService=modelMapperService;
    }



}
