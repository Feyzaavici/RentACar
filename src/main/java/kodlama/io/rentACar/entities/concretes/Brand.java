package kodlama.io.rentACar.entities.concretes;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;


@Table(name="brands")
@Entity
@Data
@AllArgsConstructor
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

}
