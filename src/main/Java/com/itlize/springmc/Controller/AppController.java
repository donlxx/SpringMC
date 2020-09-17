package com.itlize.springmc.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class AppController {

	@GetMapping("/{value}")
	public String appTest(@PathVariable String value) {
		
		return value;
	}
	
}
