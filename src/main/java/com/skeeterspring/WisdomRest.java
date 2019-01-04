package com.skeeterspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import repositories.WisdomRepository;

@RestController
public class WisdomRest {
	
	@Autowired
	WisdomRepository wisdomRepository;
	
	String sampleWisdom = "Here we go!";
	
	@GetMapping("/wisdom")
	public String getNewWisdom(){
		
		return wisdomRepository.getRandomWisdom().getWisdom();
		
	}

}
