package com.SWII.Entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class CollaboratorsEntity extends UserEntity{
	
	@OneToMany(mappedBy = "collaborators", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<StoreCollaboratorsEntity> collaborators;
	
	@OneToMany(mappedBy = "collaborato", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<AddProductHistory> addHistory;

	@OneToMany(mappedBy = "collaborato", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<UpdateRemoveHistory> updateRemoveHistories; 

	public Set<StoreCollaboratorsEntity> getCollaborators() {
		return collaborators;
	}

	
	public Set<UpdateRemoveHistory> getUpdateRemoveHistories() {
		return updateRemoveHistories;
	}


	public CollaboratorsEntity(String email, String password, String userName,
			Set<StoreCollaboratorsEntity> collaborators, Set<AddProductHistory> addHistory,
			Set<UpdateRemoveHistory> updateRemoveHistories) {
		super(email, password, userName);
		this.collaborators = collaborators;
		this.addHistory = addHistory;
		this.updateRemoveHistories = updateRemoveHistories;
	}


	public void setUpdateRemoveHistories(Set<UpdateRemoveHistory> updateRemoveHistories) {
		this.updateRemoveHistories = updateRemoveHistories;
	}


	public CollaboratorsEntity(String email, String password, String userName,
			Set<StoreCollaboratorsEntity> collaborators, Set<AddProductHistory> addHistory) {
		super(email, password, userName);
		this.collaborators = collaborators;
		this.addHistory = addHistory;
	}

	public void setCollaborators(Set<StoreCollaboratorsEntity> collaborators) {
		this.collaborators = collaborators;
	}

	public Set<AddProductHistory> getAddHistory() {
		return addHistory;
	}

	public void setAddHistory(Set<AddProductHistory> addHistory) {
		this.addHistory = addHistory;
	}

	public CollaboratorsEntity(String email, String password, String userName,
			Set<StoreCollaboratorsEntity> collaborators) {
		super(email, password, userName);
		this.collaborators = collaborators;
	}

	public Set<StoreCollaboratorsEntity> getStoreCollaborators() {
		return collaborators;
	}

	public void setStoreCollaborators(Set<StoreCollaboratorsEntity> storeCollaborators) {
		this.collaborators = storeCollaborators;
	}
	
	
}
