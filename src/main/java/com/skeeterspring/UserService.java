package com.skeeterspring;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import models.Role;
import models.User;
import repositories.RoleRepository;
import repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UserService {
	
	private UserRepository userRepository;
	
	private RoleRepository roleRepository;
	
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	public UserService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder 
			bCryptPasswordEncoder) {
		super();
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.bCryptPasswordEncoder= bCryptPasswordEncoder;
	}
	
	  public User findUserByEmail(String email) {
	        return userRepository.findByEmail(email);
	    }

	    public User saveUserAs(User user, String role) {
	    	
	        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
	        Role userRole = roleRepository.findByRoleName(role);
	        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
	        userRepository.save(user);
	        
	        return user;
	    }

}
