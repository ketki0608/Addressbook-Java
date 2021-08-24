package com.example.addressbook.model;

import java.io.*;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Users implements Serializable{
	private List<User> users;
	
	public Users() {
		
	}
	
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	public List<User> getUsers() {
		return this.users;
	}
	
	public String toString() {
		return users.toString(); 
	}
}
