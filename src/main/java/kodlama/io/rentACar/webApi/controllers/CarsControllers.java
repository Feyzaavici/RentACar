package kodlama.io.rentACar.webApi.controllers;

import jakarta.validation.Valid;
import kodlama.io.rentACar.business.abstructs.CarService;
import kodlama.io.rentACar.business.requests.CreateCarRequest;

import kodlama.io.rentACar.business.requests.UpdateCarRequest;

import kodlama.io.rentACar.business.responses.GetAllCarsResponse;
import kodlama.io.rentACar.business.responses.GetByIdCarResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarsControllers {
    private CarService carService;

    public CarsControllers(CarService carService){
        this.carService=carService;
    }

    @GetMapping()
    public List<GetAllCarsResponse> getAll(){

        return carService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdCarResponse getByIdResponse(@PathVariable int id){
        return carService.getById(id);
    }

    @PostMapping()
    @ResponseStatus(code= HttpStatus.CREATED)
    public void add(@Valid @RequestBody CreateCarRequest createCarRequest){
        this.carService.add(createCarRequest);
    }

    @PutMapping
    public void update( @RequestBody UpdateCarRequest updateCarRequest){
        this.carService.update(updateCarRequest);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.carService.delete(id);
    }



}
