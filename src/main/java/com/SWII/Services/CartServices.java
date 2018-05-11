package com.SWII.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SWII.Entity.OrderEntity;
import com.SWII.Entity.StoreOwnerEntity;
import com.SWII.Entity.UserEntity;
import com.SWII.Repositories.CartRepository;

@Service
public class CartServices {

	@Autowired
	CartRepository cartRepo;
	
	@Autowired
	OrderServices orderServices;
	
	@Autowired
	BoughtProductsServices boughtProductsServices;
	
	public boolean proceed(List<OrderEntity> orders) {
		boolean result = true;
		for(OrderEntity order:orders) {
			result=orderServices.changeState(order,true);
		}
		return result;
	}
	 
	public boolean addOrderToCart(OrderEntity order) {
		return orderServices.addOreder(order);
	}
	
	public List<OrderEntity> getAllOrders(UserEntity userId){
		return orderServices.getOrders(userId);
	}
	
	public double totalProductsPrice(List<OrderEntity> orders) {
		double price = 0.0;
		for(OrderEntity order : orders)
			price += order.getTotalPrice();
		return price;
	}
	
	public int descountPercent(List<OrderEntity> orders, UserEntity userId) {
		int percent=0;
		
		if(boughtProductsServices.isFirstTime(userId))
			percent += 5;
		
		if(userId instanceof StoreOwnerEntity)
			percent += 15;
		
		return percent;
	}
	
	public double calculateTotalPrice(double price, double percent) {
		return (double)(percent/100.0) * price;
	}
}
