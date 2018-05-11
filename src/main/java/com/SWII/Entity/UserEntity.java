package com.SWII.Entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;

	private String email;
	private String password;

	@Column(unique = true)
	private String userName;
	
	@OneToMany(mappedBy = "customers", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<BoughtProductsEntity> customers;

	

	public UserEntity(int userId, String email, String password, String userName, Set<BoughtProductsEntity> customers) {
		super();
		this.userId = userId;
		this.email = email;
		this.password = password;
		this.userName = userName;
		this.customers = customers;
	}
	
	public UserEntity(String email, String password, String userName) {
		super();
		this.email = email;
		this.password = password;
		this.userName = userName;
	}

	public UserEntity() {
		super();
		this.email = "";
		this.password = "";
		this.userName = "";
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Set<BoughtProductsEntity> getCustomers() {
		return customers;
	}

	public void setCustomers(Set<BoughtProductsEntity> customers) {
		this.customers = customers;
	}
	
	

}
