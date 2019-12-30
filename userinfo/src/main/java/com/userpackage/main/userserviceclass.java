package com.userpackage.main;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
@Service
@Transactional
public class userserviceclass {
	
	private final userRepository ur;
	
	public userserviceclass(userRepository ur) {
		this.ur=ur;
	}

	public void saveMyUser(usermodelclass user) {
		ur.save(user);
	}
	
	public List<usermodelclass> showAllUsers(){
		
	List<usermodelclass> users=new ArrayList<usermodelclass>();
	for(usermodelclass u:ur.findAll()) {
		users.add(u);
	}
		return users;
	}

	public void DeleteUser(int id) {
		ur.deleteById(id);
	}

	public usermodelclass UpdateUser(int id) {
		return ur.findById(id).get();
	}
	
	public usermodelclass findByUsernameAndPassword(String username,String password) {
		return ur.findByUsernameAndPassword(username,password);
	}
 }
