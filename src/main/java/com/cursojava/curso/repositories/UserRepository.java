package com.cursojava.curso.repositories;

import com.cursojava.curso.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository vai implementar a interface
// camada de acesso a dados
// Comunica o banco de dados
public interface UserRepository extends JpaRepository<User,Long> {
	
}
