package com.cursojava.curso.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.cursojava.curso.entities.User;
import com.cursojava.curso.repositories.UserRepository;

// Configurando perfil de teste
@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner{

	// Cria dependência
	@Autowired
	private UserRepository userReositoty;

	@Override
	public void run(String... args) throws Exception { // Executa quando o programa for iniciado
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		// Salva no banco de dados
		userReositoty.saveAll(Arrays.asList(u1,u2));
	}
}
