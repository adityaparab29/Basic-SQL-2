package com.uta.db.BankManagement.entity;

public class AccountDto {
    private ACCOUNT_TYPE accountType;
    private Double balance;
    private String bankBranch;

    private String customerSSN;

    public AccountDto() {
    }

    public AccountDto(ACCOUNT_TYPE accountType, Double balance, String bankBranch, String customerSSN) {
        this.accountType = accountType;
        this.balance = balance;
        this.bankBranch = bankBranch;
        this.customerSSN = customerSSN;
    }

    public String getCustomerSSN() {
        return customerSSN;
    }

    public void setCustomerSSN(String customerSSN) {
        this.customerSSN = customerSSN;
    }

    public ACCOUNT_TYPE getAccountType() {
        return accountType;
    }

    public void setAccountType(ACCOUNT_TYPE accountType) {
        this.accountType = accountType;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getBankBranch() {
        return bankBranch;
    }

    public void setBankBranch(String bankBranch) {
        this.bankBranch = bankBranch;
    }
}
