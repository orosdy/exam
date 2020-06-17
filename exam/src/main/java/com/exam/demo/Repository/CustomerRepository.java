package com.exam.demo.Repository;

import com.exam.demo.Model.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer,Long> {

    @Query(value = "select c from Customer c where regular = :regular")
    List<Customer> findRegulars(@Param("regular") Boolean regular );

}
