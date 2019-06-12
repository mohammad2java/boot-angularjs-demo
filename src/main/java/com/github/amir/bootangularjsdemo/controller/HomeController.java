package com.github.amir.bootangularjsdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String getHomePage() {
		return "/app/view/index";
	}
	

}
