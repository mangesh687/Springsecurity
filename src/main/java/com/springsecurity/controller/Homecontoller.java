package com.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Homecontoller {
	
	
	@GetMapping("/public")
	public String getpublic() {
		return "I am a public";
	}
	
	@GetMapping("/admin")
	public String getadmin() {
		return "I am a admin";
	}
	@GetMapping("/normal")
	public String getnormal() {
		return "I am a normal";
	}
	
	

}
