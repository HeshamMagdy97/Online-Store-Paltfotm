package com.SWII.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.SWII.Entity.OnlineStoreEntity;
import com.SWII.Entity.Store;
import com.SWII.Entity.StoreProductsEntity;
import com.SWII.Services.OnlineProductServices;

@RestController
@RequestMapping(value="/productsinstore")
public class StoreProductsController {

	@Autowired
	OnlineProductServices storeProductService;
	
	@RequestMapping(value="/{storeId}",method=RequestMethod.GET)
	public List<StoreProductsEntity> getStoreProducts(@PathVariable("storeId") String storeId ){
		//@toDo Store ya H
		Store x = new OnlineStoreEntity();
		x.setStoreId(storeId);
		return null; //storeProductService.getStoreProduct(x);
	}
	
//	public List<StoreProductsEntity> getNumberOfViews(String storeId){
//		List<StoreProductsEntity> views = new ArrayList<>();
//		views = storeProductRepo.findBystores(storeId);
//		return views;
//	}
	
}
