package br.com.foursys.fourcamp.store.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.foursys.fourcamp.store.model.Costumer;
import br.com.foursys.fourcamp.store.model.Group;
import br.com.foursys.fourcamp.store.repository.GroupRepository;
import br.com.foursys.fourcamp.store.service.exceptions.ControllerNotFoundException;

@Service
public class GroupService {

	@Autowired
	private GroupRepository groupRepository;

	public List<Group> findAll() {
		return groupRepository.findAll();
	}

	public Group findById(Long id) {

		Optional<Group> obj = groupRepository.findById(id);
		return obj.get();
	}

	public Group save(Group group) {
		return groupRepository.save(group);
	}

	public void delete(Long id) {
		
		groupRepository.deleteById(id);

	}

	public Group update(Long id, Group obj) {
		Group entity = groupRepository.getOne(id);
		upData(entity, obj);
		return groupRepository.save(entity);
	}

	private void upData(Group entity, Group obj) {
		entity.setName(obj.getName());
	}
}
