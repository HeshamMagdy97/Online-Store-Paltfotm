package com.SWII.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.SWII.Entity.BoughtProductsEntity;
import com.SWII.Entity.ProductEntity;
import com.SWII.Entity.StoreEntity;
import com.SWII.Services.BoughtProductsServices;
import com.SWII.Services.StoreServices;

@RestController
@RequestMapping("/buy")
public class BoughtProductsController {
	
	@Autowired
	BoughtProductsServices boughtProductsService;
	
	@Autowired
	StoreServices storeService;
	
	@RequestMapping(value="/{storeId}/{productId}",method=RequestMethod.POST)
	public  boolean addBoughtProduct(@PathVariable("storeId") String storId, @PathVariable("productId") String productId, 
			@RequestBody BoughtProductsEntity bpe) {
		bpe.setProducts(new ProductEntity(Integer.parseInt(productId)));
		bpe.setStores(new StoreEntity(Integer.parseInt(storId)));
		if(boughtProductsService.saveBoght(bpe))
			return true;
		else
			return false;

	}
}
