package kodlama.io.rentACar.business.requests;

import lombok.AllArgsConstructor; //lombokda ufak sorun olduğu için
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class CreateBrandRequest {

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
