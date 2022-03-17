package com.cursojava.curso.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursojava.curso.entities.Category;
import com.cursojava.curso.services.CategoryServices;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
	
	@Autowired
	CategoryServices services;
	
	@GetMapping
	public ResponseEntity<List<Category>> findAll(){
		List<Category> list = services.findAll();
		return ResponseEntity.ok(list); // Retorna uma lista de usuarios
	}
	@GetMapping(value = "/{id}") // Url vai receber um id qualquer
	public ResponseEntity<Category> findById(@PathVariable Long id){ // O id da url vai ser passada como parâmetro
		Category category = services.findById(id);
		return ResponseEntity.ok(category);
		
	}


}
