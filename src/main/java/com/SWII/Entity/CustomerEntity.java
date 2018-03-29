package com.SWII.Entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class CustomerEntity {
	@Id
	private String userName;
	private String email;
	private String fristName;
	private String secoundName;
	private String password;
	
	@OneToMany(mappedBy = "customers", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<BoughtProductsEntity> customers;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public CustomerEntity(String userName, String email, String fristName, String secoundName, String password,
			Set<BoughtProductsEntity> customers) {
		super();
		this.userName = userName;
		this.email = email;
		this.fristName = fristName;
		this.secoundName = secoundName;
		this.password = password;
		this.customers = customers;
	}

	public Set<BoughtProductsEntity> getCustomers() {
		return customers;
	}

	public void setCustomers(Set<BoughtProductsEntity> customers) {
		this.customers = customers;
	}

	public CustomerEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
