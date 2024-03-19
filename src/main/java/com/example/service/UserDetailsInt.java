package com.example.service;

import com.example.entity.UserDetails;

public interface UserDetailsInt {
	
	public UserDetails saveDetails(UserDetails userdetails);
	public boolean checkIfUserExist(String username);
	public String deleteDetails(String username, String securityans);
	public UserDetails validateLogin(String username, String password);

}
