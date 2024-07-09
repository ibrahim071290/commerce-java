package com.commerce.marketplace.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name = "invoicesDetalle")
@NoArgsConstructor @ToString  @EqualsAndHashCode
public class InvoiceDetalle {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private Long id;
    @Getter @Setter private Integer amoun;
    @Getter @Setter private double price;

    @ManyToOne
    @JoinColumn(name = "invoice_id")
    @Getter @Setter private Invoice invoice_id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @Getter @Setter private Product product_id;

}
