package kodlama.io.rentACar.dataAccess.abstructs;

import kodlama.io.retACar.entities.concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;


public interface BrandRepository extends JpaRepository<Brand, Integer> {

}
