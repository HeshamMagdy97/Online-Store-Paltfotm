 package com.SWII.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SWII.Entity.StoreEntity;
import com.SWII.Entity.StoreProductsEntity;
import com.SWII.Repositories.StoreProductsRepository;

@Service
public class StoreProductsServices {

	@Autowired
	StoreProductsRepository storeProductRepo;
	
	@Autowired
	StoreServices storeServices;

	public List<StoreProductsEntity> getStoreProduct(StoreEntity storeId){
		return storeProductRepo.findBystores(storeId);
	}
	
	public boolean saveProduct(StoreProductsEntity entity) {
		if(storeServices.getStoreByName(entity.getStores().getName()).getStatus() == false)
			return false;
		return storeProductRepo.save(entity) != null;
	}
	
	public boolean removeProduct(StoreProductsEntity entity) {
		if(storeServices.getStoreByName(entity.getStores().getName()).getStatus() == false)
			return false;
		 storeProductRepo.delete(entity);
		 return true;
	}	
	
	public boolean updateProduct(StoreProductsEntity entity) {
		if(storeServices.getStoreByName(entity.getStores().getName()).getStatus() == false || !storeProductRepo.existsById(entity.getId()))
			return false;
		 storeProductRepo.save(entity);
		 return true;
	}
	
	
}
