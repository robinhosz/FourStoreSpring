package br.com.foursys.fourcamp.store.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.foursys.fourcamp.store.model.Product;
import br.com.foursys.fourcamp.store.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository costumerRepository;

	public List<Product> findAll() {
		return costumerRepository.findAll();
	}

	public Product findById(Long id) {

		Optional<Product> obj = costumerRepository.findById(id);
		return obj.get();
	}
}
