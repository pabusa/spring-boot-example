package com.pbs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
@RestController
@RequestMapping("api/v1/customers")
public class Application {

    private final CustomerRepository customerRepository;

    public Application(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @GetMapping()
    public  List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("{customerId}")
    public Optional<Customer> getCustomerById(@PathVariable("customerId") Integer id) {
        return customerRepository.findById(id);
    }

    record CustomerRequest(
            String name,
            String email,
            Integer age
    ){}

    @PostMapping
    public void addCustomer(@RequestBody CustomerRequest request){
        Customer customer = new Customer();
        customer.setName(request.name());
        customer.setEmail(request.email());
        customer.setAge(request.age());
        customerRepository.save(customer);
    }

    @DeleteMapping("{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Integer id){
        customerRepository.deleteById(id);
    }

    @PutMapping("{customerId}")
    public void updateCustomer(@PathVariable("customerId") Integer id,
                               @RequestBody CustomerRequest request){
        Customer customer = customerRepository.getReferenceById(id);
        customer.setName(request.name());
        customer.setEmail(request.email());
        customer.setAge(request.age());
        customerRepository.save(customer);
    }

    record CustomerNameRequest(String name){}
    @PatchMapping("{customerId}")
    public void updateCustomerName(@PathVariable("customerId") Integer id,
                                   @RequestBody CustomerNameRequest request){
        Customer customer = customerRepository.getReferenceById(id);
        customer.setName(request.name());
        customerRepository.save(customer);

    }
}
