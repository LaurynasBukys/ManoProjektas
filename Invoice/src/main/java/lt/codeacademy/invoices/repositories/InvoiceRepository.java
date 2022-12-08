package lt.codeacademy.invoices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lt.codeacademy.invoices.entities.Invoice;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long>{

}
