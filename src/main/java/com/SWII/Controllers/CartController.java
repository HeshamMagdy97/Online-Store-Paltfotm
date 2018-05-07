package com.SWII.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.SWII.Entity.CustomerEntity;
import com.SWII.Entity.OrderEntity;
import com.SWII.Services.CartServices;

@RestController
public class CartController {
	
	@Autowired
	CartServices cartService;
	
	public boolean addToCart(OrderEntity order) {
		return cartService.addOrderToCart(order);
	}
	
	public boolean Buy(CustomerEntity userId) {
		return cartService.proceed(cartService.getAllOrders(userId));
	}
	
	
}
