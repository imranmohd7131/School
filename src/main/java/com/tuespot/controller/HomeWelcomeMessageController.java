package com.tuespot.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tuespot.models.HomeWelcomeMessageModel;
import com.tuespot.service.HomeWelcomeMessageService;

@RestController
@RequestMapping("/welcomeMessage")
public class HomeWelcomeMessageController {

	@Autowired
	private HomeWelcomeMessageService homeWelcomeMessageService;

	@PostMapping("/addMessage")
	public ResponseEntity<?> addMessage(@RequestBody HomeWelcomeMessageModel model) {
		HomeWelcomeMessageModel addMessage = this.homeWelcomeMessageService.addMessage(model);
		return new ResponseEntity<HomeWelcomeMessageModel>(addMessage, HttpStatus.CREATED);
	}

	@PutMapping("/updateMessage")
	public ResponseEntity<?> updateMessage(@RequestBody HomeWelcomeMessageModel model) {
		HomeWelcomeMessageModel updateMessage = this.homeWelcomeMessageService.updateMessage(model);
		return new ResponseEntity<HomeWelcomeMessageModel>(updateMessage, HttpStatus.CREATED);
	}

	@GetMapping("/getMessage")
	public ResponseEntity<?> getMessage() {
		List<HomeWelcomeMessageModel> message = this.homeWelcomeMessageService.getMessage();
		return new ResponseEntity<List<HomeWelcomeMessageModel>>(message, HttpStatus.OK);
	}

	@GetMapping("/getMessageBy")
	public ResponseEntity<?> getMessageBy(@RequestParam("id") Long id) {
		HomeWelcomeMessageModel messageBy = this.homeWelcomeMessageService.getMessageBy(id);
		return new ResponseEntity<HomeWelcomeMessageModel>(messageBy, HttpStatus.OK);
	}

	@DeleteMapping("/deleteMessageBy")
	public ResponseEntity<?> deleteMessageBy(@RequestParam("id") Long id) {
		Map<String, String> deleteMessageBy = this.homeWelcomeMessageService.deleteMessageBy(id);
		return new ResponseEntity<Map<String, String>>(deleteMessageBy, HttpStatus.OK);
	}

}
