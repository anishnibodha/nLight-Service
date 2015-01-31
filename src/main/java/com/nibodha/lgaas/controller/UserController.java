package com.nibodha.lgaas.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
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
import com.nibodha.lgaas.entity.Device;
import com.nibodha.lgaas.entity.User;
import com.nibodha.lgaas.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	public UserService userService;
	
	@RequestMapping(value = "/getkey/{username}")
	public String checkUser(@PathVariable("username") String username){
		String apikey = userService.getActivattionKey(username);
		System.out.println("Check User "+apikey);
		return apikey;
	}
	
	@RequestMapping(value = "/setkey/{username}")
	public String addUser(@PathVariable("username") String username){
		String apikey = userService.addUser(username);
		System.out.println("Add User "+apikey);
		return apikey;
	}
	
	@RequestMapping(value = "/registeruser", method = RequestMethod.POST)
	public String regiserUser(@RequestBody User user) throws JsonProcessingException{
		String apikey = userService.registerUser(user);
		System.out.println("Add User "+apikey);
		return apikey;
	}
	
	@RequestMapping(value = "/login/{uname}/{pass}")
	public String loginUser(@PathVariable("uname") String uname, @PathVariable("pass") String pass) throws JsonProcessingException{
		System.out.println("Got User");
		String result = userService.loginUser(uname, pass);
		System.out.println("Add User "+result);
		return result;
	}
	
	@RequestMapping(value = "/registerdevice/{devicename}/{deviceip}/{deviceport}/{username}")
	public String registerDevice(@PathVariable("devicename") String devicename, @PathVariable("deviceip") String deviceip, @PathVariable("deviceport") String deviceport, @PathVariable("username") String username){
		String apikey = userService.regesterDevice(devicename,deviceip,deviceport,username);
		System.out.println("Add User "+apikey);
		return apikey;
	}
	
	@RequestMapping(value = "/getdevices/{username}")
	public String getDevices(@PathVariable("username") String username) throws JsonGenerationException, JsonMappingException, IOException{
		List<Device> deviceList = userService.getDevices(username);
		ObjectMapper oMapper = new ObjectMapper();
		return oMapper.writeValueAsString(deviceList);
	}
	
	@RequestMapping(value = "/getdevices")
	public String getAllDevices() throws JsonGenerationException, JsonMappingException, IOException{
		List<Device> deviceList = userService.getDevices();
		ObjectMapper oMapper = new ObjectMapper();
		return oMapper.writeValueAsString(deviceList);
	}
	

	
	@RequestMapping(value = "/getactkey/{username}")
	public String getApiKey(@PathVariable("username") String username) throws JsonGenerationException, JsonMappingException, IOException{
		User user = userService.getUser(username);
		ObjectMapper oMapper = new ObjectMapper();
		
		return oMapper.writeValueAsString(user);
	}
	
	

}
