package com.springsecurity.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Homecontoller {
	
	
	@GetMapping("/public")
	public String getpublic() {
		return "I am a public";
	}
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/admin")
	public String getadmin() {
		return "I am a admin";
	}
	@PreAuthorize("hasRole('NORMAL')")
	@GetMapping("/normal")
	public String getnormal() {
		return "I am a normal";
	}
	
	

}
