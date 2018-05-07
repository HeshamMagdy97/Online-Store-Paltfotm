package com.SWII.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class AddProductHistory {
	@ManyToOne
	ProductEntity products;

	@ManyToOne
	CollaboratorsEntity collaborato;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int addProductId;

	public AddProductHistory(ProductEntity products, CollaboratorsEntity collaborato, int addProductId) {
		super();
		this.products = products;
		this.collaborato = collaborato;
		this.addProductId = addProductId;
	}

	public ProductEntity getProducts() {
		return products;
	}

	public void setProducts(ProductEntity products) {
		this.products = products;
	}

	public CollaboratorsEntity getCollaborato() {
		return collaborato;
	}

	public void setCollaborato(CollaboratorsEntity collaborato) {
		this.collaborato = collaborato;
	}

	public int getAddProductId() {
		return addProductId;
	}

	public void setAddProductId(int addProductId) {
		this.addProductId = addProductId;
	}

}
