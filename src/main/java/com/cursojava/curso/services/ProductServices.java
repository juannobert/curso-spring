package com.cursojava.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursojava.curso.entities.Product;
import com.cursojava.curso.repositories.ProductRepository;


@Service // Registra o componente no Spring como serviço
public class ProductServices {
	
	@Autowired
	ProductRepository productRepository;
	
	public List<Product> findAll(){
		return productRepository.findAll();
	}
	
	public Product findById(Long id) {
		/*
		 * O Optional nos ajuda a evitar os erros NullPointerException, tirar a necessidade da verificação 
		 * (if x != null) e também a escrever um código com menos linhas e mais bonito.
		 */
		Optional<Product> obj =  productRepository.findById(id);
		return obj.get();
	}
}
