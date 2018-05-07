package com.SWII.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SWII.Entity.BrandEntity;
import com.SWII.Repositories.BrandRepository;

@Service
public class BrandServices {

	@Autowired
	BrandRepository brandRepo;

	public boolean addBrand(BrandEntity brand) {
		if (brandRepo.existsById(brand.getName()))
			return false;
		brandRepo.save(brand);
		return true;
	}
}
