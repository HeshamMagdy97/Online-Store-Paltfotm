package com.SWII.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.SWII.Entity.StoreEntity;
import com.SWII.Services.StoreServices;

@RestController
@RequestMapping("/store")
public class StoreController {

	@Autowired
	StoreServices storeService;

	@RequestMapping(value="/addstore",method=RequestMethod.POST)
	public boolean addStore(@RequestBody StoreEntity store) {		
		System.err.println(store.getName()+"--"+store.getNumberOfView()+"--"+store.getStoreOwner());
		return storeService.saveStore(store);
	}
}
