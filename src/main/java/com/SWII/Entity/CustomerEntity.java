package com.SWII.Entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class CustomerEntity extends UserEntity {

	private String fristName;
	private String secoundName;

	@OneToMany(mappedBy = "customers", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<BoughtProductsEntity> customers;

	public CustomerEntity(String email, String password, String userName, String fristName, String secoundName,
			Set<BoughtProductsEntity> customers) {
		super(email, password, userName);
		this.fristName = fristName;
		this.secoundName = secoundName;
		this.customers = customers;
	}

	public CustomerEntity() {
		super();
		this.fristName = "";
		this.secoundName = "";
	}

	public CustomerEntity(String email, String password, String userName) {
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

	public Set<BoughtProductsEntity> getCustomers() {
		return customers;
	}

	public void setCustomers(Set<BoughtProductsEntity> customers) {
		this.customers = customers;
	}

}
