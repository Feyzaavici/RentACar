package kodlama.io.rentACar.business.abstructs;


import kodlama.io.rentACar.business.requests.CreateCarRequest;
import kodlama.io.rentACar.business.requests.UpdateCarRequest;
import kodlama.io.rentACar.business.responses.GetAllCarsResponse;
import kodlama.io.rentACar.business.responses.GetByIdCarResponse;
import kodlama.io.rentACar.entities.concretes.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CarService {
   // List<GetAllCarsResponse> getAll();
   Page<GetAllCarsResponse> getAll(Pageable pageable);
    GetByIdCarResponse getById(int id);
    void add(CreateCarRequest createCarRequest);
    void update(UpdateCarRequest updateCarRequest);
    void delete(int id);
    Car getCarEntityById(int id);
    void markAsRented(Car car);
    void markAsAvailable(Car car);
    Page<GetAllCarsResponse> getAllByBrandId(int brandId, Pageable pageable);

}
