package com.uta.db.BankManagement.entity;

import javax.persistence.*;

@Entity
@Table(name = "CUST_BANKER")
public class CustBanker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "Customer_SSN")
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "Realtionship_Officer")
    private Employee employee;

    @Column(name = "Role")
    private String role;

}
