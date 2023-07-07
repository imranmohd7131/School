package com.tuespot.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tuespot.models.LogoModel;
import com.tuespot.service.LogoService;

@RestController
@RequestMapping("/logo")
public class LogoController {

	@Autowired
	private LogoService service;

	@PostMapping("/saveLogo")
	public ResponseEntity<?> addLogo(@RequestBody LogoModel model) {
		LogoModel addLogo = this.service.addLogo(model);
		return new ResponseEntity<LogoModel>(addLogo, HttpStatus.CREATED);
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/get")
	public ResponseEntity<?> getLogo() {
		List<LogoModel> logo = this.service.getLogo();
		return new ResponseEntity<List<LogoModel>>(logo, HttpStatus.OK);
	}

	@GetMapping("/getLogoBy")
	public ResponseEntity<?> gettLogoBy(@RequestParam("id") Long id) {
		LogoModel logoBy = this.service.getLogoBy(id);
		return new ResponseEntity<LogoModel>(logoBy, HttpStatus.OK);
	}

	@PutMapping("/updateLogo")
	public ResponseEntity<?> updatetLogo(@RequestBody LogoModel model) {
		LogoModel updateLogo = this.service.updateLogo(model);
		return new ResponseEntity<LogoModel>(updateLogo, HttpStatus.CREATED);
	}

	@DeleteMapping("/deleteLogo")
	public ResponseEntity<?> deletetLogo(@RequestParam("id") Long id) {
		Map<String, String> deleteLogoBy = this.service.deleteLogoBy(id);
		return new ResponseEntity<Map<String, String>>(deleteLogoBy, HttpStatus.OK);
	}

}
