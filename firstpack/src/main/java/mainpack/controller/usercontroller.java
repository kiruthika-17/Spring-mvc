package mainpack.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mainpack.model.user;
import mainpack.service.userservice;

@RestController
public class usercontroller{

	@Autowired
	private userservice us;
	
	@GetMapping("/listUsers")
	public List<user> showAllUsers(){
		return us.showAllUsers();
}
	@GetMapping("/listUsers/{userid}")
	public Optional<user> getuser(@PathVariable int userid) {
		return us.getuser(userid);
	}
	@RequestMapping(method=RequestMethod.POST,value="/listUsers")
	public void adduser(@RequestBody user u) {
		us.adduser(u);
		
	}
	@RequestMapping(method=RequestMethod.PUT,value="/listUsers/{userid}")
	public void update(@RequestBody user u,@PathVariable int userid) {
		us.Updateuser(u,userid);
		
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/listUsers/{userid}")
	public void delete(@PathVariable int userid) {
		us.DeleteUser(userid);
		
	}

}
