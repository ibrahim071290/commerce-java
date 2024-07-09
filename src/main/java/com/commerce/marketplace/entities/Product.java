package com.commerce.marketplace.entities;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity @Table(name = "product")
@NoArgsConstructor @ToString  @EqualsAndHashCode
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;
    @Getter @Setter private String description;
    @Getter @Setter private String code;
    @Getter @Setter private Integer stock;
    @Getter @Setter private double price;

    @OneToMany(mappedBy = "product_id", cascade = CascadeType.ALL, orphanRemoval = true)
    @Getter @Setter private List<InvoiceDetalle> invoiceDetalles;

}
