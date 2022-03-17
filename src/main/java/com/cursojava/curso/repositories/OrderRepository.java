package com.cursojava.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursojava.curso.entities.Order;

// JpaRepository vai implementar a interface
// camada de acesso a dados
// Comunica o banco de dados
public interface OrderRepository extends JpaRepository<Order,Long> {
	
	
}
