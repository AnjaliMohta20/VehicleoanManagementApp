package com.appvehicle.model;

import java.time.LocalDate;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table(name="APPROVED_LOANS")
public class ApprovedLoansEntity 
{
    public ApprovedLoansEntity() {
        super();
    }
    @Id @GeneratedValue
    @Column(name="approvedloanid")
    @NotNull(message = "LoanId should not be Null")
    @NotBlank(message = "LoanId should not be Blank")
    private int loanId;
    
    @Column(name="emi_amount")
    @NotNull(message = "EMI should not be Null")
    @NotBlank(message = "EMI should not be Blank")
    private double emi;
    
    @Column(name="emi_starting_date")
    @NotNull(message = "EMIDate should not be Null")
    @NotBlank(message = "EMIDate should not be Blank")
    private LocalDate emidate;
    
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(cascade= {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinColumn(name="account_no")
    @NotNull(message = "Account should not be Null")
    @NotBlank(message = "Account should not be Blank")
    private AccountEntity account;
    
    
    @OneToOne(cascade= {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST},fetch = FetchType.LAZY)
   
    @JoinColumn(name="chassis_no")
    
    private LoanApplicationEntity loanapp;
    public ApprovedLoansEntity(int loanId, double emi, LocalDate emidate, AccountEntity account, LoanApplicationEntity loanapp)
    {
        super();
        this.loanId = loanId;
        this.emi = emi;
        this.emidate = emidate;
        this.account = account;
        this.loanapp = loanapp;
    }
    public int getLoanId()
    {
        return loanId;
    }
    public void setLoanId(int loanId)
    {
        this.loanId = loanId;}
    public double getEmi()
    {
        return emi;
    }
    public void setEmi(double emi)
    {
        this.emi = emi;
    }
    public LocalDate getEmidate()
    {
        return emidate;
    }
    public void setEmidate(LocalDate emidate) {
        this.emidate = emidate;
    }
    public AccountEntity getAccount()
    {
        return account;
    }
    public void setAccount(AccountEntity account)
    {
        this.account = account;
}
    public LoanApplicationEntity getLoanapp() 
    {
        return loanapp;
    }
    public void setLoanapp(LoanApplicationEntity loanapp)
    {
        this.loanapp = loanapp;
    }
 

}