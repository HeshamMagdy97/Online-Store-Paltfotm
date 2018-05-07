package com.SWII.Entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class StoreOwnerEntity extends UserEntity{
	
	private String fristName;
	private String secoundName;
	private String address;
	private String phoneNumber;

	@OneToMany(cascade = CascadeType.ALL,mappedBy = "storeOwner")
	 private Set<StoreEntity> storeEntities = new HashSet<>();


	public StoreOwnerEntity(String email, String password, String userName, String fristName, String secoundName,
			String address, String phoneNumber, Set<StoreEntity> storeEntities) {
		super(email, password, userName);
		this.fristName = fristName;
		this.secoundName = secoundName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.storeEntities = storeEntities;
	}


	public StoreOwnerEntity() {
		super();
	}
	
	public Set<StoreEntity> getStoreEntities() {
		return storeEntities;
	}


	public void setStoreEntities(Set<StoreEntity> storeEntities) {
		this.storeEntities = storeEntities;
	}


	public StoreOwnerEntity(String email, String password, String userName) {
		super(email, password, userName);
	}


	public String getFristName() {
		return fristName;
	}


	public void setFristName(String fristName) {
		this.fristName = fristName;
	}


	public String getSecoundName() {
		return secoundName;
	}


	public void setSecoundName(String secoundName) {
		this.secoundName = secoundName;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	

}
