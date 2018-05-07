package com.SWII.Controllers;

import java.util.List;

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
@RequestMapping(value="/productsinstore")
public class StoreProductsController {

	@Autowired
	ProductServices productService;
	
	@Autowired
	StoreProductsServices storeProductService;
	
	@RequestMapping(value="/{storeId}",method=RequestMethod.GET)
	public List<StoreProductsEntity> getStoreProducts(@PathVariable("storeId") String storeId ){
		StoreEntity x = new StoreEntity();
		return null; //storeProductService.getStoreProduct(x);
	}
	
	@RequestMapping(value="/{storeId}/addproduct",method=RequestMethod.POST)
	public boolean addProductToStore(@RequestBody StoreProductsEntity entity,@PathVariable("storeId") String storeId){
		entity.setStores(new StoreEntity(Integer.parseInt(storeId)));
		return storeProductService.saveProduct(entity);
	}
	
	
	
//	public List<StoreProductsEntity> getNumberOfViews(String storeId){
//		List<StoreProductsEntity> views = new ArrayList<>();
//		views = storeProductRepo.findBystores(storeId);
//		return views;
//	}
	
}
