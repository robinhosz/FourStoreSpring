package br.com.foursys.fourcamp.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.foursys.fourcamp.store.model.Costumer;
import br.com.foursys.fourcamp.store.service.CostumerService;

@RestController
@RequestMapping(value = "/costumers")
public class CostumerController {

	@Autowired
	private CostumerService costumerService;

	@GetMapping
	public ResponseEntity<List<Costumer>> findAll() {
		List<Costumer> list = costumerService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}") 
	public ResponseEntity<Costumer> findById(@PathVariable Long id) {
		Costumer obj = costumerService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
