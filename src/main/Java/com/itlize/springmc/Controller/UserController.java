package com.itlize.springmc.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itlize.springmc.Service.UserService;
import com.itlize.springmc.bean.User;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService us;
	
	@GetMapping
	public List<User> getAll() {
		System.out.println("/users: ");
		return us.getAll();
	}
	@GetMapping("/{id}")
	public User getById(@PathVariable int id) {
		return us.getById(id); 
	}
}
