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

import com.tuespot.models.CarouselModel;
import com.tuespot.service.CarouselService;

@RestController
@RequestMapping("/carousel")
public class CarouselController {

	@Autowired
	private CarouselService carouselService;

	@PostMapping("/saveCarousel")
	public ResponseEntity<?> addSlider(@RequestBody CarouselModel model) {
		CarouselModel addCarousel = this.carouselService.addCarousel(model);
		return new ResponseEntity<CarouselModel>(addCarousel, HttpStatus.CREATED);
	}

	@PutMapping("/updateCarousel")
	public ResponseEntity<?> updateCarousel(@RequestBody CarouselModel model) {
		CarouselModel updateCarousel = this.carouselService.updateCarousel(model);
		return new ResponseEntity<CarouselModel>(updateCarousel, HttpStatus.CREATED);
	}

	@GetMapping("/get")
	public ResponseEntity<?> getSlider() {
		List<CarouselModel> carousel = this.carouselService.getCarousel();
		return new ResponseEntity<List<CarouselModel>>(carousel, HttpStatus.OK);
	}

	@GetMapping("/getCarouselBy")
	public ResponseEntity<?> getCarouselBy(@RequestParam("id") Long id) {
		CarouselModel carouselBy = this.carouselService.getCarouselBy(id);
		return new ResponseEntity<CarouselModel>(carouselBy, HttpStatus.OK);
	}

	@DeleteMapping("/deleteCarouselBy")
	public ResponseEntity<?> deleteCarouselBy(@RequestParam("id") Long id) {
		Map<String, String> deleteCarouselBy = this.carouselService.deleteCarouselBy(id);
		return new ResponseEntity<Map<String, String>>(deleteCarouselBy, HttpStatus.OK);
	}
}
