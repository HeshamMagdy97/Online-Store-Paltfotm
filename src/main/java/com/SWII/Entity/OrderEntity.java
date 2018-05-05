package com.SWII.Entity;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class OrderEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderID;

	private Date deliveryDate;
	private Date orderDate;

	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<OrderProductEntity> products;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id", nullable = false)
	private CustomerEntity user;

	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<OrderEntity> order;
	

	
	public OrderEntity(int orderID, Date deliveryDate, Date orderDate, Set<OrderProductEntity> products,
			CustomerEntity user) {
		super();
		this.orderID = orderID;
		this.deliveryDate = deliveryDate;
		this.orderDate = orderDate;
		this.products = products;
		this.user = user;
	}

	public OrderEntity() {
		super();
		this.deliveryDate = null;
		this.orderDate = null;
		this.products = null;
		this.user = null;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Set<OrderProductEntity> getProducts() {
		return products;
	}

	public void setProducts(Set<OrderProductEntity> products) {
		this.products = products;
	}

	public CustomerEntity getUser() {
		return user;
	}

	public void setUser(CustomerEntity user) {
		this.user = user;
	}

}
