package com.uta.db.BankManagement.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {
    @Id
    @Column(name = "SSN")
    private String ssn;

    @Column(name = "Name")
    private String name;

    @Column(name = "Telephone_Number")
    private String telephoneNumber;

    @Column(name = "Start_Date")
    private Date startDate;

    @Column(name = "Manager_SSN")
    private String managerSSN;

    @Column(name = "Is_Manager")
    private Boolean managerFlag;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
    private CustBanker custBanker;

    public Employee() {
    }

    public Employee(String ssn, String name, String telephoneNumber, Date startDate, String managerSSN, Boolean managerFlag) {
        this.ssn = ssn;
        this.name = name;
        this.telephoneNumber = telephoneNumber;
        this.startDate = startDate;
        this.managerSSN = managerSSN;
        this.managerFlag = managerFlag;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getManagerSSN() {
        return managerSSN;
    }

    public void setManagerSSN(String managerSSN) {
        this.managerSSN = managerSSN;
    }

    public Boolean getManagerFlag() {
        return managerFlag;
    }

    public void setManagerFlag(Boolean managerFlag) {
        this.managerFlag = managerFlag;
    }

    public CustBanker getCustBanker() {
        return custBanker;
    }

    public void setCustBanker(CustBanker custBanker) {
        this.custBanker = custBanker;
    }
}
