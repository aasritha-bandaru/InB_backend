package com.example.repository;

//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.UserDetails;

@Repository
public interface UserDetailsRepo extends JpaRepository<UserDetails,String>{
	
//	Optional<UserDetails> findByUsername(String username);
	UserDetails findByUsername(String username);
	UserDetails findByUsernameAndPassword(String username, String password);
	UserDetails findByUsernameAndSecurityans(String username, String securityans);
	
}
