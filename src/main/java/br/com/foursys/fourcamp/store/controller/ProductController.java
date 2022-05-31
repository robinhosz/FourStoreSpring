package br.com.foursys.fourcamp.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.foursys.fourcamp.store.model.Product;
import br.com.foursys.fourcamp.store.service.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

	@Autowired
	private ProductService costumerService;

	@GetMapping
	public ResponseEntity<List<Product>> findAll() {
		List<Product> list = costumerService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}") 
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		Product obj = costumerService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
