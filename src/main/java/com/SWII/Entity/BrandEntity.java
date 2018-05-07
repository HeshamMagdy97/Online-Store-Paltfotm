package com.SWII.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BrandEntity {
	
	@Id
	private String name;
	private String category;
	public BrandEntity(String name, String category) {
		super();
		this.name = name;
		this.category = category;
	}
	public BrandEntity() {
		super();
		this.name = "";
		this.category = "";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	
}
