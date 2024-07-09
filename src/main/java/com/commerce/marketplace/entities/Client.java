package com.commerce.marketplace.entities;
import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name = "clients")
@NoArgsConstructor @ToString  @EqualsAndHashCode
public class Client {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private Long id;
    @Getter @Setter private String nombre;
    @Getter @Setter private String apellido;
    @Getter @Setter private Integer dni;

}
