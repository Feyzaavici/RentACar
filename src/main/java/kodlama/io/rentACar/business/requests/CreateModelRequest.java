package kodlama.io.rentACar.business.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateModelRequest {

    @NotNull
    @NotBlank
    private String name;

    @NotBlank
    @NotNull
    private int BranId;

    public CreateModelRequest(){

    }

    public CreateModelRequest(String name, int BranId){
        this.name=name;
        this.BranId=BranId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getBranId() {
        return BranId;
    }

    public void setBranId(int branId) {
        BranId = branId;
    }
}
