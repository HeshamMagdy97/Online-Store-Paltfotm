package com.SWII.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.SWII.Entity.StoreEntity;
import com.SWII.Entity.StoreProductsEntity;
import com.SWII.Services.ProductServices;
import com.SWII.Services.StoreProductsServices;

@RestController
@RequestMapping(value = "/productsinstore")
public class StoreProductsController {

	@Autowired
	ProductServices productService;

	@Autowired
	StoreProductsServices storeProductService;

	@RequestMapping(value = "/{storeId}/addproduct", method = RequestMethod.POST)
	public boolean addProductToStore(@RequestBody StoreProductsEntity entity, @PathVariable("storeId") String storeId) {
		entity.setStores(new StoreEntity(Integer.parseInt(storeId)));
		return storeProductService.saveProduct(entity);
	}
	
	@RequestMapping(value = "/{storeId}/removeproduct", method = RequestMethod.POST)
	public boolean removeProductToStore(@RequestBody StoreProductsEntity entity, @PathVariable("storeId") String storeId) {
		entity.setStores(new StoreEntity(Integer.parseInt(storeId)));
		return storeProductService.removeProduct(entity);
	}

}
