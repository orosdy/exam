package com.exam.demo.Controller;

import com.exam.demo.Model.Customer;
import com.exam.demo.Service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // CREATE
    @PostMapping( path = "/createCustomer" )
    public Customer create(@RequestBody Customer c){
        return customerService.create(c);
    }

    // READ
    @GetMapping( path = "/getAllCustomers")
    public List<Customer> getAll(){
        return customerService.getAll();
    }

    // READ by Id (ISBN)
    @RequestMapping( method = RequestMethod.GET, value = "/getCustomer/{customerID}")
    public Customer findById(@PathVariable("customerID") Long customerID){
        return customerService.getById(customerID);
    }

    // UPDATE
    @PostMapping( path = "/updateCustomer")
    public Customer update(@RequestBody Customer c){
        return customerService.update(c);
    }

    // DELETE
    @RequestMapping( method = RequestMethod.DELETE, value = "/deleteCustomer/{customerID}")
    public void delete(@PathVariable("customerID") Long customerID){
        customerService.Delete(customerID);
    }

    // JPQL
    @GetMapping(value = "/getRegulars/{regular}")
    public List<Customer> findRegulars(@PathVariable("regular") Boolean regular){
        return customerService.findRegulars(regular);
    }

}