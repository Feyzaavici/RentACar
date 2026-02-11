package kodlama.io.rentACar.entities.concretes;

import jakarta.persistence.*;


@Entity
@Table(name = "user_operation_claims")
public class UserOperationClaim {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "operation_claim_id")
    private OperationClaim operationClaim;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public OperationClaim getOperationClaim() {
        return operationClaim;
    }

    public void setOperationClaim(OperationClaim operationClaim) {
        this.operationClaim = operationClaim;
    }


}
