package com.sandro.coursejpa.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.sandro.coursejpa.entities.Category;
import com.sandro.coursejpa.entities.Client;
import com.sandro.coursejpa.entities.Order;
import com.sandro.coursejpa.entities.enums.OrderStatus;
import com.sandro.coursejpa.repositories.CategoryRepository;
import com.sandro.coursejpa.repositories.ClientRepository;
import com.sandro.coursejpa.repositories.OrderRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

		Client c1 = new Client(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		Client c2 = new Client(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

		clientRepository.saveAll(Arrays.asList(c1, c2));

		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, c1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, c2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, c1);

		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
		

	}
}
