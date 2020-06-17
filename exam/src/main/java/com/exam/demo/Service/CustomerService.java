package com.exam.demo.Service;

import com.exam.demo.Model.Customer;
import com.exam.demo.Repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // CREATE
    public Customer create(Customer c){
        return customerRepository.save(c);
    }

    // READ
    public List<Customer> getAll(){
        return (List<Customer>) customerRepository.findAll();
    }

    // READ by Id (ISBN)
    public Customer getById(Long customerID){
        Optional<Customer> oCustomer = customerRepository.findById(customerID);
        if( oCustomer.isPresent() ){
            return oCustomer.get();
        }
        else{
            throw new NoResultException("Nincs ilyen 'customer' objektum.");
        }
    }

    // UPDATE
    public Customer update(Customer c){
        return customerRepository.save(c);
    }

    // DELETE
    public void Delete(Long customerID){
        customerRepository.deleteById(customerID);
    }

    // JPQL
    public List<Customer> findRegulars(Boolean regular) {
        List<Customer> customers = customerRepository.findRegulars(regular);
        if( !CollectionUtils.isEmpty(customers) ) {
            return customers;
        }
        throw new NoResultException("Nincs találat!");
    }


}
