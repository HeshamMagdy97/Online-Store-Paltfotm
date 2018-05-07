package com.SWII.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.SWII.Entity.StoreEntity;
import com.SWII.Entity.StoreOwnerEntity;

public interface StoreRepository  extends CrudRepository<StoreEntity,Integer>{
		public StoreEntity findByName(String name);
		
		public List<StoreEntity> findByStoreOwner(StoreOwnerEntity storeOwnerEntity);
}
