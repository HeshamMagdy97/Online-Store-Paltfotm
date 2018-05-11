package com.SWII.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.SWII.Entity.AdminEntity;

import com.SWII.Entity.BrandEntity;
import com.SWII.Services.AdminServices;

@RestController
@RequestMapping("admin")
public class AdminController {

	@Autowired
	AdminServices adminService;

	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public String SignIn(Model model, @ModelAttribute AdminEntity admin) {
		model.addAttribute("admin", new AdminEntity());
		if (adminService.loadUserByUserName(admin.getEmail(), admin.getPassword()) != null) {
			return "signedin";
		}
		return "ww";
	}

	@RequestMapping(value = "/addBrand", method = RequestMethod.POST)
	public boolean addBrand(BrandEntity brand) {
		return adminService.addBrand(brand);
	}

	@RequestMapping(value = "/approveStore", method = RequestMethod.POST)
	public boolean approveStore(String storeName) {
		return adminService.approveStore(storeName);
	}

}
