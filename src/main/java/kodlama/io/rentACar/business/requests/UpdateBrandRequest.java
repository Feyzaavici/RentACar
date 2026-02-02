package kodlama.io.rentACar.business.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UpdateBrandRequest {

    @NotNull
    @NotBlank
    private String name;

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UpdateBrandRequest(){

    }

    public UpdateBrandRequest(String name){
        this.name=name;
    }
}
