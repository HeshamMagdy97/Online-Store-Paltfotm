package com.SWII.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SWII.Entity.ProductStatistics;
import com.SWII.Entity.StoreEntity;
import com.SWII.Entity.StoreProductsEntity;

@Service
public class ProductStat extends ProductStatistics {
	
	@Autowired
	StoreProductsServices storeProductService;
	
	private List<StoreProductsEntity> storeProduct;
	
	public ProductStat(StoreEntity store) {
		super(store);
		this.storeProduct = storeProductService.getStoreProduct(store);
	}

	public ProductStat() {
		super();
	}



	@Override
	public StoreProductsEntity min() {
		this.storeProduct = storeProductService.getStoreProduct(store);
		int minNumOfViews= Integer.MAX_VALUE;
		StoreProductsEntity product = null;
		for(StoreProductsEntity storepro : storeProduct) {
			if(storepro.getNumberOfViews() < minNumOfViews) {
				 minNumOfViews = storepro.getNumberOfViews();
				 product = storepro;
			}
		}
		return product;
	}

	@Override
	public StoreProductsEntity max() {
		this.storeProduct = storeProductService.getStoreProduct(store);
		int minNumOfViews= 0;
		StoreProductsEntity product = null;
		for(StoreProductsEntity storepro : storeProduct) {
			if(storepro.getNumberOfViews() > minNumOfViews) {
				 minNumOfViews = storepro.getNumberOfViews();
				 product = storepro;
			}
		}
		return product;
	}

	@Override
	public int sum() {
		this.storeProduct = storeProductService.getStoreProduct(store);
		int numOfViews= 0;
		for(StoreProductsEntity storepro : storeProduct) {
			numOfViews += storepro.getNumberOfViews();
		}
		return numOfViews;
	}

	@Override
	public int avg() {
		this.storeProduct = storeProductService.getStoreProduct(store);
		int numOfViews= 0;
		for(StoreProductsEntity storepro : storeProduct) {
			numOfViews += storepro.getNumberOfViews();
		}
		return numOfViews / storeProduct.size();
	}

}
