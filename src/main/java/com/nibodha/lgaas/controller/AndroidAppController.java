package com.nibodha.lgaas.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mobile")
public class AndroidAppController {

	
	
	@RequestMapping("/location/{longitude}/{latitude}")
	public ResponseEntity<String> checkUpdates(@PathVariable("longitude")String longitide, 
			@PathVariable("lattitude") String lattitude){
		String body = "update available";
		ResponseEntity<String> response = new ResponseEntity<String>(body, HttpStatus.OK);
		return response;
	}
	
}
