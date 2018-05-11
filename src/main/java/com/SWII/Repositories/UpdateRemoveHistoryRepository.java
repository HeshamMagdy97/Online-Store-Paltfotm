package com.SWII.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.SWII.Entity.UpdateRemoveHistory;

public interface UpdateRemoveHistoryRepository extends CrudRepository<UpdateRemoveHistory,Integer> {
	public List<UpdateRemoveHistory> findByCollaboratoAndStores(int collaborato,int storeEntity);
}
