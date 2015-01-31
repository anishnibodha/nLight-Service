package com.nibodha.lgaas.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nibodha.lgaas.entity.ActivationKey;
import com.nibodha.lgaas.entity.Device;

public interface ActivationKeyDao   extends JpaRepository<ActivationKey, Long>  {

}
