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

import com.example.Hotel.Management.System.Entity.Orders;
import com.example.Hotel.Management.System.Repository.OrdersRepo;

@CrossOrigin(origins = {"http://localhost:4200", "http://13.51.56.218", "http://localhost:8080"})
@RestController
@RequestMapping("order")
public class OrdersController {
		
		@Autowired
		OrdersRepo orderRepo;
		
		@PostMapping("/add")
		public Orders createOrders(@RequestBody Orders o)
		{
			return orderRepo.save(o);
		}
		
		@GetMapping("getall")
		public List<Orders> getAllEmployees()
		{
			return orderRepo.findAll();
		}
		
		@PutMapping("/update/{id}")
		public ResponseEntity<Orders> updateOrders(@PathVariable long id, @RequestBody Orders o) throws AttributeNotFoundException
		{
			Orders o2 = orderRepo.findById(id).orElseThrow(()->new AttributeNotFoundException("order is not found with id :" + id));
			o2.setOrder_date(o.getOrder_date());
			o2.setOrder_type(o.getOrder_type());
			o2.setOrder_paymentStatus(o.getOrder_paymentStatus());
			o2.setOrder_totalAmount(o.getOrder_totalAmount());
			
			
			Orders updateOrders = orderRepo.save(o2);
			return ResponseEntity.ok(updateOrders);
			
		}
		
		@GetMapping("/get/{id}")
		public ResponseEntity<Orders> getOrdersById(@PathVariable long id) throws AttributeNotFoundException
		{
			Orders o = orderRepo.findById(id).orElseThrow(() ->new AttributeNotFoundException("order is not found with id " + id));
			return ResponseEntity.ok(o);
		}
		
		@DeleteMapping("/delete/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteOrders(@PathVariable long id) throws AttributeNotFoundException
		{
			Orders o = orderRepo.findById(id).orElseThrow(()->new AttributeNotFoundException("order is not found with id " + id));
			orderRepo.delete(o);
			Map<String, Boolean> response = new HashMap<String, Boolean>();
			response.put("deleted data successfully", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}


	
}

