package br.com.foursys.fourcamp.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.foursys.fourcamp.store.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{

}
