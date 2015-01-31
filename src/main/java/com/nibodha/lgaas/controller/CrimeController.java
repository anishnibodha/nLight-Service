package com.nibodha.lgaas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nibodha.lgaas.entity.CrimeUpdateEntity;
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
	
	@RequestMapping("/alllist")
	public String getCrimeList() throws JsonProcessingException{
		List<CrimeUpdateEntity> crimeUpdateList = lightService.findCrimeList();
		return new ObjectMapper().writeValueAsString(crimeUpdateList);
	}
	
	@RequestMapping("/takeAction/{crimeId}")
	public String changeStatus(@PathVariable("crimeId") Long crimeId) throws JsonProcessingException{
		lightService.closeCrime(crimeId);
		return "success";
	}
	
}
