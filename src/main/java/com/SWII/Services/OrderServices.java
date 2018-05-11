package com.SWII.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SWII.Entity.OrderEntity;
import com.SWII.Entity.OrderProductEntity;
import com.SWII.Entity.UserEntity;
import com.SWII.Repositories.OrderRepository;

@Service
public class OrderServices {
	@Autowired
	OrderRepository orderRepo;

	@Autowired
	OrderProductServices orderProductServices;

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

	public List<OrderEntity> getOrders(UserEntity userId) {
		return orderRepo.findByUser(userId);
	}

	public double getTotalPrice(OrderEntity order) {
 
		List<OrderProductEntity> productsList = orderProductServices.getOrderProducts(order);
		double price=0.0;
		double tempPrice=0.0;
		for(OrderProductEntity entity :productsList) {
			tempPrice = entity.getQuantaty()*entity.getBoughBroduct().getPrice();
			if(entity.getQuantaty() >= 2)
				price += 0.1*tempPrice;
			else
				price += tempPrice;
		}
		return price;
	}

}
