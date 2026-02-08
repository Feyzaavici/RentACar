package kodlama.io.rentACar.dataAccess.abstructs;

import kodlama.io.rentACar.entities.concretes.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {
    boolean existsByPlate(String plate);

    Page<Car> findByModel_Brand_Id(int brandId, Pageable pageable);

}
