package com.nibodha.lgaas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nibodha.lgaas.service.LightService;

@RestController
@RequestMapping("/crime")
public class CrimeController {

	@Autowired
	LightService lightService;
	
	
	@RequestMapping("/location/{longitude}/{latitude}")
	public String checkUpdates(@PathVariable("longitude") String longitude,@PathVariable("latitude") String latitude){
		
		lightService.newCrimeUpdate(longitude,latitude);
		return "Success";
	}
	
}
