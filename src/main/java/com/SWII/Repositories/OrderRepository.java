package com.SWII.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.SWII.Entity.CustomerEntity;
import com.SWII.Entity.OrderEntity;

public interface OrderRepository extends CrudRepository<OrderEntity,Integer>  {
	public List<OrderEntity> findByUser(CustomerEntity userId);
}
