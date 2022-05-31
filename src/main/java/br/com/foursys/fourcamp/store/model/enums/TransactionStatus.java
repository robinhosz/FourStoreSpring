package br.com.foursys.fourcamp.store.model.enums;

public enum TransactionStatus {

	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);
	
	private int key;
	
	private TransactionStatus(int key) {
		this.key = key;
	}
	
	public int getKey() {
		return key;
	}
	
	public static TransactionStatus valueOf(int key) {
		for(TransactionStatus t : TransactionStatus.values()) {
			if (t.getKey() == key) {
				return t;
			}
		}
		throw new IllegalArgumentException("Invalid key");
	}
}
