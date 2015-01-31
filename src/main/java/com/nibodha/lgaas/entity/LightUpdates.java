package com.nibodha.lgaas.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class LightUpdates extends BaseEntity{
	@Id
	private Long id;
	private Long lightId;
	private String currentTemperature;
	private String currentStatus;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getLightId() {
		return lightId;
	}
	public void setLightId(Long lightId) {
		this.lightId = lightId;
	}
	public String getCurrentTemperature() {
		return currentTemperature;
	}
	public void setCurrentTemperature(String currentTemperature) {
		this.currentTemperature = currentTemperature;
	}
	public String getCurrentStatus() {
		return currentStatus;
	}
	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}
	

}
