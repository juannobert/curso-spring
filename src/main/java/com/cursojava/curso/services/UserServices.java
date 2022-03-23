package com.cursojava.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.cursojava.curso.entities.User;
import com.cursojava.curso.repositories.UserRepository;
import com.cursojava.curso.services.exceptions.DatabaseException;
import com.cursojava.curso.services.exceptions.ResourceNotFoundException;


@Service // Registra o componente no Spring como serviço
public class UserServices {
	
	@Autowired
	UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User findById(Long id) {
		/*
		 * O Optional nos ajuda a evitar os erros NullPointerException, tirar a necessidade da verificação 
		 * (if x != null) e também a escrever um código com menos linhas e mais bonito.
		 */
		Optional<User> obj =  userRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User save(User obj) {
		return userRepository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			userRepository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
		
	}
	
	public User update(Long id,User obj) {
		User entity = userRepository.getById(id);
		updateData(entity,obj);
		return userRepository.save(entity);
		
	}

	private void updateData(User entity, User obj) {
		entity.setNome(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		
	}
	
	
}
