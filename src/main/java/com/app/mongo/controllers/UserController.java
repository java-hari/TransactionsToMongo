package com.app.mongo.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.app.mongo.entity.Notifications;
import com.app.mongo.entity.UserDetails;
import com.app.mongo.services.UserService;

@Controller
//@RestController
//@RequestMapping(path = "/")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public String homeScreen(Model model) {
		model.addAttribute("userDetails", new UserDetails());
		
		return "login";
	}

	@PostMapping("/userLogin")
	public String loginApp() {
		return "home";
	}
	
	
	public String loginScreen(Model model, UserDetails userDetails, HttpSession session, Errors errors) {
		if (userDetails.getUserName() != null && userDetails.getUserName() != null) {
			Optional<UserDetails> details = userService.findByUserName(userDetails.getUserName());

			if (details.isPresent() && details.get().isUserStatus()
					&& details.get().getUserName().equals(userDetails.getUserName())
					&& details.get().getUserPassword().equals(userDetails.getUserPassword())) {

				Iterable<UserDetails> findAll = userService.findAll();
				List<UserDetails> ud = new ArrayList<UserDetails>();
				findAll.forEach(users -> ud.add(users));

				model.addAttribute("userResult", ud);
				model.addAttribute("loginUser", userDetails.getUserName());
				//session.setAttribute("loginUser", userDetails.getUserName());
				return "home";
			}
		} else {
			return "registerUser";
		}

		return "login";
	}

	@GetMapping("/userHomeScreen")
	public String userHomeScreen(Model model, @RequestParam("loginUser") String usrDts) {
		String userId = usrDts;
		if (userId != null) {
			model.addAttribute("loginUser", usrDts);
			return "home";
		}else {
			return homeScreen(model);
		}
	}

	@GetMapping("/notifications")
	public String userNotifications(Model model, @RequestParam("loginUser") String usrDts) {
		String userId = usrDts;
		List<Notifications> notifications = userService.getNotifications();
		model.addAttribute("notificationList", notifications);
		if (userId != null) {
			model.addAttribute("loginUser", usrDts);
			return "userNotifications";
		}else {
			return homeScreen(model);
		}
	}
	
	@GetMapping("/userRegister")
	public String userRegisterScreen(Model model) {
		model.addAttribute("userDetails", new UserDetails());
		model.addAttribute("userResult", userService.findAll());

		return "registerUser";
	}

	@PostMapping("/saveUserRegister")
	public String saveUserRegisterScreen(Model model, UserDetails userDetails) {
		userDetails.setUserStatus(true);

		model.addAttribute(userService.save(userDetails));

		model.addAttribute("userDetails", new UserDetails());
		model.addAttribute("userResult", userService.findAll());

		return "registerUser";
	}

	@PostMapping("/deleteUser")
	public String deleteUserDetails(Model model, @ModelAttribute(value = "delUserId") UserDetails usrDts) {

		userService.deleteById(usrDts.getUserId());

		model.addAttribute("userDetails", new UserDetails());
		model.addAttribute("userResult", userService.findAll());

		return "registerUser";
	}
	/*
	@GetMapping(path = "/userData", produces = { "application/json"})
	public List<UserDetails> findAll() {

		List<UserDetails> empList = new ArrayList<UserDetails>();
		Iterable<UserDetails> findAll = userService.findAll();
		findAll.forEach(action -> empList.add(action));
		//return new ResponseEntity<List<UserDetails>>(empList, HttpStatus.ACCEPTED);
		return empList;
	}*/

	

}
