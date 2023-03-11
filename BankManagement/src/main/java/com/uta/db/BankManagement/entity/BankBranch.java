package com.uta.db.BankManagement.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "BANK_BRANCH")
public class BankBranch {

    @Id
    @Column(name = "Branch_Name")
    private String branchName;

    @Column(name = "Assets")
    private Double assets;

    @Column(name = "Branch_City")
    private String branchCity;

    @OneToMany(mappedBy = "bankBranch", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private List<Account> account;

    @OneToOne(mappedBy = "loanBranch", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Loan loan;

    public BankBranch() {
    }

    public BankBranch(String branchName, Double assets, String branchCity) {
        this.branchName = branchName;
        this.assets = assets;
        this.branchCity = branchCity;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public Double getAssets() {
        return assets;
    }

    public void setAssets(Double assets) {
        this.assets = assets;
    }

    public String getBranchCity() {
        return branchCity;
    }

    public void setBranchCity(String branchCity) {
        this.branchCity = branchCity;
    }

    public List<Account> getAccount() {
        return account;
    }

    public void setAccount(List<Account> account) {
        this.account = account;
    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }
}
