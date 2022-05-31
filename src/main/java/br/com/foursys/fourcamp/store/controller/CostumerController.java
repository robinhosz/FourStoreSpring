package br.com.foursys.fourcamp.store.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.foursys.fourcamp.store.model.Costumer;

@RestController
@RequestMapping(value = "/costumers")
public class CostumerController {

	
	@GetMapping
	public ResponseEntity<Costumer> findAll() {
		Costumer costumer = new Costumer(1L, "Robson", "robsob@gmail.com", "999999", "12345");
	return ResponseEntity.ok().body(costumer);
	}

	
	
	
	
}
