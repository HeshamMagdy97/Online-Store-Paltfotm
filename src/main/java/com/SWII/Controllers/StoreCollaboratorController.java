package com.SWII.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SWII.Entity.StoreCollaboratorsEntity;
import com.SWII.Services.StoreCollaboratorsServices;

@RestController
@RequestMapping("/store")
public class StoreCollaboratorController {
	
	@Autowired
	StoreCollaboratorsServices storeCollaService;
	
	@RequestMapping("/addcollaborator")
	public boolean assignCollaborator(@RequestBody StoreCollaboratorsEntity storeColla) {
		return storeCollaService.addCollaToStore(storeColla);
	}
	
}
