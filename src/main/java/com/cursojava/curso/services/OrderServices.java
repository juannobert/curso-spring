package com.cursojava.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursojava.curso.entities.Order;
import com.cursojava.curso.repositories.OrderRepository;


@Service // Registra o componente no Spring como serviço
public class OrderServices {
	
	@Autowired
	OrderRepository userRepository;
	
	public List<Order> findAll(){
		return userRepository.findAll();
	}
	
	public Order findById(Long id) {
		/*
		 * O Optional nos ajuda a evitar os erros NullPointerException, tirar a necessidade da verificação 
		 * (if x != null) e também a escrever um código com menos linhas e mais bonito.
		 */
		Optional<Order> obj =  userRepository.findById(id);
		return obj.get();
	}
}
