package com.nibodha.lgaas.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nibodha.lgaas.entity.User;

@Repository
public interface UserDao  extends JpaRepository<User, Long>  {

	public User findOneByUname(String name);
}
