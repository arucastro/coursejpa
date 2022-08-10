package com.sandro.coursejpa.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.sandro.coursejpa.entities.Client;
import com.sandro.coursejpa.repositories.ClientRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private ClientRepository clientRepository;

	@Override
	public void run(String... args) throws Exception {

		Client c1 = new Client(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		Client c2 = new Client(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

		clientRepository.saveAll(Arrays.asList(c1, c2));

	}
}
