package com.SWII.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SWII.Entity.ProductEntity;
import com.SWII.Repositories.ProductRepository;

@Service
public class ProductServices {

	@Autowired
	ProductRepository productRepo; 

	
	public boolean saveProduct(ProductEntity product) {
		if(productRepo.existsById(product.getProductId())) {
			return false;
		}else {
			productRepo.save(product);
			return true;
		}
	}
	
	public List<ProductEntity> getAllProducts(){
		List<ProductEntity> proucts =  (List<ProductEntity>) productRepo.findAll();
		return proucts;
	}

}
