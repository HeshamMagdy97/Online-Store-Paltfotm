package com.SWII.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.SWII.Entity.AddProductHistory;
import com.SWII.Entity.AddProductHistoryServices;
import com.SWII.Entity.CollaboratorsEntity;
import com.SWII.Entity.StoreEntity;
import com.SWII.Entity.StoreProductsEntity;
import com.SWII.Entity.UpdateRemoveHistory;
import com.SWII.Services.CollaboratorSevices;
import com.SWII.Services.StoreProductsServices;
import com.SWII.Services.UpdateRemoveHistorServices;

@RestController
@RequestMapping("/collaborator")
public class CollaboratorController {
	
	@Autowired
	CollaboratorSevices collaboratorSevice;
	
	@Autowired
	StoreProductsServices storeProductService;
	
	@Autowired
	AddProductHistoryServices addProductHistoryService;
	
	@Autowired
	UpdateRemoveHistorServices updateRemoveService;
	
	@RequestMapping("/add")
	public boolean addCollaborator(@RequestBody CollaboratorsEntity collaborator) {
		return collaboratorSevice.saveCollaborator(collaborator);
	}
	
	public List<UpdateRemoveHistory> updateRemoveHistory(CollaboratorsEntity collaborato, StoreEntity storeEntity){
		return updateRemoveService.getCollaboratorActions(collaborato, storeEntity);
	}
	
	@RequestMapping(value = "/addproduct", method = RequestMethod.POST)
	public boolean addProduct(@RequestBody StoreProductsEntity product,int collID){
		if(storeProductService.saveProduct(product)==true) {
			addProductHistoryService.save(new AddProductHistory(product,collaboratorSevice.load(collID), collID));
			return true;
		}
		return false;
	}
	
	
	
}
