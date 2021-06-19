package com.pc.product;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@RequestMapping("/")
	public String index() {
		return "Index page for PC Spring Boot Products project!";
	}

}
