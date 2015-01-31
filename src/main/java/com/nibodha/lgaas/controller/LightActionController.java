package com.nibodha.lgaas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nibodha.lgaas.dto.Result;
import com.nibodha.lgaas.entity.Light;
import com.nibodha.lgaas.service.LightActionService;
import com.nibodha.lgaas.service.LightService;

@RestController
@RequestMapping("/control")
public class LightActionController {
	@Autowired
	LightActionService lightActionService;
	
	@Autowired
	LightService lightService;
	
	
	
	@RequestMapping("/blink/{level}/{lightid}/{activationkey}")
	public String startLight(@PathVariable("level") Long level,@PathVariable("lightid") Long lightid,@PathVariable("activationkey") String activationkey) throws Exception{
		String result = lightActionService.blinkLight(level,lightid,activationkey);
		Result res= new Result();
		res.setResult(result);
		return new ObjectMapper().writeValueAsString(res);
	}
	
	@RequestMapping("/alllight")
	public String findAllLights() throws Exception{
		List<Light> allLights = lightService.findAllLights();
		if(allLights.size() <= 10){
			lightService.addDummyData();
			allLights = lightService.findAllLights();
		}
		return new ObjectMapper().writeValueAsString(allLights);
	}
	
	
	@RequestMapping("/adddummy")
	public void addDummyData() throws Exception{
		lightService.addDummyData();
	}
	
	@RequestMapping("/changestat/{lightid}/{lightstyle}")
	public void changeLightStatus(@PathVariable("lightid") Long lightid, @PathVariable("lightstyle") String lightStatus) throws Exception{
		lightService.changeLightStatus(lightid, lightStatus);
	}
	
	
	

}
