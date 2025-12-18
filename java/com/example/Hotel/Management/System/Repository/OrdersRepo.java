package com.example.Hotel.Management.System.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Hotel.Management.System.Entity.Orders;

public interface OrdersRepo extends JpaRepository<Orders, Long>{
	
	

}
