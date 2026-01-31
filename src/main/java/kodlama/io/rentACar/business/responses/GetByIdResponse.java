package kodlama.io.rentACar.business.responses;

public class GetByIdResponse {
    private int id;
    private String name;


    public GetByIdResponse(){

    }

    public GetByIdResponse(int id, String  Name){
        this.id=id;
        this.name=name;
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
}
