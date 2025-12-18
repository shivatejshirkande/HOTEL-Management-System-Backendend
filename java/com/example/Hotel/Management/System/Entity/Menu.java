package com.example.Hotel.Management.System.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Menu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long item_id;
	private String item_name;
	private String item_category;
	private Double item_price;
	private Boolean item_availability;
	private String item_description;
	
	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Menu(String item_name, String item_category, Double item_price, Boolean item_availability,
			String item_description) {
		super();
		this.item_name = item_name;
		this.item_category = item_category;
		this.item_price = item_price;
		this.item_availability = item_availability;
		this.item_description = item_description;
	}

	public Long getItem_id() {
		return item_id;
	}

	public void setItem_id(Long item_id) {
		this.item_id = item_id;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public String getItem_category() {
		return item_category;
	}

	public void setItem_category(String item_category) {
		this.item_category = item_category;
	}

	public Double getItem_price() {
		return item_price;
	}

	public void setItem_price(Double item_price) {
		this.item_price = item_price;
	}

	public Boolean getItem_availability() {
		return item_availability;
	}

	public void setItem_availability(Boolean item_availability) {
		this.item_availability = item_availability;
	}

	public String getItem_description() {
		return item_description;
	}

	public void setItem_description(String item_description) {
		this.item_description = item_description;
	}

	@Override
	public String toString() {
		return "Menu [item_id=" + item_id + ", item_name=" + item_name + ", item_category=" + item_category
				+ ", item_price=" + item_price + ", item_availability=" + item_availability + ", item_description="
				+ item_description + "]";
	}
	
	
	
	

}
