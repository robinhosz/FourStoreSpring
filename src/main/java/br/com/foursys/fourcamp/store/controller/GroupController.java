package br.com.foursys.fourcamp.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.foursys.fourcamp.store.model.Group;
import br.com.foursys.fourcamp.store.service.GroupService;

@RestController
@RequestMapping(value = "/groups")
public class GroupController {

	@Autowired
	private GroupService costumerService;

	@GetMapping
	public ResponseEntity<List<Group>> findAll() {
		List<Group> list = costumerService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}") 
	public ResponseEntity<Group> findById(@PathVariable Long id) {
		Group obj = costumerService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
