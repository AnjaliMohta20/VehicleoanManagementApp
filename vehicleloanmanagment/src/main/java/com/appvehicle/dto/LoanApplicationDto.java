package com.appvehicle.dto;

import java.time.LocalDate;

import com.appvehicle.model.UserDetailsEntity;

public class LoanApplicationDto {
	
		public LoanApplicationDto() {
			super();
			// TODO Auto-generated constructor stub
		}
		private static final long serialVersionUID = 1L;
	    
		private String chassisNo;
	   
		private double existingEMI;
	    
		private int tenure;
	   
		private double interest;
	    
		private double amount;
	   
		private LocalDate appdate;
	   
		private String status="PENDING";
	   
		private String brand;
	    
		private String colour;
	   
		private String model;
	   
		private int type;
	   
		private double exShowPrice;
	   
		private double onRoadPrice;
		
		private UserDetailsEntity user;
		
		public LoanApplicationDto(String chassisNo, double existingEMI, int tenure, double interest, double amount,
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

