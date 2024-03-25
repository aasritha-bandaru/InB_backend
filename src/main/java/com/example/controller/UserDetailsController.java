package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.UserDetails;
import com.example.repository.UserDetailsRepo;
import com.example.service.UserDetailsService;

@CrossOrigin(origins = "http://inbsample.s3-website.ap-south-1.amazonaws.com")
@RestController
@RequestMapping("/api/UserDetails")
public class UserDetailsController {
	@Autowired
	private UserDetailsService userdetailservice;
	
	@Autowired
	public UserDetailsRepo userdetailsrepo;
	
	@PostMapping(path = "/adduserdetails", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String addDetails(@RequestBody UserDetails userdetails) {
		 // Check for null values in userdetails
	    if (userdetails == null || userdetails.getUsername() == null || userdetails.getUsername().trim().isEmpty()
	    	||	userdetails.getFirstname() == null || userdetails.getFirstname().trim().isEmpty()
	    	|| userdetails.getLastname() == null || userdetails.getLastname().trim().isEmpty()
	    	|| userdetails.getPassword() == null || userdetails.getPassword().trim().isEmpty()
	    	|| userdetails.getEmail() == null || userdetails.getEmail().trim().isEmpty()
	    	|| userdetails.getRole() == null || userdetails.getRole().trim().isEmpty()
	    	|| userdetails.getAddress() == null || userdetails.getAddress().trim().isEmpty()
	    	|| userdetails.getSecurityans() == null || userdetails.getSecurityans().trim().isEmpty()) {
	        return "Please fill out all the fields";
	    }
	    else if(userdetailservice.checkIfUserExist(userdetails.getUsername())) {
	    	return "Username already exist";
	    }
	    else {
		userdetailservice.saveDetails(userdetails);
		return "added user details successfully";
	    }

	}
	
	@GetMapping("/login/{username}/{password}")
	public UserDetails loginByNamePassword(@PathVariable String username, @PathVariable String password) {
		//String result= userdetailservice.validateLogin(username, password);
//		if(username == null || username.trim().isEmpty()
//				|| password == null || password.trim().isEmpty()) {
//			return "Username/Password cannot be empty";
//			
//		}
		UserDetails ud =userdetailservice.validateLogin(username, password);
		//if(result!=null) {
		if(ud!=null) {
			return ud;
		}
		else {
			return null;
		}
	}
	
	@DeleteMapping("/deleteuser/{username}/{securityans}")
	public String deleteUser(@PathVariable String username,@PathVariable String securityans) {
		//if(userdetailservice.checkIfUserExist(userdetails.getUsername())) {
			String str = userdetailservice.deleteDetails(username, securityans); 
			if(str!=null) {
	    	return str;
	    }
	    else {
		return "Enter valid username/ security answer";
	    }
	}
	

}
