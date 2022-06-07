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

import br.com.foursys.fourcamp.store.model.Group;
import br.com.foursys.fourcamp.store.service.GroupService;

@RestController
@RequestMapping(value = "/groups")
public class GroupController {

	@Autowired
	private GroupService groupService;

	@GetMapping
	public ResponseEntity<List<Group>> findAll() {
		List<Group> list = groupService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}") 
	public ResponseEntity<Group> findById(@PathVariable Long id) {
		Group obj = groupService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Group> save(@RequestBody Group obj) {
		obj = groupService.save(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		groupService.delete(id);
		return ResponseEntity.noContent().build();

	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Group> update(@PathVariable Long id, @RequestBody Group obj) {
		obj = groupService.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
