package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name="user_details")
public class UserDetails {

	@Id
	@Column(nullable = false, unique = true)
	private String username;
	private String firstname;
	private String lastname;
	//private long phonenumber;
	private String role;
	private String email;
	private String address;
	
	 

	//@Column(unique = true)
	@Column(nullable = false)
	private String password;
	
	private String securityans;
	

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



	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

//	public long getPhonenumber() {
//		return phonenumber;
//	}
//
//	public void setPhonenumber(long phonenumber) {
//		this.phonenumber = phonenumber;
//	}
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	public String getSecurityans() {
		return securityans;
	}

	public void setSecurityans(String securityans) {
		this.securityans = securityans;
	}


	public UserDetails(String firstname, String lastname, String email,String role, String address,
			String username,String password, String securityans ) {
		super();
		
		this.firstname = firstname;
		this.lastname = lastname;
		//this.phonenumber = phonenumber;
		this.role =role;
		this.email = email;
		this.address = address;
		this.username = username;
		this.password = password;
		this.securityans = securityans;
	}

	public UserDetails() {
		super();
	}
	
	@Override
	public String toString() {
		return "UserDetails [firstname=" + firstname + ", lastname=" + lastname + ", role=" + role
				+ ", email=" + email + ", address=" + address + ", username=" + username + ", password=" + password
				+ ", securityans=" + securityans + "]";
	}

}
