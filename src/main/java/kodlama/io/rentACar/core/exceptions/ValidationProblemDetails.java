package kodlama.io.rentACar.core.exceptions;

import java.util.Map;

public class ValidationProblemDetails extends ProblemDetails {
    private Map<String,String > validationErrors;

    public ValidationProblemDetails() {
    }

    public ValidationProblemDetails(Map<String, String> validationErrors) {
        this.validationErrors = validationErrors;
    }

    public Map<String, String> getValidationErrors() {
        return validationErrors;
    }

    public void setValidationErrors(Map<String, String> validationErrors) {
        this.validationErrors = validationErrors;
    }

}

