package com.SWII.Entity;

import javax.persistence.Entity;

@Entity
public class AdminEntity extends UserEntity {

	public AdminEntity() {
		super();
	}

	public AdminEntity(String email, String password, String userName) {
		super(email, password, userName);
	}
	
}
