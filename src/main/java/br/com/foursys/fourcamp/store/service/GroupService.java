package br.com.foursys.fourcamp.store.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.foursys.fourcamp.store.model.Group;
import br.com.foursys.fourcamp.store.repository.GroupRepository;

@Service
public class GroupService {

	@Autowired
	private GroupRepository costumerRepository;

	public List<Group> findAll() {
		return costumerRepository.findAll();
	}

	public Group findById(Long id) {

		Optional<Group> obj = costumerRepository.findById(id);
		return obj.get();
	}
}
