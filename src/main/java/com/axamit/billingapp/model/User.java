package com.axamit.billingapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Long bill;
    public User() {
    }
    public User(Long id, String name, Long bill) {
        this.id = id;
        this.name = name;
        this.bill = bill;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getBill() {
        return bill;
    }
    public void setBill(Long bill) {
        this.bill = bill;
    }
}
