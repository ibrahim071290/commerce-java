package com.commerce.marketplace.repositories;

import com.commerce.marketplace.entities.InvoiceDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceDetallesRepository extends JpaRepository<InvoiceDetalle, Long>{
}
