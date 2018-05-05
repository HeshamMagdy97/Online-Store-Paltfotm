package com.SWII.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class OrderProductEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private BoughtProductsEntity boughBroduct;
 
	@ManyToOne
	@JoinColumn(name = "order_id")
	private CartEntity order;

	public OrderProductEntity(int id, BoughtProductsEntity boughBroduct, CartEntity order) {
		super();
		this.id = id;
		this.boughBroduct = boughBroduct;
		this.order = order;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BoughtProductsEntity getBoughBroduct() {
		return boughBroduct;
	}

	public void setBoughBroduct(BoughtProductsEntity boughBroduct) {
		this.boughBroduct = boughBroduct;
	}

	public CartEntity getOrder() {
		return order;
	}

	public void setOrder(CartEntity order) {
		this.order = order;
	}
	
}
