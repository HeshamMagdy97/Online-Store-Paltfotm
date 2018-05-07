package com.SWII.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SWII.Entity.StoreEntity;
import com.SWII.Entity.StoreOwnerEntity;
import com.SWII.Entity.StoreProductsEntity;

@Service
public class StoreStat {

	private List<StoreEntity> stores;
	private StoreOwnerEntity owner;

	@Autowired
	private StoreServices storeService;

	@Autowired
	private ProductStat productStat;

	public StoreStat(StoreOwnerEntity owner) {
		super();
		this.owner = owner;
		stores = storeService.getStores(owner);
	}

	public StoreStat(StoreOwnerEntity owner, StoreServices storeService) {
		super();
		this.owner = owner;
		this.storeService = storeService;
	}

	public StoreStat() {
		super();
		this.stores = null;
		this.owner = null;
	}

	public List<StoreEntity> getStores() {
		return stores;
	}

	public void setStores(List<StoreEntity> stores) {
		this.stores = stores;
	}

	public StoreOwnerEntity getOwner() {
		return owner;
	}

	public void setOwner(StoreOwnerEntity owner) {
		this.owner = owner;
	}

	public StoreServices getStoreService() {
		return storeService;
	}

	public void setStoreService(StoreServices storeService) {
		this.storeService = storeService;
	}

	public StoreProductsEntity min() {
		stores = storeService.getStores(owner);
		int minNumOfViews = Integer.MAX_VALUE;
		StoreProductsEntity product = new StoreProductsEntity();
		StoreProductsEntity minProduct = new StoreProductsEntity();

		for (StoreEntity store : stores) {
			productStat = new ProductStat(store);
			product = productStat.min();
			if (product.getNumberOfViews() < minNumOfViews) {
				minNumOfViews = product.getNumberOfViews();
				minProduct = product;
			}
		}

		return minProduct;
	}

	public StoreProductsEntity max() {
		stores = storeService.getStores(owner);
		int minNumOfViews = Integer.MIN_VALUE;
		StoreProductsEntity product = new StoreProductsEntity();
		StoreProductsEntity minProduct = new StoreProductsEntity();

		for (StoreEntity store : stores) {
			productStat = new ProductStat(store);
			product = productStat.min();
			if (product.getNumberOfViews() > minNumOfViews) {
				minNumOfViews = product.getNumberOfViews();
				minProduct = product;
			}
		}
		return minProduct;
	}

	public int sum() {
		return 0;
	}

	public int avg() {
		return 0;
	}

}
