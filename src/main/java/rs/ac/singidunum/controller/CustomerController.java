package rs.ac.singidunum.controller;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.singidunum.entity.Customer;
import rs.ac.singidunum.service.CustomerService;

import java.util.List;

@Data
//Controller je klasa koja omogucava mapiranje nekih putanja u web pretrazivacu sa nekim kodom gde vracamo podatke u json formatu
@RestController
//Ova anotacija nam treba da kazemo koja ce biti osnovna putanja iza svih nasih drugih (sve sto se posalje preko ovog dole rutira se na ovu klasu)
@RequestMapping(path = "/api/customer")
//da se dozvoli sa svih origina da poziva api
@CrossOrigin
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService service;

    @GetMapping
    public List<Customer> getCustomers() {
        return service.getCustomers();
    }

    //ResponseEntity u pozadini napravi da ako taj customer ne postoji, ako je null - dobijemo 404 automatski
    @GetMapping(path = "/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Integer id) {
        return ResponseEntity.of(service.getCustomerById(id));
    }

    @PostMapping
    public Customer savedCustomer(@RequestBody Customer model) {

        return service.createCustomer(model);
    }

    @PutMapping(path = "/{id}")
    public Customer updateCustomer(@PathVariable Integer id, @RequestBody Customer model) {

        return service.updateCustomer(id, model);
    }

    @DeleteMapping(path = "/{id}")
    //po default ovo ovo vraca 200, ali mi hocemo da vrati 204 jer nema nikakav content (200 ocekuje da ima neki boady da vrati)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable Integer id) {
        service.deleteCustomer(id);
    }
}
