package com.cursojava.curso.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursojava.curso.entities.Order;
import com.cursojava.curso.services.OrderServices;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {
	
	@Autowired
	OrderServices services;
	
	@GetMapping
	public ResponseEntity<List<Order>> findAll(){
		List<Order> list = services.findAll();
		return ResponseEntity.ok(list); // Retorna uma lista de usuarios
	}
	@GetMapping(value = "/{id}") // Url vai receber um id qualquer
	public ResponseEntity<Order> findById(@PathVariable Long id){ // O id da url vai ser passada como parâmetro
		Order user = services.findById(id);
		return ResponseEntity.ok(user);
		
	}


}
