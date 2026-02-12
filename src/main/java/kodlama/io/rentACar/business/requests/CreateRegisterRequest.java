package kodlama.io.rentACar.business.requests;

public class CreateRegisterRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;


    public CreateRegisterRequest (String firstName, String lastName, String email, String password){
        this.firstName=firstName;
        this.lastName=lastName;
        this.password=password;
        this.email=email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
