package com.SWII.Entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class StoreEntity {

	private enum Type {
		online, offline;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int storeId;

	@OneToMany(mappedBy = "products", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<StoreProductsEntity> products;

	@ManyToOne
	private StoreOwnerEntity storeOwner;
	
	@OneToMany(mappedBy = "stores", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<StoreCollaboratorsEntity> stores;
	
	private Type type;
	private Boolean status;
	private String name;
	private Integer numberOfView;
	
	

	public StoreEntity(int storeId, Set<StoreProductsEntity> products, StoreOwnerEntity storeOwner,
			Set<StoreCollaboratorsEntity> collaborators, Type type, Boolean status, String name, Integer numberOfView) {
		super();
		this.storeId = storeId;
		this.products = products;
		this.storeOwner = storeOwner;
		this.stores = collaborators;
		this.type = type;
		this.status = status;
		this.name = name;
		this.numberOfView = numberOfView;
	}

	public StoreEntity(int storeId) {
		super();
		this.storeId = storeId;
	}

	public StoreEntity() {
		super();
		status = false;
	}
	

	public Set<StoreCollaboratorsEntity> getCollaborators() {
		return stores;
	}

	public void setCollaborators(Set<StoreCollaboratorsEntity> collaborators) {
		this.stores = collaborators;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
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

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public void setType(String type) {
		this.type = Type.valueOf(type);
	}

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
