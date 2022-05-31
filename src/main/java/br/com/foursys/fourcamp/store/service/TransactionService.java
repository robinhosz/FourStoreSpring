package br.com.foursys.fourcamp.store.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.foursys.fourcamp.store.model.Transaction;
import br.com.foursys.fourcamp.store.repository.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepository costumerRepository;

	public List<Transaction> findAll() {
		return costumerRepository.findAll();
	}

	public Transaction findById(Long id) {

		Optional<Transaction> obj = costumerRepository.findById(id);
		return obj.get();
	}
}
