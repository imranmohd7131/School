package com.tuespot.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tuespot.customExceptions.ValueNotFoundException;
import com.tuespot.entity.HomeWelcomeMessage;
import com.tuespot.models.HomeWelcomeMessageModel;
import com.tuespot.repository.HomeWelcomeMessageRepository;
import com.tuespot.service.HomeWelcomeMessageService;

@Service
public class HomeWelcomeMessageServiceImpl implements HomeWelcomeMessageService {

	@Autowired
	HomeWelcomeMessageRepository repository;

	@Override
	public HomeWelcomeMessageModel addMessage(HomeWelcomeMessageModel model) {
		HomeWelcomeMessage homeWelcomeMessage = new HomeWelcomeMessage();
		homeWelcomeMessage.setTitle(model.getTitle());
		homeWelcomeMessage.setDescription(model.getDescription());
		homeWelcomeMessage.setCreatedOn(model.getCreatedOn());
		homeWelcomeMessage.setModifiedOn(model.getModifiedOn());
		HomeWelcomeMessage save = this.repository.save(homeWelcomeMessage);

		HomeWelcomeMessageModel response = new HomeWelcomeMessageModel();
		response.setId(save.getId());
		response.setTitle(save.getTitle());
		response.setDescription(save.getDescription());
		response.setCreatedOn(save.getCreatedOn());
		response.setModifiedOn(save.getModifiedOn());

		return response;
	}

	@Override
	public List<HomeWelcomeMessageModel> getMessage() {
		List<HomeWelcomeMessageModel> arrayList = new ArrayList<>();
		List<HomeWelcomeMessage> findAll = this.repository.findAll();
		findAll.forEach(data -> {
			HomeWelcomeMessageModel response = new HomeWelcomeMessageModel();
			response.setId(data.getId());
			response.setTitle(data.getTitle());
			response.setDescription(data.getDescription());
			response.setCreatedOn(data.getCreatedOn());
			response.setModifiedOn(data.getModifiedOn());
			arrayList.add(response);
		});
		return arrayList;
	}

	@Override
	public HomeWelcomeMessageModel getMessageBy(Long id) {
		HomeWelcomeMessage find = this.repository.findById(id)
				.orElseThrow(() -> new ValueNotFoundException("value not present with userId" + id));
		HomeWelcomeMessageModel response = new HomeWelcomeMessageModel();
		response.setId(find.getId());
		response.setTitle(find.getTitle());
		response.setDescription(find.getDescription());
		response.setCreatedOn(find.getCreatedOn());
		response.setModifiedOn(find.getModifiedOn());
		return response;
	}

	@Override
	public HomeWelcomeMessageModel updateMessage(HomeWelcomeMessageModel model) {
		HomeWelcomeMessage homeWelcomeMessage = new HomeWelcomeMessage();
		homeWelcomeMessage.setId(model.getId());
		homeWelcomeMessage.setTitle(model.getTitle());
		homeWelcomeMessage.setDescription(model.getDescription());
		homeWelcomeMessage.setCreatedOn(model.getCreatedOn());
		homeWelcomeMessage.setModifiedOn(model.getModifiedOn());
		HomeWelcomeMessage save = this.repository.save(homeWelcomeMessage);

		HomeWelcomeMessageModel response = new HomeWelcomeMessageModel();
		response.setId(save.getId());
		response.setTitle(save.getTitle());
		response.setDescription(save.getDescription());
		response.setCreatedOn(save.getCreatedOn());
		response.setModifiedOn(save.getModifiedOn());

		return response;
	}

	@Override
	public Map<String, String> deleteMessageBy(Long id) {
		HomeWelcomeMessage homeWelcomeMessage = this.repository.findById(id)
				.orElseThrow(() -> new ValueNotFoundException("value not present with userId" + id));
		this.repository.delete(homeWelcomeMessage);

		Map<String, String> map = new HashMap<>();
		map.put("message", "User deleted successfully");
		return map;
	}

}
