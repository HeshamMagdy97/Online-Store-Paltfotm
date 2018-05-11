package com.SWII.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SWII.Entity.CollaboratorsEntity;
import com.SWII.Entity.StoreEntity;
import com.SWII.Entity.UpdateRemoveHistory;
import com.SWII.Repositories.UpdateRemoveHistoryRepository;

@Service
public class UpdateRemoveHistorServices {

	@Autowired
	UpdateRemoveHistoryRepository historyRepository;

	public boolean save(UpdateRemoveHistory entity) {
		return historyRepository.save(entity) != null;
	}

	public boolean delete(UpdateRemoveHistory entity) {
		if (!historyRepository.existsById(entity.getId()))
			return false;
		historyRepository.delete(entity);
		return true;

	}
	
	public List<UpdateRemoveHistory> getCollaboratorActions(CollaboratorsEntity collaborato,StoreEntity storeEntity){
		return historyRepository.findByCollaboratoAndStores(collaborato.getUserId(), storeEntity.getStoreId());
	}

}
