package com.itlize.springmc.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itlize.springmc.bean.User;

public interface UserRepository extends JpaRepository<User,Integer>{

	User findByUsername(String username);
}
