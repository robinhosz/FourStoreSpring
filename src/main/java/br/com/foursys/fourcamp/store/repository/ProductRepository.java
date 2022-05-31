package br.com.foursys.fourcamp.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.foursys.fourcamp.store.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
