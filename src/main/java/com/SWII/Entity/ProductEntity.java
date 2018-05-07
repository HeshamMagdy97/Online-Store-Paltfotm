package com.SWII.Entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class ProductEntity {

	public enum Type {online , offline}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int productId;

    @OneToMany(mappedBy = "stores", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<StoreProductsEntity> stores;

    @OneToMany(mappedBy = "products", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<AddProductHistory> addHistory;
    
    

	public ProductEntity(int productId, Set<StoreProductsEntity> stores, Set<AddProductHistory> addHistory, String name,
			Double lowPrice, Double highPrice, String brand, String category, Type type) {
		super();
		this.productId = productId;
		this.stores = stores;
		this.addHistory = addHistory;
		this.name = name;
		this.lowPrice = lowPrice;
		this.highPrice = highPrice;
		this.brand = brand;
		this.category = category;
		this.type = type;
	}

	public Set<AddProductHistory> getAddHistory() {
		return addHistory;
	}

	public void setAddHistory(Set<AddProductHistory> addHistory) {
		this.addHistory = addHistory;
	}
	String name;
	Double lowPrice;
	Double highPrice;
	String brand;
	String category;
	private Type type;

	public ProductEntity(int productId, Set<StoreProductsEntity> stores, String name, Double lowPrice, Double highPrice,
			String brand, String category, Type type) {
		super();
		this.productId = productId;
		this.stores = stores;
		this.name = name;
		this.lowPrice = lowPrice;
		this.highPrice = highPrice;
		this.brand = brand;
		this.category = category;
		this.type = type;
	}
	
	
	public ProductEntity() {
		super();
//		this.name = "";
//		this.lowPrice = 0.0;
//		this.highPrice = 0.0;
//		this.category = "";
	}
	
	public ProductEntity(int productId) {
		this.productId = productId;
	}

	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public void setType(String type) {
		this.type = Type.valueOf(type);
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public Set<StoreProductsEntity> getStores() {
		return stores;
	}
	public void setStores(Set<StoreProductsEntity> stores) {
		this.stores = stores;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getLowPrice() {
		return lowPrice;
	}
	public void setLowPrice(Double lowPrice) {
		this.lowPrice = lowPrice;
	}
	public Double getHighPrice() {
		return highPrice;
	}
	public void setHighPrice(Double highPrice) {
		this.highPrice = highPrice;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
}
