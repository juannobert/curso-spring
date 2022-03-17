package com.cursojava.curso.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursojava.curso.entities.Product;
import com.cursojava.curso.services.ProductServices;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {
	
	@Autowired
	ProductServices services;
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		List<Product> list = services.findAll();
		return ResponseEntity.ok(list); // Retorna uma lista de usuarios
	}
	@GetMapping(value = "/{id}") // Url vai receber um id qualquer
	public ResponseEntity<Product> findById(@PathVariable Long id){ // O id da url vai ser passada como parâmetro
		Product product = services.findById(id);
		return ResponseEntity.ok(product);
		
	}


}
