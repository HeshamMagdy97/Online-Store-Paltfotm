package com.SWII.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SWII.Entity.CustomerEntity;
import com.SWII.Repositories.CustomerRepository;

@Service
public class CutomerServices {

	@Autowired
	CustomerRepository customerRepo;

	public boolean saveCustomer(CustomerEntity customer) {
		if (customerRepo.existsById(customer.getUserName()))
			return false;
		else {
			customerRepo.save(customer);
			return true;
		}
	}
	public boolean loadUserByUserName(String userName, String password) {

		if (customerRepo.existsByUserName(userName)&&customerRepo.existsByPassword(password)) {
			return true;
		}else {
			return false;
		}
	}
	
	public CustomerEntity getCustomerByUserName(String userName,String password) {
		CustomerEntity customer=customerRepo.findById(userName).get();
		if(customer.getPassword().equals(password)) {
			return customer;
		}else {
			return null;
		}
	}
	
	public CustomerEntity getCustomerByEmail(String email,String password) {
		CustomerEntity customer=customerRepo.findByEmail(email);
		if(customer.getPassword().equals(password)) {
			return customer;
		}else {
			return null;
		}
	}

}
