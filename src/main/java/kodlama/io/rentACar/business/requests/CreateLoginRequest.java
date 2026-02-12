package kodlama.io.rentACar.business.requests;

public class CreateLoginRequest {
    private String email;
    private String password;

    public CreateLoginRequest(String email, String password){
        this.email=email;
        this.password=password;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
