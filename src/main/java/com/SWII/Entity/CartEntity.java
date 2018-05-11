package com.SWII.Entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class CartEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id", nullable = false)
	private CustomerEntity user;
	
	
	@ManyToOne
	private OrderEntity order;
	
	double totalPrice;
	
	

	public CartEntity(int id, OrderEntity order, double totalPrice) {
		this.id = id;
		this.order = order;
		this.totalPrice = totalPrice;
	}
	
	public CartEntity() {
		this.order = null;
		this.totalPrice = 0.0;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public OrderEntity getOrder() {
		return order;
	}

	public void setOrder(OrderEntity order) {
		this.order = order;
	}

}
