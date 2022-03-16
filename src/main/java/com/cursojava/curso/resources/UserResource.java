package com.cursojava.curso.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursojava.curso.entities.User;
import com.cursojava.curso.services.UserServices;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	UserServices services;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> list = services.findAll();
		return ResponseEntity.ok(list); // Retorna uma lista de usuarios
	}
	@GetMapping(value = "/{id}") // Url vai receber um id qualquer
	public ResponseEntity<User> findById(@PathVariable Long id){ // O id da url vai ser passada como parâmetro
		User user = services.findById(id);
		return ResponseEntity.ok(user);
		
	}


}
