package br.com.foursys.fourcamp.store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.foursys.fourcamp.store.model.Costumer;

public interface CostumerRepository extends JpaRepository<Costumer, Long>{

	List<Costumer> findByNameContaining(String name);
	
}
