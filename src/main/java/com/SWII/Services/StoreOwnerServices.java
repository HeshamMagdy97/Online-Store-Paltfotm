package com.SWII.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SWII.Repositories.StoreOwnerRepository;

@Service
public class StoreOwnerServices {

	@Autowired
	StoreOwnerRepository ownerRepository;
	
	public boolean exist(int id) {
		return ownerRepository.existsById(id);
	}
	
//	public StoreOwnerEntity getOwner() {
//		return ownerRepository.existsById(id);
//	}
	
}
