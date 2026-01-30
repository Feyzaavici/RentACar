package kodlama.io.rentACar.entities.concretes;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;


@Table(name="brands")
@Entity
//@Data
//@AllArgsConstructor
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;



    public Brand(){

    }

    public Brand(int id, String  Name){
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
