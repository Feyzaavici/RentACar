package kodlama.io.rentACar.dataAccess.abstructs;

import kodlama.io.rentACar.entities.concretes.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, Integer> {

}
