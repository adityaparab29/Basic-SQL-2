package com.uta.db.BankManagement.entity;

import javax.persistence.*;

@Entity
@Table(name = "DEPENDENT")
public class Dependent {

    @Id
    @Column(name = "Name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "Employee_SSN")
    private Customer customer;

    public Dependent() {
    }

    public Dependent(String name, Customer customer) {
        this.name = name;
        this.customer = customer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
