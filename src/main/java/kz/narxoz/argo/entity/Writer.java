package kz.narxoz.argo.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Writers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Writer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fio", nullable = false)
    private String fio;
    @Column(name = "style", nullable = false)
    private String style;
    @Column(name = "date_birth", nullable = false)
    private int date_birth;


}
