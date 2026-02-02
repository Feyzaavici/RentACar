package kodlama.io.rentACar.business.responses;

public class GetAllModelsResponse {

    private int id;
    private String name;
    private String brandName;


    public GetAllModelsResponse(){

    }

    public GetAllModelsResponse(int id, String  name, String brandName){
        this.id=id;
        this.name=name;
        this.brandName=brandName;
    }

    public int getId() {
        return id;
    }

    public String getName() {

        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrandName() {

        return brandName;
    }

    public void setBrandName( String brandName) {
        this.brandName=brandName;
    }
}
