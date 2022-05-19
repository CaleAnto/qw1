package kz.narxoz.argo.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Books")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name" , nullable = false)
    private String name;
    @Column(name ="genre", nullable = false)
    private String genre;
    @Column(name="estimation", nullable = false)
    private int estimation;
    @Column(name = "sell", nullable = false)
    private int sell;

    @Column(name = "writer_id", nullable = false)
    private Long writer;

}
