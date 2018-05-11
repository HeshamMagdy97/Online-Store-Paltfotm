package com.SWII.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SWII.Entity.BoughtProductsEntity;
import com.SWII.Entity.StoreEntity;
import com.SWII.Entity.UserEntity;
import com.SWII.Repositories.BoughtProductsRepository;

@Service  
public class BoughtProductsServices {
	@Autowired
	BoughtProductsRepository boughtProductsRepo;

	public boolean saveBoght(BoughtProductsEntity BOE) {
		boughtProductsRepo.save(BOE);
		return true;
	}

	public List<BoughtProductsEntity> getBoughtwProduct(StoreEntity storeId) {
		return boughtProductsRepo.findBystores(storeId);
	}
	
	public boolean isFirstTime(UserEntity userId) {
		if(boughtProductsRepo.findByCustomers(userId) != null)
			return false;
		return true;
	}
}
