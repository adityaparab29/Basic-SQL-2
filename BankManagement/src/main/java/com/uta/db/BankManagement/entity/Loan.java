package com.uta.db.BankManagement.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "LOAN")
public class Loan {

    @Id
    @Column(name = "Loan_Number")
    private Long loanNumber;

    @Column(name = "Amount")
    private Double amount;

    @OneToOne
    @JoinColumn(name = "Loan_Branch")
    private BankBranch loanBranch;

    @OneToOne(mappedBy = "loan", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Borrow borrow;

    @OneToMany(mappedBy = "loan", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
    private List<Payment> payment;

    public Loan() {
    }

    public Loan(Long loanNumber, Double amount, BankBranch loanBranch) {
        this.loanNumber = loanNumber;
        this.amount = amount;
        this.loanBranch = loanBranch;
    }

    public Long getLoanNumber() {
        return loanNumber;
    }

    public void setLoanNumber(Long loanNumber) {
        this.loanNumber = loanNumber;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public BankBranch getLoanBranch() {
        return loanBranch;
    }

    public void setLoanBranch(BankBranch loanBranch) {
        this.loanBranch = loanBranch;
    }

    public Borrow getBorrow() {
        return borrow;
    }

    public void setBorrow(Borrow borrow) {
        this.borrow = borrow;
    }

    public List<Payment> getPayment() {
        return payment;
    }

    public void setPayment(List<Payment> payment) {
        this.payment = payment;
    }
}
