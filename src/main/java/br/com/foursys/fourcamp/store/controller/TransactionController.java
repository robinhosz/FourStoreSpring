package br.com.foursys.fourcamp.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.foursys.fourcamp.store.model.Transaction;
import br.com.foursys.fourcamp.store.service.TransactionService;

@RestController
@RequestMapping(value = "/transactions")
public class TransactionController {

	@Autowired
	private TransactionService costumerService;

	@GetMapping
	public ResponseEntity<List<Transaction>> findAll() {
		List<Transaction> list = costumerService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}") 
	public ResponseEntity<Transaction> findById(@PathVariable Long id) {
		Transaction obj = costumerService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
