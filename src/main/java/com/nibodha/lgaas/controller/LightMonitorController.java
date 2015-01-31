package com.nibodha.lgaas.controller;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.nibodha.lgaas.dao.ActivationKeyDao;
import com.nibodha.lgaas.entity.ActivationKey;
import com.nibodha.lgaas.entity.Device;
import com.nibodha.lgaas.entity.Light;
import com.nibodha.lgaas.service.LightActionService;
import com.nibodha.lgaas.service.LightService;

@RestController
@RequestMapping("/monitor")
public class LightMonitorController {
	@Autowired
	LightActionService lightActionService;
	
	
	@RequestMapping("/getinfo/{lightid}/{activationkey}")
	public String getInfo(@PathVariable("lightid") Long lightid,@PathVariable("activationkey") String activationkey) throws JsonGenerationException, JsonMappingException, IOException{
		Light light = lightActionService.getLightInfo(lightid, activationkey);
		ObjectMapper oMapper = new ObjectMapper();
		 return oMapper.writeValueAsString(light);
	}
	
	@RequestMapping("/getmoreinfo/{lightid}/{activationkey}")
	public String getMoreInfo(@PathVariable("lightid") Long lightid,@PathVariable("activationkey") Long activationkey){
		return null;
	}
	
	@RequestMapping("/enabledisable/{lightid}/{actiontype}")
	public String enableDisable(@PathVariable("lightid") Long lightid,@PathVariable("actiontype") String actiontype){
		lightActionService.enableDisableLight(lightid,actiontype);
		return null;
	}
	
	@RequestMapping("/allight/{activationkey}")
	public String getAllLightInfo(@PathVariable("activationkey") String activationkey) throws JsonGenerationException, JsonMappingException, IOException{
		List<Light> lightList = lightActionService.getAllLight(activationkey);
		ObjectMapper oMapper = new ObjectMapper();
		 return oMapper.writeValueAsString(lightList);
	}
	
	@RequestMapping(value = "/lightinfo", method = RequestMethod.POST)
	public String createLightData(@RequestBody Light light) throws JsonProcessingException{
		String apikey = lightActionService.createlightdata(light);
		System.out.println("Add User "+apikey);
		return apikey;
	}
	
	@RequestMapping(value = "/createLight", method = RequestMethod.POST)
	public String createLight(@RequestBody Light light) throws JsonGenerationException, JsonMappingException, IOException{
		Light newLight = lightActionService.createLight(light);
		//System.out.println("Add User "+apikey);
		return new ObjectMapper().writeValueAsString(newLight);
	}
	
	@RequestMapping(value = "/createDevice", method = RequestMethod.POST)
	public String createDevice(@RequestBody Device device) throws JsonGenerationException, JsonMappingException, IOException{
		Device newDevice = lightActionService.createDevice(device);
		//System.out.println("Add User "+apikey);
		return new ObjectMapper().writeValueAsString(newDevice);
	}
	
	@RequestMapping("/allactkey")
	public String getAllActivationKey() throws JsonGenerationException, JsonMappingException, IOException{
		List<ActivationKey> actKeyList = lightActionService.getAllActivationKey();
		ObjectMapper oMapper = new ObjectMapper();
		 return oMapper.writeValueAsString(actKeyList);
	}
	
	@RequestMapping("/createactkey/{deviceid}")
	public String enableDisable(@PathVariable("lightid") Long deviceId){
		lightActionService.createActivationKey(deviceId);
		return null;
	}
}
