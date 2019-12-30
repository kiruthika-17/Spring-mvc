package com.userpackage.main;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Mytable")
public class usermodelclass {

	@Id
	 private int id;
	private String username;
	private String password;
	
	
	public usermodelclass() {
		
	}
	

	public usermodelclass(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
