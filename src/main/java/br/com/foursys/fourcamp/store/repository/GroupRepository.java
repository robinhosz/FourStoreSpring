package br.com.foursys.fourcamp.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.foursys.fourcamp.store.model.Group;

public interface GroupRepository extends JpaRepository<Group, Long>{

}
