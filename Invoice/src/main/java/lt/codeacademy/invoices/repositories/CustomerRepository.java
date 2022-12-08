package lt.codeacademy.invoices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lt.codeacademy.invoices.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
