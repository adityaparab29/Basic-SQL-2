package com.uta.db.BankManagement.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PAYMENT")
public class Payment {
    @Id
    @Column(name = "Payment_Number")
    private Long paymentNumber;

    @Column(name = "Payment_Date")
    private Date paymentDate;

    @Column(name = "Payment_Amount")
    private Double paymentAmount;

    @ManyToOne
    @JoinColumn(name = "Loan_Number")
    private Loan loan;

    public Payment() {
    }

    public Payment(Long paymentNumber, Date paymentDate, Double paymentAmount, Loan loan) {
        this.paymentNumber = paymentNumber;
        this.paymentDate = paymentDate;
        this.paymentAmount = paymentAmount;
        this.loan = loan;
    }

    public Long getPaymentNumber() {
        return paymentNumber;
    }

    public void setPaymentNumber(Long paymentNumber) {
        this.paymentNumber = paymentNumber;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(Double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }
}
