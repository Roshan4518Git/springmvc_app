package com.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.model.User;
import com.springmvc.service.UserService;

@Controller("FormController")
@ControllerAdvice
public class FormController {
	
	@Autowired
	private UserService userService;
	
	@ModelAttribute
	public void commonData(Model m) {
		m.addAttribute("title", "*Registration Form*");
		m.addAttribute("subtitle", "Registration form in Spring MVC");
	}
	
	@RequestMapping("/form")
	public String showForm(Model model) {
		System.out.println("form created");
		return "form";
	}

	@RequestMapping(path="/processform", method=RequestMethod.POST)
	public String getForm(@ModelAttribute User user, Model model ){
		int id = this.userService.createUser(user);
		model.addAttribute("msg","Data Added Successfully with id "+id);
		return "display";
	}
}

//@RequestMapping(path="/processform", method=RequestMethod.POST)
//public String getForm(
//		@RequestParam(value="email", required=false) String myEmail, 
//		@RequestParam(value="username", required=false) String username,
//		@RequestParam(value="password", required=false) String password,
//		Model model
//		) {
//	
//		System.out.println(myEmail+"\n"+username+"\n"+password);
//	
//		model.addAttribute("email", myEmail);
//		model.addAttribute("username", username);
//		model.addAttribute("password", password);
//	return "display";
//}
