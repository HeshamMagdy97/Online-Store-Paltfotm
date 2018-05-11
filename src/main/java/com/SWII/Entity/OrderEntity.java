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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class OrderEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderID;

	private Date deliveryDate;
	private Date orderDate;
	
	private boolean checkout;
	
	private double totalPrice;


	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<OrderProductEntity> products;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id", nullable = false)
	private UserEntity user;

	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<OrderEntity> order;


	public OrderEntity(int orderID, Date deliveryDate, Date orderDate, boolean checkout, double totalPrice,
			Set<OrderProductEntity> products, UserEntity user, Set<OrderEntity> order) {
		super();
		this.orderID = orderID;
		this.deliveryDate = deliveryDate;
		this.orderDate = orderDate;
		this.checkout = checkout;
		this.totalPrice = totalPrice;
		this.products = products;
		this.user = user;
		this.order = order;
	}

	public OrderEntity() {
		super();
		this.deliveryDate = null;
		this.orderDate = null;
		this.products = null;
		this.user = null;
		this.checkout = false;
	}

	public boolean isCheckout() {
		return checkout;
	}

	public void setCheckout(boolean checkout) {
		this.checkout = checkout;
	}

	public Set<OrderEntity> getOrder() {
		return order;
	}

	public void setOrder(Set<OrderEntity> order) {
		this.order = order;
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

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	

}
