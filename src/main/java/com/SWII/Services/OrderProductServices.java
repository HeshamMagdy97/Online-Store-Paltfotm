package com.SWII.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SWII.Entity.OrderEntity;
import com.SWII.Entity.OrderProductEntity;
import com.SWII.Repositories.OrderProductRepository;

@Service
public class OrderProductServices {
	
	@Autowired
	OrderProductRepository orderProductRepo;
	
	public  List<OrderProductEntity> getOrderProducts(OrderEntity order){
		return orderProductRepo.findByOrder(order);
	}
	
	
}
