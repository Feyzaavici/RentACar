package kodlama.io.rentACar.business.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor; //lombokda ufak sorun olduğu için
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class CreateBrandRequest {

    @NotNull
    @NotBlank
    private String name;

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CreateBrandRequest(){

    }

    public CreateBrandRequest(String name){
        this.name=name;
    }
}
