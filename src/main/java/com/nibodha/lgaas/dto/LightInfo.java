package com.nibodha.lgaas.dto;

public class LightInfo {
	private Long lightId;
	private String voltage;
	private String current;
	private String power;
	private String model;
	private String temp;
	public Long getLightId() {
		return lightId;
	}
	public void setLightId(Long lightId) {
		this.lightId = lightId;
	}
	public String getVoltage() {
		return voltage;
	}
	public void setVoltage(String voltage) {
		this.voltage = voltage;
	}
	public String getCurrent() {
		return current;
	}
	public void setCurrent(String current) {
		this.current = current;
	}
	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getTemp() {
		return temp;
	}
	public void setTemp(String temp) {
		this.temp = temp;
	}
	
	
	

}
