package com.cursojava.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursojava.curso.entities.User;
import com.cursojava.curso.repositories.UserRepository;


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
		return obj.get();
	}
}
