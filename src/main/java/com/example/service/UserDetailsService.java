package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.UserDetails;
import com.example.repository.UserDetailsRepo;

@Service
public class UserDetailsService implements UserDetailsInt{
	@Autowired
	public UserDetailsRepo userdetailsrepo;

	@Override
	public UserDetails saveDetails(UserDetails userdetails) {
		return userdetailsrepo.save(userdetails);
	}
	
	 @Override
	    public boolean checkIfUserExist(String username) {
	        return userdetailsrepo.findByUsername(username) !=null ? true : false;
	    }
	@Override
	 public UserDetails validateLogin(String username, String password) {
		 UserDetails ud =  userdetailsrepo.findByUsernameAndPassword(username, password);
		 if(ud!=null) {
			 return ud;
		 //return "success";
		 }
		 else {
			 return null;
		 }
	 }

	

	@Override
	public String deleteDetails(String username, String securityans) {
		// TODO Auto-generated method stub
		UserDetails user = userdetailsrepo.findByUsernameAndSecurityans(username, securityans);
		if(user!=null) {
		userdetailsrepo.deleteById(username);
		return "User Removed successfully";
		}
		else {
			return "Enter valid username/ security answer";
		}
		
	}

	


	
	

}
