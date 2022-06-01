package br.com.foursys.fourcamp.store.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.foursys.fourcamp.store.model.cart.TransactionCartPK;

@Entity
@Table(name = "tb_transaction_cart")
public class TransactionCart implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TransactionCartPK id = new TransactionCartPK();

	private Integer quantity;
	private Double price;

	public TransactionCart() {

	}

	public TransactionCart(Transaction trasaction, Product product, Integer quantity, Double price) {
		super();
		id.setTransaction(trasaction);
		id.setProduct(product);
		this.quantity = quantity;
		this.price = price;
	}

	@JsonIgnore
	public Transaction getTransaction() {
		return id.getTransaction();
	}
	
	public void setTransaction(Transaction transaction) {
		id.setTransaction(transaction);
	}
	
	public Product getProduct() {
		return id.getProduct();
	}
	
	public void setProduct(Product product) {
		id.setProduct(product);
	}
	
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
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
		TransactionCart other = (TransactionCart) obj;
		return Objects.equals(id, other.id);
	}

}
