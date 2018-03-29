package com.SWII.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SWII.Entity.OnlineProductEntity;
import com.SWII.Entity.Product;
import com.SWII.Repositories.OnlineProductRepo;

@Service
public class OnlineProductServices implements IProductServices {

	@Autowired
	OnlineProductRepo productRepo; 

	
	@Override
	public boolean saveProduct(Product product) {
		if(productRepo.existsById(product.getProductId())) {
			return false;
		}else {
			productRepo.save((OnlineProductEntity)product);
			return true;
		}
	}
	

}
