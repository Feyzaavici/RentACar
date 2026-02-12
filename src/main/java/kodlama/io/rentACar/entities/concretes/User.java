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

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;


    @OneToMany(mappedBy = "user")
    private List<UserOperationClaim> userOperationClaims;


    public User(){

    }

    public User (String firstname, String lastname,String email, String password){
        this.firstname=firstname;
        this.lastname=lastname;
        this.email=email;
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

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<UserOperationClaim> getUserOperationClaims() {
        return userOperationClaims;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserOperationClaims(List<UserOperationClaim> userOperationClaims) {
        this.userOperationClaims = userOperationClaims;
    }
}




