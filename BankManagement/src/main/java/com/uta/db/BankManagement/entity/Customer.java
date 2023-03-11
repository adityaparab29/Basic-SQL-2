package com.uta.db.BankManagement.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CUSTOMER")
public class Customer {

    @Id
    @Column(name = "SSN")
    private String ssn;

    @Column(name = "Name")
    private String name;

    @Column(name = "Street")
    private String street;

    @Column(name = "City")
    private String city;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private CustBanker custBanker;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private List<CusAcc> cusAcc;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private List<Borrow> borrow;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private List<Dependent> dependent;

    public Customer() {
    }

    public Customer(String ssn, String name, String street, String city) {
        this.ssn = ssn;
        this.name = name;
        this.street = street;
        this.city = city;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String SSN) {
        this.ssn = SSN;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public CustBanker getCustBanker() {
        return custBanker;
    }

    public void setCustBanker(CustBanker custBanker) {
        this.custBanker = custBanker;
    }

    public List<CusAcc> getCusAcc() {
        return cusAcc;
    }

    public void setCusAcc(List<CusAcc> cusAcc) {
        this.cusAcc = cusAcc;
    }

    public List<Dependent> getDependent() {
        return dependent;
    }

    public void setDependent(List<Dependent> dependent) {
        this.dependent = dependent;
    }

    public List<Borrow> getBorrow() {
        return borrow;
    }

    public void setBorrow(List<Borrow> borrow) {
        this.borrow = borrow;
    }
}
