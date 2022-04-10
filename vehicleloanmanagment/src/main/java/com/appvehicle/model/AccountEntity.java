package com.appvehicle.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Positive;

@Entity
@Table(name="ACCOUNTS")
public class AccountEntity {
	
	public AccountEntity(){
		
	}
	public AccountEntity(int accountNo, UserDetailsEntity user) {
		super();
		this.accountNo = accountNo;
		this.user = user;
	}
	public long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	public UserDetailsEntity getUser() {
		return user;
	}
	public void setUser(UserDetailsEntity user) {
		this.user = user;
	}
	
	
	//Validation of accountNo
    @Positive(message="Account number must be Poisitve")
	@Id
	@Column(name="account_no")
	private int accountNo;	
    
    //Validation of UserId
    
	@OneToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private UserDetailsEntity user;
	

	
}
