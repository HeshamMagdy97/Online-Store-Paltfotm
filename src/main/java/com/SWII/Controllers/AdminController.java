package com.SWII.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.SWII.Entity.AdminEntity;

import com.SWII.Entity.BrandEntity;
import com.SWII.Services.AdminServices;

@Controller
@RequestMapping("admin")
public class AdminController {

	@Autowired
	AdminServices adminService;
	
	@RequestMapping(value="/signin",method=RequestMethod.GET)
	public String Show(Model model) {
		model.addAttribute("admin", new AdminEntity());
		return "AdminSignIn";
	}
	
	@RequestMapping(value="/signin",method=RequestMethod.POST)
	public String SignIn(Model model ,@ModelAttribute AdminEntity admin) {
		model.addAttribute("admin", new AdminEntity());
		if(adminService.loadUserByUserName(admin.getEmail(), admin.getPassword())!=null){
			return "signedin";
		}
		return "ww";
	}


	

	@RequestMapping(value="/addbrand",method=RequestMethod.GET)
	public String addBrandForm(Model model,BrandEntity brand) {
		model.addAttribute("brand",brand);

		return "AddBrand";
	}
	
	@RequestMapping(value="/approveStore",method=RequestMethod.POST)
	public void approveStore(String storeName) {
		
	}
	
}
