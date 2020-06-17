package com.exam.demo.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "store_generator")
    @SequenceGenerator(name = "store_generator", sequenceName = "store_seq")

    private Long storeID;
    private String storeName;
    private int zip;
    private String city;
    private String street;
    private int houseNumber;
    private String manager;
    private String clerk;

}
