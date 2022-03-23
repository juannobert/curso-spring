package com.cursojava.curso.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj){ // Irá receber um objeto
		obj = services.save(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri(); // Criando URI
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		services.delete(id);
		return ResponseEntity.noContent().build(); // Não irá retornar nada
		
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<User> update(@PathVariable Long id,@RequestBody User obj){
		User user = services.update(id,obj);
		return ResponseEntity.ok(user);
	}


}
