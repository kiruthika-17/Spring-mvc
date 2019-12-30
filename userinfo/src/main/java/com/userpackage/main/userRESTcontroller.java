package com.userpackage.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class userRESTcontroller {

	@Autowired
	private userserviceclass us;
	@RequestMapping("/")
	public String hello() {
		return "This is home page";
	}
	
	@GetMapping("/save-user")
	public String saveUser(@RequestParam String username,@RequestParam String password) {
		usermodelclass user=new usermodelclass(username,password);
		us.saveMyUser(user);
		return "user saved";
	}
}
