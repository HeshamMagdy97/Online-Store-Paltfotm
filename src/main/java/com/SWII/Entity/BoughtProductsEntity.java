package com.SWII.Entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class BoughtProductsEntity extends StoreProductsEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private CustomerEntity customers;
	
	private int quantaty;
	private Date deliveryDate;
	private Date orderDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public CustomerEntity getCustomers() {
		return customers;
	}
	public void setCustomers(CustomerEntity customers) {
		this.customers = customers;
	}
	public int getQuantaty() {
		return quantaty;
	}
	public void setQuantaty(int quantaty) {
		this.quantaty = quantaty;
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
	public BoughtProductsEntity(Store stores, Product products, Integer numberOfViews, int id, CustomerEntity customers,
			int quantaty, Date deliveryDate, Date orderDate) {
		super(stores, products, numberOfViews);
		this.id = id;
		this.customers = customers;
		this.quantaty = quantaty;
		this.deliveryDate = deliveryDate;
		this.orderDate = orderDate;
	}
	public BoughtProductsEntity() {
		super();
		this.id = 0;
		this.customers = null;
		this.quantaty = 0;
		this.deliveryDate = null;
		this.orderDate = null;
	}
	

}