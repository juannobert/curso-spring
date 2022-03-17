package com.cursojava.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursojava.curso.entities.Category;

// JpaRepository vai implementar a interface
// camada de acesso a dados
// Comunica o banco de dados
public interface CategoryRepository extends JpaRepository<Category,Long> {
	
}
