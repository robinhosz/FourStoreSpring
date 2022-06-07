package br.com.foursys.fourcamp.store.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.foursys.fourcamp.store.model.enums.BrandEnum;
import br.com.foursys.fourcamp.store.model.enums.ColorEnum;
import br.com.foursys.fourcamp.store.model.enums.SeasonEnum;
import br.com.foursys.fourcamp.store.model.enums.SizeEnum;
import br.com.foursys.fourcamp.store.model.enums.TypeOfMerchandiseEnum;

@Entity
@Table(name = "tb_product")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String sku;
	private String name;
	private String description;
	private String color;
	private String type;
	private String season;
	private String size;
	private String brand;
	private Double price;

	@ManyToMany
	@JoinTable(name = "tb_product_group", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "group_id"))
	private Set<Group> groups = new HashSet<>();

	@OneToMany(mappedBy = "id.product")
	private Set<TransactionCart> cart = new HashSet<>();

	public Product() {

	}

	public Product(Long id, String sku, String name, String description, Double price) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		parseSku(sku);
		this.sku = sku;
	}

	public void parseSku(String sku) {
		this.brand = BrandEnum.get(sku.substring(0, 3)).getDescription();
		this.size = SizeEnum.get(sku.substring(3, 5)).getDescription();
		this.season = SeasonEnum.get(sku.substring(5, 7)).getDescription();
		this.type = TypeOfMerchandiseEnum.get(sku.substring(7, 10)).getDescription();
		this.color = ColorEnum.get(sku.substring(10, 12)).getDescription();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSku() {
		return sku;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Set<Group> getGroups() {
		return groups;
	}

	@JsonIgnore
	public Set<Transaction> getTransactions() {
		Set<Transaction> set = new HashSet<>();
		for (TransactionCart tc : cart) {
			set.add(tc.getTransaction());
		}
		return set;
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
		Product other = (Product) obj;
		return Objects.equals(id, other.id);
	}

}
