package kodlama.io.rentACar.business.abstructs;


import kodlama.io.rentACar.business.requests.CreateCarRequest;
import kodlama.io.rentACar.business.requests.UpdateCarRequest;
import kodlama.io.rentACar.business.responses.GetAllCarsResponse;
import kodlama.io.rentACar.business.responses.GetByIdCarResponse;
import kodlama.io.rentACar.entities.concretes.Car;


import java.util.List;

public interface CarService {
    List<GetAllCarsResponse> getAll();
    GetByIdCarResponse getById(int id);
    void add(CreateCarRequest createCarRequest);
    void update(UpdateCarRequest updateCarRequest);
    void delete(int id);
    Car getCarEntityById(int id);

}
