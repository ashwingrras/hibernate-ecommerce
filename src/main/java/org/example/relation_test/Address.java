package org.example.relation_test;

import javax.persistence.*;
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // primary
    private Long id;
    private String street;
    private String city;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
