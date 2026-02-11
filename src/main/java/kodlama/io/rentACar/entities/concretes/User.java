package kodlama.io.rentACar.entities.concretes;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name="users")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="first_name")
    private String firstname;

    @Column(name="last_name")
    private String lastname;

    @Column(name="password")
    private String password;

    @OneToMany(mappedBy = "user")
    private List<UserOperationClaim> userOperationClaims;


    public User(){

    }

    public User (String firstname, String lastname, String password){
        this.firstname=firstname;
        this.lastname=lastname;
        this.password=password;
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPassword() {
        return password;
    }


}




