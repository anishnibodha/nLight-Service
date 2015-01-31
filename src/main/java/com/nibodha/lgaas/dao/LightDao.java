package com.nibodha.lgaas.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nibodha.lgaas.entity.Device;
import com.nibodha.lgaas.entity.Light;
@Repository
public interface LightDao  extends JpaRepository<Light, Long>  {

}
