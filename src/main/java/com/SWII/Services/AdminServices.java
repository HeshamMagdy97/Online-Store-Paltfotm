package com.SWII.Services;

import com.SWII.Entity.BrandEntity;
import com.SWII.Entity.ProductEntity;
import com.SWII.Repositories.BrandRepository;
import com.SWII.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SWII.Repositories.AdminRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class AdminServices {

	@Autowired
	AdminRepository adminRepo;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	BrandRepository brandRepository;
	public boolean loadUserByUserName(String userName, String password) {

		if (adminRepo.existsByUserName(userName)&&adminRepo.existsByPassword(password)) {
			return true;
		}else {
			return false;
		}
	}
	private Set<ProductEntity> generateSet(Iterable<ProductEntity> iterable)
	{
		Set<ProductEntity> productList = new HashSet<ProductEntity>();
		for(ProductEntity store : iterable)
		{
			productList.add(store);
		}
		return productList;
	}
	private Set<BrandEntity> generateBrandSet(Iterable<BrandEntity> iterable)
	{
		Set<BrandEntity> brandList = new HashSet<BrandEntity>();
		for(BrandEntity store : iterable)
		{
			brandList.add(store);
		}
		return brandList;
	}


	public Set<ProductEntity> showProducts()
	{
		Iterable<ProductEntity> iter=productRepository.findAll();
		return generateSet(iter);
	}


	public Set<BrandEntity> showBrands()
	{
		Iterable<BrandEntity> iter=brandRepository.findAll();
		return generateBrandSet(iter);
	}
}
