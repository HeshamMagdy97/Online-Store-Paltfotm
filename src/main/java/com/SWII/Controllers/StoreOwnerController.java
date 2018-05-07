package com.SWII.Controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.SWII.Entity.StoreOwnerEntity;
import com.SWII.Repositories.StoreOwnerRepository;

@Controller
@RequestMapping("storeowner")
public class StoreOwnerController {
	@Autowired
	StoreOwnerRepository storeOwnerRepo;

	@RequestMapping(value = "/Register", method = RequestMethod.GET)
	public String registerForm(Model model) {
		model.addAttribute("storeOwner", new StoreOwnerEntity());
		return "StoreOwnerRegister";
	}

	@RequestMapping(value = "/Register", method = RequestMethod.POST)
	public String register(Model model, @ModelAttribute StoreOwnerEntity storeOwner, HttpSession session) {
		StoreOwnerEntity owner = (StoreOwnerEntity) session.getAttribute("owner");
		if (owner == null) {
			model.addAttribute("storeOwner", new StoreOwnerEntity());
			if (!storeOwnerRepo.existsById(storeOwner.getUserId())) {
				storeOwnerRepo.save(storeOwner);
				session.setAttribute("owner", storeOwner);
				return "StoreOwnerPanel";
			} else {
				return "User Name Exists";
			}
		} else {
			return "StoreOwnerPanel";
		}
	}

	/********************************************/
	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public String Show(Model model, HttpSession session) {
		StoreOwnerEntity owner = (StoreOwnerEntity) session.getAttribute("owner");
		if (owner == null) {
			model.addAttribute("storeOwner", new StoreOwnerEntity()); 
			return "StoreOwnerSignIn";

		} else {
			return "na signed in ya 7iwaaan";
		}
	}

	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public String SignIn(Model model, @ModelAttribute StoreOwnerEntity storeOwner, HttpSession session) {
		StoreOwnerEntity owner = (StoreOwnerEntity) session.getAttribute("owner");
		if (owner == null) {
			model.addAttribute("storeOwner", new StoreOwnerEntity());
			StoreOwnerEntity storeOwnerFormdb = storeOwnerRepo.findById(storeOwner.getUserId()).get();
			System.out.println(storeOwner.getPassword() + "----" + storeOwnerFormdb.getPassword());
			if (storeOwnerFormdb.getPassword().equals(storeOwner.getPassword())) {
				session.setAttribute("storeOwner",storeOwnerFormdb);
				return "StoreOwnerPanel";
			}else {
				return "Wrong";
			}
		} else {
			return "na signed in ya 7iwaaan";
		}
	}
}
