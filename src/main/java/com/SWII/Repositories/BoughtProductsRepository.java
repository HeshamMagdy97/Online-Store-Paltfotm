package com.SWII.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.SWII.Entity.BoughtProductsEntity;
import com.SWII.Entity.StoreEntity;
import com.SWII.Entity.UserEntity;

public interface BoughtProductsRepository extends CrudRepository<BoughtProductsEntity, Integer> {

	public List<BoughtProductsEntity> findBystores(StoreEntity storeId);
	
	public List<BoughtProductsEntity> findByCustomers(UserEntity userId);

}
