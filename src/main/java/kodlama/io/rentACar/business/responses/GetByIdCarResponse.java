package kodlama.io.rentACar.business.responses;

public class GetByIdCarResponse {
    private int id;
    private String plate;
    private double dailyPrice;
    private String state;
    private String brandName;
    private String modelName;

    public GetByIdCarResponse(){

    }

    public GetByIdCarResponse(int id, String  plate, double dailyPrice, String state, String brandName, String modelName){
        this.id=id;
        this.plate=plate;
        this.dailyPrice=dailyPrice;
        this.state=state;
        this.brandName=brandName;
        this.modelName=modelName;
    }

    public int getId() {
        return id;
    }

    public String getPlate() {
        return plate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public double getDailyPrice() {
        return dailyPrice;
    }

    public void setDailyPrice(double dailyPrice) {
        this.dailyPrice = dailyPrice;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
