package rs.ac.singidunum.repo;

//repo-ovi se prave kao interfejs jer to koristi dependency injection u pozadini i da on na osnovu interfejsa moze da
//konstruise (pomocu refleksije u Javi) instancu takvog interfejsa koja bi implementirala pravilno imena tih metoda.
//To olaksava kako pisemo upite ka bazi

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.singidunum.entity.Customer;

import java.util.List;

//Ima dva interfejsa koje moze extendovati - CRUD i JPA. Ovaj prvi je stariji, vise basic.
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    List<Customer> findAllByDeletedAtIsNull();
}
