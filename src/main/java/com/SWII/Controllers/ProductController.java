package com.SWII.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.SWII.Entity.ProductEntity;
import com.SWII.Services.ProductServices;

@RestController
@RequestMapping("/Product")
public class ProductController {

	@Autowired
	ProductServices productService;
	
	@RequestMapping(value = "/addproduct", method = RequestMethod.POST)
	public boolean addProduct(@RequestBody ProductEntity productEntity) {
		System.err.println(productEntity.getName());
		if (productService.saveProduct(productEntity))
			return true;
		else
			return false;
	}
	
	@RequestMapping(value = "/getproducts", method = RequestMethod.POST)
	public List<ProductEntity> viewAllProducts(){
		return productService.getAllProducts();
	}
}
