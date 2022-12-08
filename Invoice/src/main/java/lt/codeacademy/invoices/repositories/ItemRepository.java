package lt.codeacademy.invoices.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lt.codeacademy.invoices.entities.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{

}