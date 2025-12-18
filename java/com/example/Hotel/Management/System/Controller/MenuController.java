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
import com.example.Hotel.Management.System.Entity.Menu;
import com.example.Hotel.Management.System.Repository.MenuRepo;

@CrossOrigin(origins = {"http://localhost:4200", "http://13.51.56.218", "http://localhost:8080"})
@RestController
@RequestMapping("menu")
public class MenuController {
		
		@Autowired
		MenuRepo menuRepo;
		
		@PostMapping("/add")
		public Menu createMenu(@RequestBody Menu m)
		{
			return menuRepo.save(m);
		}
		
		@GetMapping("getall")
		public List<Menu> getAllEmployees()
		{
			return menuRepo.findAll();
		}
		
		@PutMapping("/update/{id}")
		public ResponseEntity<Menu> updateCustomers(@PathVariable long id, @RequestBody Menu m) throws AttributeNotFoundException
		{
			Menu m2 = menuRepo.findById(id).orElseThrow(()->new AttributeNotFoundException("menu is not found with id :" + id));
			m2.setItem_name(m.getItem_name());
			m2.setItem_price(m.getItem_price());
			m2.setItem_category(m.getItem_category());
			m2.setItem_availability(m.getItem_availability());
			
			
			Menu updateMenu = menuRepo.save(m2);
			return ResponseEntity.ok(updateMenu);
			
		}
		
		@GetMapping("/get/{id}")
		public ResponseEntity<Menu> getMenuById(@PathVariable long id) throws AttributeNotFoundException
		{
			Menu c = menuRepo.findById(id).orElseThrow(() ->new AttributeNotFoundException("menu is not found with id " + id));
			return ResponseEntity.ok(c);
		}
		
		@DeleteMapping("/delete/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteCustomers(@PathVariable long id) throws AttributeNotFoundException
		{
			Menu m = menuRepo.findById(id).orElseThrow(()->new AttributeNotFoundException("menu not found with id " + id));
			menuRepo.delete(m);
			Map<String, Boolean> response = new HashMap<String, Boolean>();
			response.put("deleted data successfully", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}


	
}

