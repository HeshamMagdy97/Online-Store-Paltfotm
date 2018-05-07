package com.SWII.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.SWII.Entity.StoreCollaboratorsEntity;

public interface StoreCollaboratorsRepository extends CrudRepository<StoreCollaboratorsEntity,Integer>{

	public List<StoreCollaboratorsEntity> findByCollaboratorsAndStores(int id, int storeId); 

}
