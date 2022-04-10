package com.appvehicle.model;

import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
@Entity
@Table(name="USER_DETAILS")
public class UserDetailsEntity  {
	public UserDetailsEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
    //Validation of UserID
   // @Positive(message="UserId should be Positive")
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
    private int userId;
    
    //Validation of Address
    @NotNull(message="Address is mandatory")
    @Size(min=5,max=50)
	@Column(name="user_address")
	private String address;
    
    //Validation of State
    @NotBlank(message="State must contain atleat one non-white space character")
  
	@Column(name="user_state")
	private String state;
	public UserDetailsEntity( String address, String state, String city, String pin, String emptype,
			double salary, String aadhar, String pan, String salarySlip, String addressProof) {
		super();
		//this.userId = userId;
		this.address = address;
		this.state = state;
		this.city = city;
		this.pin = pin;
		this.emptype = emptype;
		this.salary = salary;
		this.aadhar = aadhar;
		this.pan = pan;
		this.salarySlip = salarySlip;
		this.addressProof = addressProof;
		
	}
	
	//Validation of City
    @Size(min=2,max=30)
	@Column(name="user_city", length=20)  
	private String city;
    
    //Validation of Pin
//    @Positive(message="Pin must be Positive")
	@Column(name="user_pin", length=20)
	private String pin;
     
    //Validation of Emptype
    @NotBlank(message="emptype must be entered")
	@Column(name="user_emptype", length=20)
	private String emptype;
	
    
    @Positive(message="Salary must be Positive")
    @DecimalMax("10000000000.00")
	@Column(name="user_salary")
	private double salary;
    
    //Validation of Aadhar
    
    @NotNull(message="Aadhar must be entered")
	@Column(name="user_aadhar_url", length=20)
	private String aadhar;
    
    //Validation of PanUrl
    
    @NotNull(message="Pan must be entered")
	@Column(name="user_pan_url", length=20)
	private String pan;
	
    //Validation of salary slip
    //www.salaryslip.com
    //@Pattern(regexp="\\bwww\\.[a-zA-Z0-9]{2,256}\\.com\\b")
    @NotNull(message="Userslip must be entered")
	@Column(name="user_salary_slip", length=20)
	private String salarySlip;
	
    //Validation of AddressProof
    @NotNull(message="Addressproof must be entered")
	@Column(name="user_address_proof", length=20)
	private String addressProof;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public String getEmptype() {
		return emptype;
	}
	public void setEmptype(String emptype) {
		this.emptype = emptype;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getAadhar() {
		return aadhar;
	}
	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public String getSalarySlip() {
		return salarySlip;
	}
	public void setSalarySlip(String salarySlip) {
		this.salarySlip = salarySlip;
	}
	public String getAddressProof() {
		return addressProof;
	}
	public void setAddressProof(String addressProof) {
		this.addressProof = addressProof;
	}
	

}
