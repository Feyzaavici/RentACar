package kodlama.io.rentACar.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import kodlama.io.rentACar.entities.enums.CarState;

import java.util.List;

@Entity
@Table(name="cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="plate", unique = true)
    private String plate;

    @Column(name="dailyPrice")
    private double dailyPrice;

    @Column(name="modelYear")
    private int modelYear;

    @Column(name="state")
    @Enumerated(EnumType.STRING)
    private CarState state; //Available, Rented, Maintenance

    @Column(name="current_kilometer")
    private Long currentKilometer;

    @ManyToOne
    @JoinColumn(name="model_id")
    private Model model;

    @JsonIgnore
    @OneToMany(mappedBy = "car")
    private List<Rental> rentals;

    public Car(){

    }

    public Car(int id, String plate, double dailyPrice, int modelYear, CarState state, Long currentKilometer){
        this.id=id;
        this.plate=plate;
        this.dailyPrice=dailyPrice;
        this.modelYear=modelYear;
        this.state=state;
        this.currentKilometer=currentKilometer;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getPlate(){
        return plate;
    }

    public void setPlate(String plate){
        this.plate=plate;
    }

    public double getDailyPrice() {
        return dailyPrice;
    }

    public void setDailyPrice(double dailyPrice) {
        this.dailyPrice = dailyPrice;
    }

    public int getModelYear(){
        return modelYear;
    }

    public void setModelYear( int modelYear){
        this.modelYear=modelYear;
    }

    public CarState getState(){
        return state;
    }

    public void setState(CarState state){
        this.state=state;
    }

    public Model getModel(){
        return model;
    }

    public void setModel( Model model){
        this.model=model;
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    public Long getCurrentKilometer() {
        return currentKilometer;
    }

    public void setCurrentKilometer(Long currentKilometer) {
        this.currentKilometer = currentKilometer;
    }
}
