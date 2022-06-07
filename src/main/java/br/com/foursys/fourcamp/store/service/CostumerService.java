package br.com.foursys.fourcamp.store.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.foursys.fourcamp.store.model.Costumer;
import br.com.foursys.fourcamp.store.repository.CostumerRepository;
import br.com.foursys.fourcamp.store.service.exceptions.ControllerNotFoundException;

@Service
public class CostumerService {

	@Autowired
	private CostumerRepository costumerRepository;

	public List<Costumer> findAll() {
		return costumerRepository.findAll();
	}

	public Costumer findById(Long id) {

		Optional<Costumer> obj = costumerRepository.findById(id);
		return obj.orElseThrow(() -> new ControllerNotFoundException(id));
	}
	
	public List<Costumer> findByName(String name) {
		return costumerRepository.findByNameContaining(name);
	}
	
	public Costumer save(Costumer costumer) {
		return costumerRepository.save(costumer);
	}
	
	
	public void delete(Long id ) {
		try {
		costumerRepository.deleteById(id);
		} catch(EmptyResultDataAccessException e) {
			throw new ControllerNotFoundException(id);
		}
	}
	
	public Costumer update(Long id, Costumer obj) {
		Costumer entity = costumerRepository.getOne(id);
		upData(entity, obj);
		return costumerRepository.save(entity);
	}

	private void upData(Costumer entity, Costumer obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		
	}
}
