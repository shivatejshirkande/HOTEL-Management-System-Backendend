package com.example.Hotel.Management.System.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long order_id;
	private String order_date;
	private Double order_totalAmount;
	private String order_paymentStatus;
	private String order_type;
	
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Orders(String order_date, Double order_totalAmount, String order_paymentStatus, String order_type) {
		super();
		this.order_date = order_date;
		this.order_totalAmount = order_totalAmount;
		this.order_paymentStatus = order_paymentStatus;
		this.order_type = order_type;
	}

	public Long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}

	public String getOrder_date() {
		return order_date;
	}

	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}

	public Double getOrder_totalAmount() {
		return order_totalAmount;
	}

	public void setOrder_totalAmount(Double order_totalAmount) {
		this.order_totalAmount = order_totalAmount;
	}

	public String getOrder_paymentStatus() {
		return order_paymentStatus;
	}

	public void setOrder_paymentStatus(String order_paymentStatus) {
		this.order_paymentStatus = order_paymentStatus;
	}

	public String getOrder_type() {
		return order_type;
	}

	public void setOrder_type(String order_type) {
		this.order_type = order_type;
	}

	@Override
	public String toString() {
		return "Orders [order_id=" + order_id + ", order_date=" + order_date + ", order_totalAmount="
				+ order_totalAmount + ", order_paymentStatus=" + order_paymentStatus + ", order_type=" + order_type
				+ "]";
	}
	
	

}
