package kz.narxoz.argo.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Place")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "company" , nullable = false)
    private String company;
    @Column(name ="address", nullable = false)
    private String address;

}
