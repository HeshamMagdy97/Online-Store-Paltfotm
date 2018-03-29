package com.SWII.Entity;

import javax.persistence.Entity;

@Entity
public class OnlineStoreEntity  extends Store{
	
	
	public OnlineStoreEntity(String storeId) {
		super(storeId, null, 0);
	}
	
	public OnlineStoreEntity() {
		super();
	}
}
