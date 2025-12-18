package com.example.Hotel.Management.System.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Hotel.Management.System.Entity.Customers;

public interface CustomersRepo extends JpaRepository<Customers, Long>{

}
