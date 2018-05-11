package com.SWII.Entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class UpdateRemoveHistory extends StoreProductsEntity {

	/**
	* 
	*/
	private static final long serialVersionUID = 4L;
	@ManyToOne
	CollaboratorsEntity collaborato;

	public UpdateRemoveHistory(int id, StoreEntity stores, ProductEntity products, Set<OrderProductEntity> boughBroduct,
			Set<AddProductHistory> addHistory, Integer numberOfViews, Double price, Integer quantaty,
			CollaboratorsEntity collaborato) {
		super(id, stores, products, boughBroduct, addHistory, numberOfViews, price, quantaty);
		this.collaborato = collaborato;
	}


	
	public UpdateRemoveHistory(int id, StoreEntity stores, ProductEntity products,Integer numberOfViews
			, Double price, Integer quantaty,CollaboratorsEntity collaborato) {
		super(id, stores, products, null, null, numberOfViews, price, quantaty);
		this.collaborato = collaborato;
	}



	public CollaboratorsEntity getCollaborato() {
		return collaborato;
	}

	public void setCollaborato(CollaboratorsEntity collaborato) {
		this.collaborato = collaborato;
	}
}
