package br.com.foursys.fourcamp.store.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.foursys.fourcamp.store.model.Costumer;
import br.com.foursys.fourcamp.store.model.Transaction;
import br.com.foursys.fourcamp.store.model.enums.TransactionStatus;
import br.com.foursys.fourcamp.store.repository.CostumerRepository;
import br.com.foursys.fourcamp.store.repository.TransactionRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private CostumerRepository costumerRepository;
	@Autowired
	private TransactionRepository transactionRepository;

	@Override
	public void run(String... args) throws Exception {
		Costumer c1 = new Costumer(null, "Maria Brown", "maria@gmail.com", "988888888", "123456"); 
		Costumer c2 = new Costumer(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
	
		Transaction o1 = new Transaction(null, Instant.parse("2019-06-20T19:53:07Z"), TransactionStatus.PAID, c1); 
		Transaction o2 = new Transaction(null, Instant.parse("2019-07-21T03:42:10Z"), TransactionStatus.WAITING_PAYMENT, c2); 
		Transaction o3 = new Transaction(null, Instant.parse("2019-07-22T15:21:22Z"), TransactionStatus.SHIPPED, c1);
		costumerRepository.saveAll(Arrays.asList(c1, c2));
		transactionRepository.saveAll(Arrays.asList(o1, o2, o3));
	}
	
	
	
	
}