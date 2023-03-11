package com.uta.db.BankManagement.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "CUS_ACC")
public class CusAcc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Account_Number")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "Account_Holder")
    private Customer customer;

    @Column(name = "Access_Date")
    private Date accessDate;

    public CusAcc() {
    }

    public CusAcc(Account account, Customer customer, Date accessDate) {
        this.account = account;
        this.customer = customer;
        this.accessDate = accessDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getAccessDate() {
        return accessDate;
    }

    public void setAccessDate(Date accessDate) {
        this.accessDate = accessDate;
    }
}
