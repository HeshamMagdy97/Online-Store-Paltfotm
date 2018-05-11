package com.SWII.Entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class BoughtProductsEntity extends StoreProductsEntity implements Serializable {

	private static final long serialVersionUID = 2L;

	private int quantaty;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private UserEntity customers;

	public BoughtProductsEntity(int id, StoreEntity stores, ProductEntity products, Integer numberOfViews, Double price,
			Integer quantaty, int id2, UserEntity customers, Set<OrderProductEntity> boughBroducts, int quantaty2,
			Date deliveryDate, Date orderDate) {
		super();
		id = id2;
		this.customers = customers;
		quantaty = quantaty2;
	}

	public BoughtProductsEntity() {
		super();
		this.customers = null;
		this.quantaty = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UserEntity getCustomers() {
		return customers;
	}

	public void setCustomers(UserEntity customers) {
		this.customers = customers;
	}

	public Integer getQuantaty() {
		return quantaty;
	}

	public void setQuantaty(int quantaty) {
		this.quantaty = quantaty;
	}
}