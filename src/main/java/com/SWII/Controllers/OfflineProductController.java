package com.SWII.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.SWII.Entity.OfflineProductEntity;
import com.SWII.Repositories.OfflineProductRepo;


@Controller
@RequestMapping("/offlineProduct")
public class OfflineProductController {

	@Autowired
	OfflineProductRepo productRepo;
	
	@RequestMapping(value="/addproduct",method=RequestMethod.POST)
	public boolean addProduct(Model model ,@ModelAttribute OfflineProductEntity product) {
		model.addAttribute("product", new OfflineProductEntity());
		if(productRepo.existsById(product.getProductId())) {
			productRepo.save(product);
			return false;
		}else {
			productRepo.save(product);
			return true;
		}
	}
	
	
}
