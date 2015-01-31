package com.nibodha.lgaas.service;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nibodha.lgaas.dao.DeviceDao;
import com.nibodha.lgaas.dao.UserDao;
import com.nibodha.lgaas.dto.Result;
import com.nibodha.lgaas.entity.Device;
import com.nibodha.lgaas.entity.User;
@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private DeviceDao deviceDao;
	
	private SecureRandom random = new SecureRandom();
	
	public String getActivattionKey(String username){
		String apiKey;
		User user = userDao.findOneByUname(username);
		if(user != null){
			apiKey = user.getApikey();
		}else{
			apiKey = "nokey";
		}
		return apiKey;	
	}

	public String addUser(String username) {
		// TODO Auto-generated method stub
		String apiKey = new BigInteger(130, random).toString(32);
		User user = new User();
		user.setApikey(apiKey);
		user.setUname(username);
		user.setUserSource("facebook");
		userDao.save(user);
		return apiKey;
	}

	public String registerUser(User user) throws JsonProcessingException {
		// TODO Auto-generated method stub
		String apiKey = new BigInteger(130, random).toString(32);
		user.setApikey(apiKey);
		userDao.save(user);
		Result resulto = new Result();
		resulto.setResult(apiKey);
		return new ObjectMapper().writeValueAsString(resulto);
	}

	public String loginUser(String username, String password) throws JsonProcessingException {
		// TODO Auto-generated method stub
		String result;
		User user = userDao.findOneByUname(username);
		if(user != null && user.getPassword().equalsIgnoreCase(password)){
			result = "success";
		}else{
			result = "fail";
		}
		Result resulto = new Result();
		resulto.setAddOne(user.getApikey());
		resulto.setResult(result);
		return new ObjectMapper().writeValueAsString(resulto);
	}

	public String regesterDevice(String devicename, String deviceip,
			String deviceport, String username) {
		// TODO Auto-generated method stub
		User user = userDao.findOneByUname(username);
		Device device = new Device();
		device.setUser(user);
		device.setPort(deviceport);
		device.setIpAddress(deviceip);
		deviceDao.save(device);
		return device.getId().toString();
	}

	public List<Device> getDevices(String username) {
		// TODO Auto-generated method stub
		User user = userDao.findOneByUname(username);
		List<Device> allDevice = deviceDao.findAll();
		List<Device> filteredList =new ArrayList<Device>();
		for(Device device : allDevice){
			if(device.getUser().getUname().equalsIgnoreCase(username)){
				filteredList.add(device);
			}
		}
		return allDevice;
	}
	
	public List<Device> getDevices() {
		// TODO Auto-generated method stub
		List<Device> allDevice = deviceDao.findAll();
		/*List<Device> filteredList =new ArrayList<Device>();
		for(Device device : allDevice){
			if(device.getUser().getUname().equalsIgnoreCase(username)){
				filteredList.add(device);
			}
		}*/
		return allDevice;
	}

	public User getUser(String username) {
		// TODO Auto-generated method stub
		User user = userDao.findOneByUname(username);
		return user;
	}

}
