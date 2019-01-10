package com.skeeterspring;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.MockitoAnnotations.initMocks;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import models.User;
import repositories.RoleRepository;
import repositories.UserRepository;

public class UserServiceTest {
	
	 @Mock
	    private UserRepository mockUserRepository;
	    @Mock
	    private RoleRepository mockRoleRepository;
	    @Mock
	private BCryptPasswordEncoder mockBCryptPasswordEncoder;
	    
	    private UserService userServiceUnderTest;
	    private User user;
	
	    @Before
	    public void setUp() {
	    	
	        initMocks(this);
	        userServiceUnderTest = new UserService(mockUserRepository,
	                                               mockRoleRepository,
	                                               mockBCryptPasswordEncoder);
	        user = new User();
	        user.setUsername("Anthony Pettis");
	        user.setPassword("Showtime");
	        user.setEmail("somemail@mail.org");

	        Mockito.when(mockUserRepository.save(any()))
	                .thenReturn(user);
	        Mockito.when(mockUserRepository.findByEmail(anyString()))
	                .thenReturn(user);
	}
	    
	    @Test
	    public void testFindUserByEmail() {
	        
	        final String email = "somemail@mail.org";
	        final User result = userServiceUnderTest.findUserByEmail(email);
	        assertEquals(email, result.getEmail());
	    }

	    @Test
	    public void testSaveUser() {
	      
	    	final String email = "somemail@mail.org";
	    	User newUser= new User();
	    	newUser.setUsername("Crapper Napper");
	    	newUser.setEmail("somemail@mail.org");
	    	
	        User result = userServiceUnderTest.saveUserAs(newUser, "teacher");

	        assertEquals(email, result.getEmail());
	    }
	}


