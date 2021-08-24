package com.example.addressbook.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User implements Serializable{
	/**
	 * 
	 */

	private String name;
	private String email;
	//private List<ContactMethod> contactmethod;
	
	public User() {
		
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
//	public void setContactmethod(List<ContactMethod> contactmethod) {
//		this.contactmethod = contactmethod;
//	}
	
	public String getName() {
		return this.name;
	}
	
	public String getEmail() {
		return this.email;
	}
	
//	public List<ContactMethod> get() {
//		return this.contactmethod;
//	}
	
	public String toString() {
		return this.name;
	}
	
}
