package com.SWII.Entity;

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



		public UpdateRemoveHistory(int id, StoreEntity stores, ProductEntity products, Integer numberOfViews,
				Double price, Integer quantaty, CollaboratorsEntity collaborato) {
			super(id, stores, products, numberOfViews, price, quantaty);
			this.collaborato = collaborato; 
		}
	
		public UpdateRemoveHistory(int productId) {
			super();
			// TODO Auto-generated constructor stub
		}

		public CollaboratorsEntity getCollaborato() {
			return collaborato;
		}

		public void setCollaborato(CollaboratorsEntity collaborato) {
			this.collaborato = collaborato;
		}		
}
