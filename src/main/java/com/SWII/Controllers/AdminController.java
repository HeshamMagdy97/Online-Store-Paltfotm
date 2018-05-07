package com.SWII.Controllers;


import com.SWII.Entity.ProductEntity;
import com.SWII.Entity.StoreEntity;
import com.SWII.Repositories.BrandRepository;
import com.SWII.Repositories.ProductRepository;
import com.SWII.Repositories.StoreRepository;
import com.SWII.Services.ProductServices;
import com.SWII.Services.StoreServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.SWII.Entity.AdminEntity;

import com.SWII.Entity.BrandEntity;
import com.SWII.Services.AdminServices;

import java.util.Set;

@RestController
@CrossOrigin
@RequestMapping("admin")
public class AdminController {

	@Autowired
	AdminServices adminService;
	@Autowired
	BrandRepository brandRepository;
	@Autowired
	ProductServices productServices;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	StoreRepository storeRepository;
	@Autowired
	StoreServices storeServices;
	
	/*@RequestMapping(value="/signin",method=RequestMethod.GET)
	public String Show(Model model) {
		model.addAttribute("admin", new AdminEntity());
		return "AdminSignIn";
	}*/
	
	@RequestMapping(value="/signin",method=RequestMethod.POST)
	public boolean SignIn(String name,String password) {
		System.out.println("email"+" "+name+" "+"password"+" "+password);
		System.out.println();
		System.out.println();System.out.println();
		System.out.println();System.out.println();System.out.println();System.out.println();

		if(adminService.loadUserByUserName(name, password)){
			return true;
		}
		return false;
	}



	@RequestMapping(value="/addbrand",method=RequestMethod.POST)
	public Integer addBrand(@RequestBody BrandEntity brandEntity) {
		if(brandRepository.existsById(brandEntity.getName()))
		{
			return 1;//"this brand already exits in the system";
		}
		else
		{
			brandRepository.save(brandEntity);
			if(brandRepository.existsById(brandEntity.getName()))
			{
				return 2;//"this brand added successfully";
			}
		}

		return 3;//"fail to add this product to the system just try again";
	}




	@RequestMapping(value="/addproduct",method=RequestMethod.POST)
	public Integer addBrand(@RequestBody ProductEntity productEntity) {
		ProductEntity temperory=productRepository.findByName(productEntity.getName());
		if(temperory!=null)
		{
			return 1;//"this brand already exits in the system";
		}
		else
		{
			productServices.saveProduct(productEntity);
			temperory=productRepository.findByName(productEntity.getName());
			if(temperory!=null)
			{
				return 2;//"this brand added successfully";
			}
		}

		return 3;//"fail to add this product to the system just try again";
	}

	@RequestMapping(value="/showproducts",method=RequestMethod.POST)
	public Set<ProductEntity> showProducts()
	{
	return adminService.showProducts();
	}


	@RequestMapping(value="/showbrands",method=RequestMethod.POST)
	public Set<BrandEntity> showBrands()
	{
		return adminService.showBrands();
	}

	@RequestMapping(value="/acceptstore",method=RequestMethod.POST)
	public boolean acceptStore(String storeName)
	{
		StoreEntity temp=storeRepository.findByName(storeName);
		if(temp!=null)
		{
			temp.setStatus(true);
			storeRepository.save(temp);
			System.out.println(temp.getStatus());
			return  true;
		}

		return  false;
	}

	@RequestMapping(value="/showstores",method=RequestMethod.POST)
	public Set<StoreEntity> showStores()
	{
		return storeServices.showStores();
	}

}
