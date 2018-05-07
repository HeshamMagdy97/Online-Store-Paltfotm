package com.SWII.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.SWII.Entity.OrderEntity;
import com.SWII.Entity.UserEntity;

public interface OrderRepository extends CrudRepository<OrderEntity,Integer>  {
	public List<OrderEntity> findByUser(UserEntity userId);
	
}
