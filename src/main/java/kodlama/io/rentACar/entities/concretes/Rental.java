package kodlama.io.rentACar.entities.concretes;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="rentals")
public class Rental {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name="id")
    private int id;

   @Column(name="customer_id")
   private int customerId;

   @Column(name="rent_date")
    private LocalDate rentDate;
   @Column(name="return_date")
    private LocalDate returnDate;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @Column(name="start_kilometer")
    private long startKilometer;

    @Column(name="end_kilometer")
    private long endKilometer;



    public Rental() {
    }

    public Rental(int id, Car car, LocalDate rentDate, LocalDate returnDate, long startKilometer, long endKilometer, int customerId) {
        this.id = id;
        this.car = car;
        this.rentDate = rentDate;
        this.returnDate = returnDate;
        this.startKilometer=startKilometer;
        this.endKilometer=endKilometer;
        this.customerId=customerId;
    }

    public int getId() {
        return id;
    }

    public Car getCar() {
        return car;
    }

    public LocalDate getRentDate() {
        return rentDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setRentDate(LocalDate rentDate) {
        this.rentDate = rentDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public long getEndKilometer() {
        return endKilometer;
    }

    public void setStartKilometer(long startKilometer) {
        this.startKilometer = startKilometer;
    }

    public long getStartKilometer() {
        return startKilometer;
    }

    public void setEndKilometer(long endKilometer) {
        this.endKilometer = endKilometer;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}
