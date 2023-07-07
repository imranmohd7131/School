package com.tuespot.service;

import java.util.List;
import java.util.Map;

import com.tuespot.models.CarouselModel;

public interface CarouselService {
	
	public CarouselModel addCarousel(CarouselModel carouselModel);

	public List<CarouselModel> getCarousel();

	public CarouselModel getCarouselBy(Long id);
	
	public CarouselModel updateCarousel(CarouselModel carouselModel);
	
	public Map<String, String> deleteCarouselBy(Long id);

}
