package com.SWII.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SWII.Entity.Store;
import com.SWII.Entity.StoreProductsEntity;
import com.SWII.Repositories.StoreProductsRepository;

@Service
public class StoreProductsService {

	@Autowired
	StoreProductsRepository storeProductRepo;
	

	public List<StoreProductsEntity> getStoreProduct(Store storeId){
		return storeProductRepo.findBystores(storeId);
	}
	
}
