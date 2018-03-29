package com.SWII.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.SWII.Entity.CustomerEntity;

import com.SWII.Entity.Product;

import com.SWII.Services.CutomerServices;


@Controller
@RequestMapping(value="/customer")
public class CustomerController {
	
	@Autowired 
	CutomerServices customerService;

	@RequestMapping(value="/Register", method=RequestMethod.GET)
	public String registerForm(Model model) {
		model.addAttribute("customer",new CustomerEntity());
		return "CustomerRegister";
	}
	
    @RequestMapping(value="/Register",  method=RequestMethod.POST)
	public  String register(Model model,@ModelAttribute  CustomerEntity customer) {
		model.addAttribute("customer",new CustomerEntity());
		if(customerService.saveCustomer(customer)) {
			return "Done";
		}else {
			return "UserNameExists";
		}
    	
	}
    
    
    /******************************/
    
    @RequestMapping(value="/signin", method=RequestMethod.GET)
	public String signInForm(Model model) {
		model.addAttribute("customer",new CustomerEntity());
		return "CustomerSignIn";
		
	}
	
    @RequestMapping(value="/signin",  method=RequestMethod.POST)
	public  String signIn(Model model,@ModelAttribute  CustomerEntity customer) {
		model.addAttribute("customer",new CustomerEntity());
		if(customerService.getCustomerByUserName(customer.getUserName(),customer.getPassword()) != null
				||customerService.getCustomerByEmail(customer.getUserName(),customer.getPassword()) != null){
			return "SignedIn";
		}else {
			return "Wrong";
		}
	}
    
    @RequestMapping(value="/home",  method=RequestMethod.GET)
    public String showProducts(Model model , @ModelAttribute Product product) {
    	return "Buy";
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
