package kodlama.io.rentACar.core.exceptions;

public class ProblemDetails {
     private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ProblemDetails(){

    };

    public ProblemDetails(String message){
        this.message=message;
    }
}
