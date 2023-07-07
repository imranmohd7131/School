package com.tuespot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
public class SecurityController {
	
	//@PreAuthorize("hasAuthorize('NORMAL')")
	@GetMapping("/normal")
	public ResponseEntity<String> normalUser() {
		return new ResponseEntity<String>("Yes,I am normal user", HttpStatus.OK);
	}
	
	
	//@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/admin")
	public ResponseEntity<String> adminUser() {
		return new ResponseEntity<String>("Yes,I am admin user", HttpStatus.OK);
	}
	
	@GetMapping("/pub")
	public ResponseEntity<String> pubUser() {
		return new ResponseEntity<String>("Yes,I am pu user", HttpStatus.OK);
	}

}
