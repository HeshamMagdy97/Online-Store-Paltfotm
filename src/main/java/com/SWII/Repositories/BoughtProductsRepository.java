package com.SWII.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.SWII.Entity.BoughtProductsEntity;
import com.SWII.Entity.StoreEntity;

public interface BoughtProductsRepository extends CrudRepository<BoughtProductsEntity, Integer> {

	public List<BoughtProductsEntity> findBystores(StoreEntity storeId);

}
