package com.tuespot.service;

import java.util.List;
import java.util.Map;

import com.tuespot.models.HomeWelcomeMessageModel;

public interface HomeWelcomeMessageService {

	public HomeWelcomeMessageModel addMessage(HomeWelcomeMessageModel carouselModel);

	public List<HomeWelcomeMessageModel> getMessage();

	public HomeWelcomeMessageModel getMessageBy(Long id);

	public HomeWelcomeMessageModel updateMessage(HomeWelcomeMessageModel carouselModel);

	public Map<String, String> deleteMessageBy(Long id);

}
