package com.SWII.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SWII.Entity.StoreCollaboratorsEntity;
import com.SWII.Repositories.StoreCollaboratorsRepository;

@Service
public class StoreCollaboratorsServices {

	@Autowired
	StoreCollaboratorsRepository storeCollaboratorsRepo;
	
	public boolean addCollaToStore(StoreCollaboratorsEntity collaborator) {
		if (storeCollaboratorsRepo.findByCollaboratorsAndStores(collaborator.getCollaborator().getUserId()
				,collaborator.getStore().getStoreId()) == null) {
				storeCollaboratorsRepo.save(collaborator);
				return true;
		}
		return false;
	}
}
