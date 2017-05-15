package md.curs.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import md.curs.model.User;
import md.curs.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@ModelAttribute("user")
	public User getUser() {
		return new User();
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup() {
		
		return "signup";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String doSignUp(@Valid @ModelAttribute("user") User user, BindingResult result) {
		
		if (result.hasErrors()) {
			
			return "signup";
		} else {
			
			userService.createUser(user);
			
			return "redirect:calculator";
		}
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String users(Model model) {
		
		List<User> users = userService.getUsers();
		model.addAttribute("users", users);
		
		
		return "users";
	}

}
