package kodlama.io.rentACar.entities.concretes;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "operation_claims")
public class OperationClaim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy = "operationClaim")
    private List<UserOperationClaim> userOperationClaims;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UserOperationClaim> getUserOperationClaims() {
        return userOperationClaims;
    }

    public void setUserOperationClaims(List<UserOperationClaim> userOperationClaims) {
        this.userOperationClaims = userOperationClaims;
    }
}
