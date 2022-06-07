package br.com.foursys.fourcamp.store.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

	@GetMapping("/name/{name}")
	public List<Costumer> getCostumerByName(@PathVariable String name) {
		return costumerService.findByName(name);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Costumer> findById(@PathVariable Long id) {
		Costumer obj = costumerService.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<Costumer> save(@RequestBody Costumer obj) {
		obj = costumerService.save(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		costumerService.delete(id);
		return ResponseEntity.noContent().build();

	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Costumer> update(@PathVariable Long id, @RequestBody Costumer obj) {
		obj = costumerService.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}

}
