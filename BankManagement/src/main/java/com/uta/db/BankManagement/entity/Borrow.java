package com.uta.db.BankManagement.entity;

import javax.persistence.*;

@Entity
@Table(name = "BORROW")
public class Borrow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Loan_Number")
    private Loan loan;

    @ManyToOne
    @JoinColumn(name = "Loan_Customer")
    private Customer customer;

    public Borrow() {
    }

    public Borrow(Long id, Loan loan, Customer customer) {
        this.id = id;
        this.loan = loan;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
