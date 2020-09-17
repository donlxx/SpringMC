package com.itlize.springmc.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itlize.springmc.Repository.UserRepository;
import com.itlize.springmc.bean.User;

@Service
public class UserService {
	@Autowired
	UserRepository up;
	
	public User getById(int id) {

		return up.findById(id).get();

	}
	
	public List<User> getAll() {
		System.out.println("users Service: ");
		return up.findAll();
	}
}
