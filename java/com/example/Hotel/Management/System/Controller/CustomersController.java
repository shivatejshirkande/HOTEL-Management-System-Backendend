package com.example.Hotel.Management.System.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Hotel.Management.System.Entity.Customers;
import com.example.Hotel.Management.System.Repository.CustomersRepo;


@CrossOrigin(origins = {"http://localhost:4200", "http://13.51.56.218", "http://localhost:8080"})
@RestController
@RequestMapping("ct")
public class CustomersController {
		
		@Autowired
		CustomersRepo ctRepo;
		
		@PostMapping("/add")
		public Customers createEmployee(@RequestBody Customers c)
		{
			c.setcId(null);
			return ctRepo.save(c);
		}
		
		@GetMapping("getall")
		public List<Customers> getAllEmployees()
		{
			return ctRepo.findAll();
		}
		
		@PutMapping("/update/{id}")
		public ResponseEntity<Customers> updateCustomers(@PathVariable long id, @RequestBody Customers c) throws AttributeNotFoundException
		{
			Customers c2 = ctRepo.findById(id).orElseThrow(()->new AttributeNotFoundException("customer is not found with id :" + id));
			c2.setcFullName(c.getcFullName());
			c2.setcEmail(c.getcEmail());
			c2.setcAddress(c.getcAddress());
			c2.setcPhoneNumber(c.getcPhoneNumber());
			c2.setcCustomerType(c.getcCustomerType());
			
			
			
			Customers updateCustomers = ctRepo.save(c2);
			return ResponseEntity.ok(updateCustomers);
			
		}
		
		@GetMapping("/get/{id}")
		public ResponseEntity<Customers> getCustomersById(@PathVariable long id) throws AttributeNotFoundException
		{
			Customers c = ctRepo.findById(id).orElseThrow(() ->new AttributeNotFoundException("customer is not found with id " + id));
			return ResponseEntity.ok(c);
		}
		
		@DeleteMapping("/delete/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteCustomers(@PathVariable long id) throws AttributeNotFoundException
		{
			Customers c = ctRepo.findById(id).orElseThrow(()->new AttributeNotFoundException("customer is not found with id " + id));
			ctRepo.delete(c);
			Map<String, Boolean> response = new HashMap<String, Boolean>();
			response.put("deleted data successfully", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}


	
}
