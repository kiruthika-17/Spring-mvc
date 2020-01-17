package mainpack.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import mainpack.model.user;

import mainpack.repo.userrepo;

@Service
@Transactional
public class userservice {

	private final userrepo ur;

	public userservice(userrepo ur) {
		this.ur=ur;
	}
	public void adduser(user u) {
		ur.save(u);
	}
	
	public List<user> showAllUsers() {
		List<user> users=new ArrayList<>();
		ur.findAll().forEach(users::add);
		return users;
	}
	public void DeleteUser(int id) {
		ur.deleteById(id);
		
	}
	public void Updateuser(user u,int id) {
		ur.save(u);
		
	}
	public Optional<user> getuser(int id) {
		
		return ur.findById(id);
	}
	
	

	

}