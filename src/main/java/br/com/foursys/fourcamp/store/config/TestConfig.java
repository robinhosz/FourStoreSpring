package br.com.foursys.fourcamp.store.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.foursys.fourcamp.store.model.Costumer;
import br.com.foursys.fourcamp.store.model.Group;
import br.com.foursys.fourcamp.store.model.Product;
import br.com.foursys.fourcamp.store.model.Transaction;
import br.com.foursys.fourcamp.store.model.enums.TransactionStatus;
import br.com.foursys.fourcamp.store.repository.CostumerRepository;
import br.com.foursys.fourcamp.store.repository.GroupRepository;
import br.com.foursys.fourcamp.store.repository.ProductRepository;
import br.com.foursys.fourcamp.store.repository.TransactionRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private CostumerRepository costumerRepository;
	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private GroupRepository groupRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public void run(String... args) throws Exception {
		Group gp1 = new Group(null, "Vestuário");
		Group gp2 = new Group(null, "Perfumaria");
		Group gp3 = new Group(null, "Calçado");
		
		Product p1 = new Product(null, "Camisa Polo", "Lorem ipsum dolor sit amet, consectetur.", 90.5, ""); 
		Product p2 = new Product(null, "Tenis top", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, ""); 
		Product p3 = new Product(null, "Perfume cheiroso", "Nam eleifend maximus tortor, at mollis.", 1250.0, ""); 
		Product p4 = new Product(null, "Perfume chocolate", "Donec aliquet odio ac rhoncus cursus.", 1200.0, ""); 
		Product p5 = new Product(null, "Camiseta Lacoste", "Cras fringilla convallis sem vel faucibus.", 100.99, ""); 
		
		groupRepository.saveAll(Arrays.asList(gp1,gp2,gp3));
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		p1.getGroups().add(gp1);
		p2.getGroups().add(gp3);
		p2.getGroups().add(gp1);
		p3.getGroups().add(gp3);
		p4.getGroups().add(gp3);
		p5.getGroups().add(gp2);
		
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		
		
		Costumer c1 = new Costumer(null, "Maria Brown", "maria@gmail.com", "988888888", "123456"); 
		Costumer c2 = new Costumer(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
	
		Transaction o1 = new Transaction(null, Instant.parse("2019-06-20T19:53:07Z"), TransactionStatus.PAID, c1); 
		Transaction o2 = new Transaction(null, Instant.parse("2019-07-21T03:42:10Z"), TransactionStatus.WAITING_PAYMENT, c2); 
		Transaction o3 = new Transaction(null, Instant.parse("2019-07-22T15:21:22Z"), TransactionStatus.SHIPPED, c1);
		
		
		costumerRepository.saveAll(Arrays.asList(c1, c2));
		transactionRepository.saveAll(Arrays.asList(o1, o2, o3));
		
	}
	
	
	
	
}