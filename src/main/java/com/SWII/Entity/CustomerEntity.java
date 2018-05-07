package com.SWII.Entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class CustomerEntity extends UserEntity {

	private String fristName;
	private String secoundName;


	public CustomerEntity(String email, String password, String userName, String fristName, String secoundName) {
		super(email, password, userName);
		this.fristName = fristName;
		this.secoundName = secoundName;
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

}
