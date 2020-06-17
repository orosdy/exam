package com.exam.demo.Controller;

import com.exam.demo.Model.Store;
import com.exam.demo.Service.StoreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StoreController {
    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    // CREATE
    @PostMapping( path = "/createStore" )
    public Store create(@RequestBody Store s){
        return storeService.create(s);
    }

    // READ
    @GetMapping( path = "/getAllStores")
    public List<Store> getAll(){
        return storeService.getAll();
    }

    // READ by Id
    @RequestMapping( method = RequestMethod.GET, value = "/getStore/{storeID}")
    public Store findById(@PathVariable("storeID") Long storeID){
        return storeService.getById(storeID);
    }

    // UPDATE
    @PostMapping( path = "/updateStore")
    public Store update(@RequestBody Store s){
        return storeService.update(s);
    }

    // DELETE
    @RequestMapping( method = RequestMethod.DELETE, value = "/deleteStore/{storeID}")
    public void delete(@PathVariable("storeID") Long storeID){
        storeService.Delete(storeID);
    }

    // JPQL
    @GetMapping(value = "/getbyCity/{city}")
    public List<Store> findByCity(@PathVariable("city") String city){
        return storeService.findByCity(city);
    }

}
