package com.userpackage.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class usercontroller {

	@Autowired
	private userserviceclass us;
	@RequestMapping("/welcome")
	public String Welcome(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_HOME");
		return "welcomepage";
	}

	@RequestMapping("/register")
	public String registration(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_REGISTER");
		return "welcomepage";
	}

	@PostMapping("/saveuser")
	public String registerUser(@ModelAttribute usermodelclass user, BindingResult bindingResult, HttpServletRequest request) {
		us.saveMyUser(user);
		request.setAttribute("mode", "MODE_HOME");
		return "welcomepage";
	}
	
	@GetMapping("/display")
	public String showAllUsers(HttpServletRequest request) {
		request.setAttribute("users", us.showAllUsers());
		request.setAttribute("mode", "MODE_DISPLAY");
		return "welcomepage";
	}
	
	@RequestMapping("/delete-user")
	public String DeleteUser(@RequestParam int id,HttpServletRequest request) {
		us.DeleteUser(id);
		request.setAttribute("users", us.showAllUsers());
		request.setAttribute("mode", "MODE_DISPLAY");
		return "welcomepage";
	}
	
	@RequestMapping("/update-user")
	public String UpdateUser(@RequestParam int id,HttpServletRequest request) {
		request.setAttribute("u", us.UpdateUser(id));
		request.setAttribute("mode", "MODE_UPDATE");
		return "welcomepage";
	}
	
	@RequestMapping("/login")
	public String loginpage(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_LOGIN");
		return "welcomepage";
	}
	
	@RequestMapping("/login-user")
	public String loginuser(@ModelAttribute usermodelclass u,HttpServletRequest request,HttpSession session)
	{
		session.setAttribute("username", u.getUsername());
		if(us.findByUsernameAndPassword(u.getUsername(),u.getPassword())!=null)
		{
		return "homepage";
		}
		else {
			request.setAttribute("error", "Invalid username or password");
			request.setAttribute("mode", "MODE_LOGIN");
			return "welcomepage";
		}
	}
}
