package com.uta.db.BankManagement.entity;

public class LoanDto {
    private Long loanNumber;
    private Double amount;
    private String loanBranch;
    private String customerId;
    private Double paymentAmount = 0D;
    private int paymentsMade = 0;
    private Double residualAmount;

    public LoanDto() {
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

    public String getLoanBranch() {
        return loanBranch;
    }

    public void setLoanBranch(String loanBranch) {
        this.loanBranch = loanBranch;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(Double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public int getPaymentsMade() {
        return paymentsMade;
    }

    public void setPaymentsMade(int paymentsMade) {
        this.paymentsMade = paymentsMade;
    }

    public Double getResidualAmount() {
        return residualAmount;
    }

    public void setResidualAmount(Double residualAmount) {
        this.residualAmount = residualAmount;
    }
}
