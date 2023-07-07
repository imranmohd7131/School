package com.tuespot.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tuespot.customExceptions.ValueNotFoundException;
import com.tuespot.entity.Carousel;
import com.tuespot.models.CarouselModel;
import com.tuespot.repository.CarouselRepository;
import com.tuespot.service.CarouselService;

@Service
public class CarouselServiceImpl implements CarouselService {

	@Autowired
	CarouselRepository repository;

	@Override
	public CarouselModel addCarousel(CarouselModel carouselModel) {
		Carousel carousel = new Carousel();
		carousel.setImgUrl(carouselModel.getImgUrl());
		carousel.setTitle(carouselModel.getTitle());
		Carousel save = this.repository.save(carousel);

		CarouselModel response = new CarouselModel();
		response.setId(save.getId());
		response.setImgUrl(save.getImgUrl());
		response.setTitle(save.getTitle());

		return response;
	}

	@Override
	public List<CarouselModel> getCarousel() {
		List<CarouselModel> arrayList = new ArrayList<>();
		List<Carousel> findAll = this.repository.findAll();
		findAll.forEach(data -> {
			CarouselModel response = new CarouselModel();
			response.setId(data.getId());
			response.setImgUrl(data.getImgUrl());
			response.setTitle(data.getTitle());
			arrayList.add(response);
		});
		return arrayList;
	}

	@Override 
	public CarouselModel getCarouselBy(Long id) {
		Carousel carousel = this.repository.findById(id)
				.orElseThrow(() -> new ValueNotFoundException("value not present with userId" + id));
		CarouselModel response = new CarouselModel();
		response.setId(carousel.getId());
		response.setImgUrl(carousel.getImgUrl());
		response.setTitle(carousel.getTitle());
		return response;
	}

	@Override
	public CarouselModel updateCarousel(CarouselModel carouselModel) {
		Carousel carousel = new Carousel();
		carousel.setId(carouselModel.getId());
		carousel.setImgUrl(carouselModel.getImgUrl());
		carousel.setTitle(carouselModel.getTitle());
		Carousel save = this.repository.save(carousel);

		CarouselModel response = new CarouselModel();
		response.setId(save.getId());
		response.setImgUrl(save.getImgUrl());
		response.setTitle(save.getTitle());
		return response;
	}

	@Override
	public Map<String, String> deleteCarouselBy(Long id) {
		Carousel carousel = this.repository.findById(id)
				.orElseThrow(() -> new ValueNotFoundException("value not present with userId" + id));
		this.repository.delete(carousel);

		Map<String, String> map = new HashMap<>();
		map.put("message", "User deleted successfully");
		return map;
	}

}
