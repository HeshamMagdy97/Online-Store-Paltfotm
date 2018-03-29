package com.SWII.Entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Store {
	@Id 
	private String storeId;

	
    @OneToMany(mappedBy = "products", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<StoreProductsEntity> products;

	private Integer numberOfView;

	
	
	
	
	
	
	
	public Store(String storeId, Set<StoreProductsEntity> products, Integer numberOfView) {
		super();
		this.storeId = storeId;
		this.products = products;
		this.numberOfView = numberOfView;
	}
	
	

	private Boolean status;
	private String name;




	public Store(String storeId, Boolean status, Set<StoreProductsEntity> products, String name, Integer numberOfView,
			StoreOwnerEntity storeOwner) {
		super();
		this.storeId = storeId;
		this.status = status;
		this.products = products;
		this.name = name;
		this.numberOfView = numberOfView;
		this.storeOwner = storeOwner;
	}

	

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public Set<StoreProductsEntity> getProducts() {
		return products;
	}

	public void setProducts(Set<StoreProductsEntity> products) {
		this.products = products;
	}

	public Integer getNumberOfView() {
		return numberOfView;
	}

	public void setNumberOfView(Integer numberOfView) {
		this.numberOfView = numberOfView;
	}


	
	
	
	public Store(String storeId) {
		super();
		this.storeId = storeId;
	}
	public Store() {
		super();
		this.storeId = "";
		status=false;
	}
	
	   @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "userName", nullable = false)
	   private StoreOwnerEntity storeOwner;

	public StoreOwnerEntity getStoreOwner() {
		return storeOwner;
	}

	public void setStoreOwner(StoreOwnerEntity storeOwner) {
		this.storeOwner = storeOwner;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	   

}
