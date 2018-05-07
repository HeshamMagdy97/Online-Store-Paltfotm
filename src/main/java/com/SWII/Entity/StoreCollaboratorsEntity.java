package com.SWII.Entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class StoreCollaboratorsEntity implements Serializable{

	private static final long serialVersionUID = 3L;
 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "store_id")
	private StoreEntity stores;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private CollaboratorsEntity collaborators;
	
	

	public StoreCollaboratorsEntity(int id, StoreEntity store, CollaboratorsEntity collaborator) {
		super();
		this.id = id;
		this.stores = store;
		this.collaborators = collaborator;
	}
	
	public StoreCollaboratorsEntity() {
		super();
		this.stores = null;
		this.collaborators = null;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public StoreEntity getStore() {
		return stores;
	}

	public void setStore(StoreEntity store) {
		this.stores = store;
	}

	public CollaboratorsEntity getCollaborator() {
		return collaborators;
	}

	public void setCollaborator(CollaboratorsEntity collaborator) {
		this.collaborators = collaborator;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
