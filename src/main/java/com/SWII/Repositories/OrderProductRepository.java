package com.SWII.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.SWII.Entity.OrderEntity;
import com.SWII.Entity.OrderProductEntity;

public interface OrderProductRepository extends CrudRepository<OrderProductEntity,Integer>  {
	public List<OrderProductEntity> findByOrder(OrderEntity order);
}
