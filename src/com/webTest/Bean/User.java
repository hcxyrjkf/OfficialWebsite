package com.webTest.Bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;



@Entity
@Table(name="usertable")
@Component("user")
public class User {
	private int id;
	private String userName;
	private String userPassword;
	@Id  
    @GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public User(int id, String userName, String userPassword) {
		super();
		this.id = id;
		this.userName = userName;
		this.userPassword = userPassword;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", userPassword="
				+ userPassword + "]";
	}
	
}
