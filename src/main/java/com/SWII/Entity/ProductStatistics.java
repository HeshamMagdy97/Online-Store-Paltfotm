package com.SWII.Entity;

public abstract class ProductStatistics {

	protected StoreEntity store;

	public ProductStatistics() {
		super();
	}

	public ProductStatistics(StoreEntity store) {
		super();
		this.store = store;
	}

	public StoreProductsEntity min() {
		return null;
	}

	public StoreProductsEntity max() {
		return null;
	}

	public int sum() {
		return 0;
	}

	public int avg() {
		return 0;
	}

	public StoreEntity getStore() {
		return store;
	}

	public void setStore(StoreEntity store) {
		this.store = store;
	}

}
