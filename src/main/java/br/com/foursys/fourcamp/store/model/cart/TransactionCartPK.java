package br.com.foursys.fourcamp.store.model.cart;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.foursys.fourcamp.store.model.Product;
import br.com.foursys.fourcamp.store.model.Transaction;

@Embeddable
public class TransactionCartPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "transaction_id")
	private Transaction transaction;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public int hashCode() {
		return Objects.hash(product, transaction);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TransactionCartPK other = (TransactionCartPK) obj;
		return Objects.equals(product, other.product) && Objects.equals(transaction, other.transaction);
	}

}
