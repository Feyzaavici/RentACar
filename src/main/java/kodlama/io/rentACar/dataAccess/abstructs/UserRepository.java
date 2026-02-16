package kodlama.io.rentACar.dataAccess.abstructs;

import org.springframework.data.jpa.repository.JpaRepository;
import kodlama.io.rentACar.entities.concretes.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email) ;
    boolean existsByEmail(String email);


    @Query("SELECT oc.name FROM UserOperationClaim uoc " +
            "JOIN uoc.operationClaim oc " +
            "WHERE uoc.user.id = :userId")
    List<String> findClaimsByUserId(@Param("userId") int userId);
}
