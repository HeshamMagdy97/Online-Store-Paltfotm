package com.SWII.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SWII.Entity.CustomerEntity;
import com.SWII.Entity.OrderEntity;
import com.SWII.Repositories.OrderRepository;

@Service
public class OrderServices {
	@Autowired
	OrderRepository orderRepo;

	public boolean changeState(OrderEntity order, boolean state) {
		if (orderRepo.existsById(order.getOrderID())) {
			order.setCheckout(state);
			orderRepo.save(order);
			return true;
		}
		return false;
	}
	
	public boolean addOreder(OrderEntity order) {
		return orderRepo.save(order) != null;
	}
	
	public List<OrderEntity> getOrders(CustomerEntity userId){
		return orderRepo.findByUser(userId);		
	}
	
}
