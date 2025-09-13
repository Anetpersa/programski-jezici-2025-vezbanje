package rs.ac.singidunum.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.ac.singidunum.entity.Customer;
import rs.ac.singidunum.repo.CustomerRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;

    public List<Customer> getCustomers() {
        return repository.findAllByDeletedAtIsNull();
    }

    public Optional<Customer> getCustomerById(Integer id) {
        return repository.findByIdAndDeletedAtIsNull(id);
    }

    public Customer createCustomer(Customer model) {
        Customer customer = new Customer();
        customer.setFirstName(model.getFirstName());
        customer.setLastName(model.getLastName());
        customer.setPhone(model.getPhone());
        customer.setEmail(model.getEmail());
        customer.setUmcn(model.getUmcn());
        customer.setTaxId(model.getTaxId());
        customer.setCreatedAt(LocalDateTime.now());
        return repository.save(customer);
    }

    public Customer updateCustomer(Integer id) {
        Customer customer = repository.findByIdAndDeletedAtIsNull(id).orElseThrow();

        customer.setFirstName(customer.getFirstName());
        customer.setLastName(customer.getLastName());
        customer.setPhone(customer.getPhone());
        customer.setEmail(customer.getEmail());
        customer.setUmcn(customer.getUmcn());
        customer.setTaxId(customer.getTaxId());
        customer.setUpdatedAt(LocalDateTime.now());
        return repository.save(customer);
    }

    public void deleteCustomer(Integer id) {
        Customer customer = repository.findByIdAndDeletedAtIsNull(id).orElseThrow();
        customer.setDeletedAt(LocalDateTime.now());
        repository.save(customer);
    }
}
