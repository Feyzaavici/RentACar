package kodlama.io.rentACar.business.requests;

public class UpdateBrandRequest {
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
