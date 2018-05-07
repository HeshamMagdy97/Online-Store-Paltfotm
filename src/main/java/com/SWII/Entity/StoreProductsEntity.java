package com.SWII.Entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class StoreProductsEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;

	@ManyToOne
	@JoinColumn(name = "store_id")
	private StoreEntity stores;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private ProductEntity products;

	@OneToMany(mappedBy = "boughBroduct", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<OrderProductEntity> boughBroduct;

	@OneToMany(mappedBy = "products", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<AddProductHistory> addHistory;

	private Integer numberOfViews;
	private Double price;
	private Integer quantaty;



	public StoreProductsEntity(int id, StoreEntity stores, ProductEntity products, Set<OrderProductEntity> boughBroduct,
			Set<AddProductHistory> addHistory, Integer numberOfViews, Double price, Integer quantaty) {
		super();
		this.id = id;
		this.stores = stores;
		this.products = products;
		this.boughBroduct = boughBroduct;
		this.addHistory = addHistory;
		this.numberOfViews = numberOfViews;
		this.price = price;
		this.quantaty = quantaty;
	}

	public StoreProductsEntity() {
		super();
		this.numberOfViews = 0;
		this.price = 0.0;
		this.quantaty = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantaty() {
		return quantaty;
	}

	public void setQuantaty(Integer quantaty) {
		this.quantaty = quantaty;
	}

	public StoreEntity getStores() {
		return stores;
	}

	public void setStores(StoreEntity stores) {
		this.stores = stores;
	}

	public ProductEntity getProducts() {
		return products;
	}

	public void setProducts(ProductEntity products) {
		this.products = products;
	}

	public Integer getNumberOfViews() {
		return numberOfViews;
	}

	public void setNumberOfViews(Integer numberOfViews) {
		this.numberOfViews = numberOfViews;
	}

	public Set<OrderProductEntity> getBoughBroduct() {
		return boughBroduct;
	}

	public void setBoughBroduct(Set<OrderProductEntity> boughBroduct) {
		this.boughBroduct = boughBroduct;
	}

	public Set<AddProductHistory> getAddHistory() {
		return addHistory;
	}

	public void setAddHistory(Set<AddProductHistory> addHistory) {
		this.addHistory = addHistory;
	}

}
