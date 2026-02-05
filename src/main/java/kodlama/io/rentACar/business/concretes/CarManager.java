package kodlama.io.rentACar.business.concretes;


import kodlama.io.rentACar.business.abstructs.CarService;
import kodlama.io.rentACar.business.requests.CreateCarRequest;
import kodlama.io.rentACar.business.requests.UpdateCarRequest;

import kodlama.io.rentACar.business.responses.GetAllCarsResponse;
import kodlama.io.rentACar.business.responses.GetByIdCarResponse;

import kodlama.io.rentACar.business.rules.CarBusinessRules;

import kodlama.io.rentACar.core.utilies.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstructs.CarRepository;
import kodlama.io.rentACar.entities.concretes.Car;

import kodlama.io.rentACar.entities.enums.CarState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


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


    @Override
    public List<GetAllCarsResponse> getAll() {
        List<Car> cars = carRepository.findAll();
        List<GetAllCarsResponse> carsResponse = cars.stream()
                .map(car -> this.modelMapperService.forResponse().map(car, GetAllCarsResponse.class))
                .collect(Collectors.toList());
        return carsResponse;

    }

    @Override
    public GetByIdCarResponse getById(int id) {
        Car car = this.carRepository.findById(id).orElseThrow();
        GetByIdCarResponse response =this.modelMapperService.forResponse().map(car,GetByIdCarResponse.class);
        return response;
    }

    @Override
    public void add(CreateCarRequest createCarRequest) {

        this.carBusinessRules.checkIfCarPlateAlreadyExists(createCarRequest.getPlate());
        this.carBusinessRules.checkIfPlateFormatIsValid(createCarRequest.getPlate());

        Car car = this.modelMapperService.forRequest().map(createCarRequest,Car.class);
        car.setState(CarState.valueOf("AVAILABLE"));
        this.carRepository.save(car);

    }

    @Override
    public void update(UpdateCarRequest updateCarRequest) {
        this.carBusinessRules.checkIfCarCanBeUpdate(updateCarRequest.getCarId());

        Car car = this.modelMapperService.forRequest().map(updateCarRequest,Car.class);
        this.carRepository.save(car);

    }

    @Override
    public void delete(int id) {
        this.carBusinessRules.checkIfCarCanBeDelete(id);
        this.carRepository.deleteById(id);

    }
}
