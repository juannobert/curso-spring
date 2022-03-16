package com.cursojava.curso.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.cursojava.curso.entities.Order;
import com.cursojava.curso.entities.User;
import com.cursojava.curso.repositories.OrderRepository;
import com.cursojava.curso.repositories.UserRepository;

// Configurando perfil de teste
@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner{

	// Cria dependência
	@Autowired
	private UserRepository userReositoty;
	
	@Autowired
	private OrderRepository orderReositoty;
	@Override
	public void run(String... args) throws Exception { // Executa quando o programa for iniciado
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1);
		// Salva no banco de dados
		userReositoty.saveAll(Arrays.asList(u1,u2));
		orderReositoty.saveAll(Arrays.asList(o1,o2,o3));
		
	}
}
