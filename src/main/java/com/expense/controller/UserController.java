package com.expense.controller;

import java.util.logging.Logger;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.expense.entity.User;
import com.expense.service.UserService;

/* Controller to handle creating new user registration */
@Controller
public class UserController {

	Logger log = Logger.getLogger(UserController.class.getName());

	@Autowired
	UserService userService;

	/*
	 * Open registration page
	 */
	@GetMapping("/add-user")
	public String showForm(Model model) {

		User user = new User();
		model.addAttribute("User", user);
		return "register.jsp";
	}

	/*
	 * Save User 
	 */

	@PostMapping("/add-user")
	public String submit(@Valid @ModelAttribute("User") User user, BindingResult result, Model model) {

		log.info("Incoming user: " + user);

		if (userService.getByUsername(user.getUsername()) != null) {
			log.info("User already exist redirecting");
			model.addAttribute("ErrorText", "User is already exist!");
			User userNew = new User();
			model.addAttribute("User", userNew);
			return "register.jsp";
		}
		if (result.hasErrors()) {
			return "register.jsp";
		}
		log.info("user page: " + user);

		User savedUser = userService.saveUser(user);

		log.info("saved user " + savedUser);
		
		model.addAttribute("User", new User());
		model.addAttribute("SuccessText", "User is registered successfully.");
		
		return "register.jsp";
	}

}
