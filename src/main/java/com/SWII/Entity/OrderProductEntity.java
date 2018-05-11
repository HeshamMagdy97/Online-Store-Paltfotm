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
	private StoreProductsEntity boughBroduct;
 
	@ManyToOne
	@JoinColumn(name = "order_id")
	private OrderEntity order;
	
	private int quantaty;

	

	public OrderProductEntity(int id, BoughtProductsEntity boughBroduct, OrderEntity order, int quantaty) {
		super();
		this.id = id;
		this.boughBroduct = boughBroduct;
		this.order = order;
		this.quantaty = quantaty;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public StoreProductsEntity getBoughBroduct() {
		return boughBroduct;
	}

	public void setBoughBroduct(BoughtProductsEntity boughBroduct) {
		this.boughBroduct = boughBroduct;
	}

	public OrderEntity getOrder() {
		return order;
	}

	public void setOrder(OrderEntity order) {
		this.order = order;
	}

	public int getQuantaty() {
		return quantaty;
	}

	public void setQuantaty(int quantaty) {
		this.quantaty = quantaty;
	}
	
	
}
