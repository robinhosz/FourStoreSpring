package br.com.foursys.fourcamp.store.model;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.foursys.fourcamp.store.model.enums.TransactionStatus;

@Entity
@Table(name = "tb_transaction")
public class Transaction implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'z'", timezone = "GMT")
	private Instant moment;

	private Integer transactionStatus;

	@ManyToOne
	@JoinColumn(name = "costumer_id")
	private Costumer client;
	
	@OneToMany(mappedBy = "id.transaction")
	private Set<TransactionCart> cart = new HashSet<>();

	public Transaction() {

	}

	public Transaction(Long id, Instant moment, TransactionStatus transactionStatus, Costumer client) {
		super();
		this.id = id;
		this.moment = moment;
		setTransactionStatus(transactionStatus);
		this.client = client;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public TransactionStatus getTransactionStatus() {
		return TransactionStatus.valueOf(transactionStatus);
	}

	public void setTransactionStatus(TransactionStatus transactionStatus) {
		if (transactionStatus != null) {
			this.transactionStatus = transactionStatus.getKey();
		}

	}

	public Costumer getClient() {
		return client;
	}

	public void setClient(Costumer client) {
		this.client = client;
	}

	public Set<TransactionCart> getCart() {
		return cart;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		return Objects.equals(id, other.id);
	}

}
