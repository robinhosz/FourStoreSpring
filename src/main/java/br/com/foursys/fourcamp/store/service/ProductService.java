package br.com.foursys.fourcamp.store.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.foursys.fourcamp.store.model.Costumer;
import br.com.foursys.fourcamp.store.model.Product;
import br.com.foursys.fourcamp.store.repository.ProductRepository;
import br.com.foursys.fourcamp.store.service.exceptions.ControllerNotFoundException;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public List<Product> findAll() {
		return productRepository.findAll();
	}

	public Product findById(Long id) {

		Optional<Product> obj = productRepository.findById(id);
		return obj.get();
	}

	public Product save(Product product) {
		return productRepository.save(product);
	}

	public void delete(Long id) {
		try {
			productRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ControllerNotFoundException(id);
		}
	}

	public Product update(Long id, Product obj) {
		Product entity = productRepository.getOne(id);
		upData(entity, obj);
		return productRepository.save(entity);
	}

	private void upData(Product entity, Product obj) {
		entity.setName(obj.getName());
		entity.setDescription(obj.getDescription());

	}
}
