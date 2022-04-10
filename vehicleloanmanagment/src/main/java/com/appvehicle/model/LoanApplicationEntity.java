package com.appvehicle.model;

import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Entity
@Table(name="LOAN_APPLICATION")
public class LoanApplicationEntity {
	public LoanApplicationEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	private static final long serialVersionUID = 1L;
	
    @Id
    @Column(name="chassis_no",length=20)
    @NotNull(message="chassis number cannot be null")
    @NotEmpty(message="chassis number cannot be empty")
	private String chassisNo="default";
    
    @Column(name="existing_emi")
    @NotNull(message="Existing emi amount cannot be null")
	private double existingEMI;
    
    
    @Column(name="loan_tenure")
    @NotNull(message="tenure cannot be null")
    @Min(1)
    @Max(30)
	private int tenure;
    
    @Column(name="loan_interest")
    @NotNull(message="interest cannot be null")
	private double interest;
    
    @Column(name="loan_amount")
    @NotNull(message="loan amount cannot be null")
	private double amount;
    
    @Column(name="loan_application_date")
    @NotNull(message="loan application date cannot be null")
	private LocalDate appdate;
    
    @Column(name="loan_application_status", length=20)
    @NotNull(message="loan application status cannot be null")
	private String status="Pending";
    
    @Column(name="vehicle_brand", length=20)
    @NotNull(message="vehicle brand cannot be null")
	private String brand;
    
    @NotNull(message="vehicle colour cannot be null")
    @Column(name="vehicle_colour", length=20)
	private String colour;
    
    @NotNull(message="vehicle model cannot be null")
    @Column(name="vehicle_model", length=20)
	private String model;
    
    @Min(2)
    @Max(18)
    @Column(name="vehicle_type")
	private int type;
    
    @Min(25000)
    @Column(name="vehicle_ex_showroom_price")
	private double exShowPrice;
    
    @Min(30000)
    @Column(name="vehicle_on_road_price")
	private double onRoadPrice;
    
	@ManyToOne(cascade={CascadeType.REFRESH,CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="user_id")
	private UserDetailsEntity user;
	
	
	public LoanApplicationEntity(String chassisNo, double existingEMI, int tenure, double interest, double amount,
			LocalDate appdate, String status, String brand, String colour, String model, int type, double exShowPrice,
			double onRoadPrice, UserDetailsEntity user) {
		super();
		this.chassisNo = chassisNo;
		this.existingEMI = existingEMI;
		this.tenure = tenure;
		this.interest = interest;
		this.amount = amount;
		this.appdate = appdate;
		this.status = status;
		this.brand = brand;
		this.colour = colour;
		this.model = model;
		this.type = type;
		this.exShowPrice = exShowPrice;
		this.onRoadPrice = onRoadPrice;
		this.user = user;
		//this.approved = approved;
	}
	public String getChassisNo() {
		return chassisNo;
	}
	public void setChassisNo(String chassisNo) {
		this.chassisNo = chassisNo;
	}
	public double getExistingEMI() {
		return existingEMI;
	}
	public void setExistingEMI(double existingEMI) {
		this.existingEMI = existingEMI;
	}
	public int getTenure() {
		return tenure;
	}
	public void setTenure(int tenure) {
		this.tenure = tenure;
	}
	public double getInterest() {
		return interest;
	}
	public void setInterest(double interest) {
		this.interest = interest;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public LocalDate getAppdate() {
		return appdate;
	}
	public void setAppdate(LocalDate appdate) {
		this.appdate = appdate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public double getExShowPrice() {
		return exShowPrice;
	}
	public void setExShowPrice(double exShowPrice) {
		this.exShowPrice = exShowPrice;
	}
	public double getOnRoadPrice() {
		return onRoadPrice;
	}
	public void setOnRoadPrice(double onRoadPrice) {
		this.onRoadPrice = onRoadPrice;
	}
	public UserDetailsEntity getUser() {
		return user;
	}
	public void setUser(UserDetailsEntity user) {
		this.user = user;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
