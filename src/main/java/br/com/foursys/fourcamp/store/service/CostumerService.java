package br.com.foursys.fourcamp.store.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.foursys.fourcamp.store.model.Costumer;
import br.com.foursys.fourcamp.store.repository.CostumerRepository;

@Service
public class CostumerService {

	@Autowired
	private CostumerRepository costumerRepository;

	public List<Costumer> findAll() {
		return costumerRepository.findAll();
	}

	public Costumer findById(Long id) {

		Optional<Costumer> obj = costumerRepository.findById(id);
		return obj.get();
	}
}
