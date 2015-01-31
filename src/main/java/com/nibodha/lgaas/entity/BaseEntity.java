package com.nibodha.lgaas.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class BaseEntity implements Serializable {
	
	private Timestamp createdTime;
	  private Timestamp updatedTime;

	  @PrePersist
	  protected void onCreate() {
		  createdTime = new Timestamp(Calendar.getInstance().getTimeInMillis());
	  }

	  @PreUpdate
	  protected void onUpdate() {
		  updatedTime = new Timestamp(Calendar.getInstance().getTimeInMillis());
	  }

	public Timestamp getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}

	public Timestamp getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Timestamp updatedTime) {
		this.updatedTime = updatedTime;
	}

}
