package com.cursojava.curso.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.cursojava.curso.entities.Category;
import com.cursojava.curso.entities.Order;
import com.cursojava.curso.entities.Product;
import com.cursojava.curso.entities.User;
import com.cursojava.curso.entities.enums.OrderStatus;
import com.cursojava.curso.repositories.CategoryRepository;
import com.cursojava.curso.repositories.OrderRepository;
import com.cursojava.curso.repositories.ProductRepository;
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
	
	@Autowired
	private CategoryRepository categoryReositoty;
	
	@Autowired
	private ProductRepository productRositoty;
	
	@Override
	public void run(String... args) throws Exception { // Executa quando o programa for iniciado
		
		
		
		
		
		
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers"); 
		categoryReositoty.saveAll(Arrays.asList(cat1,cat2,cat3));
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		
		productRositoty.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1,OrderStatus.DELIVERY);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2,OrderStatus.PAID);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1,OrderStatus.DELIVERY);
		// Salva no banco de dados
		userReositoty.saveAll(Arrays.asList(u1,u2));
		orderReositoty.saveAll(Arrays.asList(o1,o2,o3));
		
	}
}
