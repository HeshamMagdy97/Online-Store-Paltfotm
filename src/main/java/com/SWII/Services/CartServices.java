package com.SWII.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SWII.Entity.CustomerEntity;
import com.SWII.Entity.OrderEntity;
import com.SWII.Repositories.CartRepository;

@Service
public class CartServices {

	@Autowired
	CartRepository cartRepo;
	
	@Autowired
	OrderServices orderServices;
	
	public boolean proceed(CustomerEntity userId) {
		List<OrderEntity> orders = orderServices.getOrders(userId);
		boolean result = true;
		for(OrderEntity order:orders) {
			result=orderServices.changeState(order,true);
		}
		return result;
	}
	
	public boolean addOrderToCart(OrderEntity order) {
		return orderServices.addOreder(order);
	}
	
	
}
