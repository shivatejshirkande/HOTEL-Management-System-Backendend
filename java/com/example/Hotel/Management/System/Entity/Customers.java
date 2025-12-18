package com.example.Hotel.Management.System.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cId;
	private String cFullName;
	private String cPhoneNumber;
	private String cEmail;
	private String cAddress;
	private String cCustomerType;
	
	public Customers() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customers(String cFullName, String cPhoneNumber, String cEmail, String cAddress, String cCustomerType) {
		super();
		this.cFullName = cFullName;
		this.cPhoneNumber = cPhoneNumber;
		this.cEmail = cEmail;
		this.cAddress = cAddress;
		this.cCustomerType = cCustomerType;
	}

	public Long getcId() {
		return cId;
	}

	public void setcId(Long cId) {
		this.cId = cId;
	}

	public String getcFullName() {
		return cFullName;
	}

	public void setcFullName(String cFullName) {
		this.cFullName = cFullName;
	}

	public String getcPhoneNumber() {
		return cPhoneNumber;
	}

	public void setcPhoneNumber(String cPhoneNumber) {
		this.cPhoneNumber = cPhoneNumber;
	}

	public String getcEmail() {
		return cEmail;
	}

	public void setcEmail(String cEmail) {
		this.cEmail = cEmail;
	}

	public String getcAddress() {
		return cAddress;
	}

	public void setcAddress(String cAddress) {
		this.cAddress = cAddress;
	}

	public String getcCustomerType() {
		return cCustomerType;
	}

	public void setcCustomerType(String cCustomerType) {
		this.cCustomerType = cCustomerType;
	}

	@Override
	public String toString() {
		return "Customers [cId=" + cId + ", cFullName=" + cFullName + ", cPhoneNumber=" + cPhoneNumber + ", cEmail="
				+ cEmail + ", cAddress=" + cAddress + ", cCustomerType=" + cCustomerType + "]";
	}
	
	

}
