package com.exam.demo.Service;

import com.exam.demo.Model.Store;
import com.exam.demo.Repository.StoreRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

@Service
public class StoreService {
    private final StoreRepository storeRepository;

    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    // CREATE
    public Store create(Store s){
        return storeRepository.save(s);
    }

    // READ
    public List<Store> getAll(){
        return (List<Store>) storeRepository.findAll();
    }

    // READ by Id
    public Store getById(Long storeID){
        Optional<Store> oStore = storeRepository.findById(storeID);
        if( oStore.isPresent() ){
            return oStore.get();
        }
        else{
            throw new NoResultException("Nincs ilyen 'store' objektum.");
        }
    }

    // UPDATE
    public Store update(Store s){
        return storeRepository.save(s);
    }

    // DELETE
    public void Delete(Long storeID){
        storeRepository.deleteById(storeID);
    }

    // JPQL
    public List<Store> findByCity(String city) {
        List<Store> stores = storeRepository.findByCity(city);
        if( !CollectionUtils.isEmpty(stores) ) {
            return stores;
        }
        throw new NoResultException("Nincs találat");
    }

}
