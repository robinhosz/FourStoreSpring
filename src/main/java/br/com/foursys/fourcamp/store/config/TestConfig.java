package br.com.foursys.fourcamp.store.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.foursys.fourcamp.store.model.Costumer;
import br.com.foursys.fourcamp.store.repository.CostumerRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private CostumerRepository costumerRepository;

	@Override
	public void run(String... args) throws Exception {
		Costumer c1 = new Costumer(null, "Maria Brown", "maria@gmail.com", "988888888", "123456"); 
		Costumer c2 = new Costumer(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
	
		costumerRepository.saveAll(Arrays.asList(c1, c2));
	}
	
	
	
	
}