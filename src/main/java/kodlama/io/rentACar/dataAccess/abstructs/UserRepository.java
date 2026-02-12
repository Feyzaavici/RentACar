package kodlama.io.rentACar.dataAccess.abstructs;

import org.springframework.data.jpa.repository.JpaRepository;
import kodlama.io.rentACar.entities.concretes.User;


public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email) ;
    boolean existsByEmail(String email);
}
