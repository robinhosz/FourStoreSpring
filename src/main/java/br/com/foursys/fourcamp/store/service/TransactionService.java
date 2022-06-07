package br.com.foursys.fourcamp.store.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.foursys.fourcamp.store.model.Product;
import br.com.foursys.fourcamp.store.model.Transaction;
import br.com.foursys.fourcamp.store.repository.TransactionRepository;
import br.com.foursys.fourcamp.store.service.exceptions.ControllerNotFoundException;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	public List<Transaction> findAll() {
		return transactionRepository.findAll();
	}

	public Transaction findById(Long id) {

		Optional<Transaction> obj = transactionRepository.findById(id);
		return obj.get();
	}
	
	public Transaction save(Transaction transaction) {
		return transactionRepository.save(transaction);
	}

	public void delete(Long id) {
		try {
			transactionRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ControllerNotFoundException(id);
		}
	}

	public Transaction update(Long id, Transaction obj) {
		Transaction entity = transactionRepository.getOne(id);
		upData(entity, obj);
		return transactionRepository.save(entity);
	}

	private void upData(Transaction entity, Transaction obj) {
		entity.setClient(obj.getClient());
		entity.setMoment(obj.getMoment());
		entity.setTransactionStatus(obj.getTransactionStatus());
		

	}
}
