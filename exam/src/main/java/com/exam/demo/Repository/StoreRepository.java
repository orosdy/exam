package com.exam.demo.Repository;

import com.exam.demo.Model.Store;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreRepository extends CrudRepository<Store,Long> {

    @Query(value = "select s from Store s where city = :city")
    List<Store> findByCity(@Param("city") String city );

}
