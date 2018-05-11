package com.SWII.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SWII.Entity.AdminEntity;
import com.SWII.Entity.BrandEntity;
import com.SWII.Entity.StoreEntity;
import com.SWII.Repositories.AdminRepository;

@Service
public class AdminServices {

	@Autowired
	AdminRepository adminRepo;
	
	@Autowired
	StoreServices storeServices;
	
	@Autowired
	BrandServices brandServices;

	public AdminEntity loadUserByUserName(String userName, String password) {
		AdminEntity admin = adminRepo.findById(userName).get();
		if (admin.getPassword().equals(password)) {
			return admin;
		}else {
			return null;
		}
	}
	
	public boolean addBrand(BrandEntity brand) {
		System.out.println(brand.getName()+"---"+brand.getCategory());
		return brandServices.addBrand(brand);
	}
	
	public boolean approveStore(String storeName) {
		StoreEntity store=storeServices.getStoreByName(storeName);
		if(store != null) {
			store.setStatus(true);
			storeServices.saveStore(store);
			return true;
		}
		return false;
		
	}
	
}
