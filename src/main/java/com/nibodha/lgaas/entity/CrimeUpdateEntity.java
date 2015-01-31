package com.nibodha.lgaas.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class CrimeUpdateEntity {
	@Id
	@GeneratedValue(generator = "CrimeUpdateEntity")
	@GenericGenerator(name = "CrimeUpdateEntity", strategy = "seqhilo", parameters = {
			@Parameter(name = "max_lo", value = "1"),
			@Parameter(name = "sequence", value = "CrimeUpdateEntity_seq") })
	private Long id;
	private String lotitude;
	private String latitude;
	private String status;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLotitude() {
		return lotitude;
	}
	public void setLotitude(String lotitude) {
		this.lotitude = lotitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	

}
