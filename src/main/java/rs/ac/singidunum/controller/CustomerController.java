package rs.ac.singidunum.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.singidunum.entity.Customer;
import rs.ac.singidunum.repo.CustomerRepository;

import java.util.ArrayList;
import java.util.List;

//Controller je klasa koja omogucava mapiranje nekih putanja u web pretrazivacu sa nekim kodom gde vracamo podatke u json formatu
@RestController
//Ova anotacija nam treba da kazemo koja ce biti osnovna putanja iza svih nasih drugih (sve sto se posalje preko ovog dole rutira se na ovu klasu)
@RequestMapping(path = "/api/customer")
//da se dozvoli sa svih origina da poziva api
@CrossOrigin
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerRepository repository;

    @GetMapping
    public List<Customer> getCustomer() {
        List<Customer> list = new ArrayList<>();
        list = repository.findAll();
        return list;
    }
}
