package kodlama.io.rentACar.business.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateModelRequest {

    @NotNull
    @NotBlank
    private String name;

    @NotBlank
    @NotNull
    private int brandId;

    public CreateModelRequest(){

    }

    public CreateModelRequest(String name, int brandId){
        this.name=name;
        this.brandId=brandId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }
}
