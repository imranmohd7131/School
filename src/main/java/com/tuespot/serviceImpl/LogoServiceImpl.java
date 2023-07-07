package com.tuespot.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tuespot.customExceptions.ValueNotFoundException;
import com.tuespot.entity.Logo;
import com.tuespot.models.LogoModel;
import com.tuespot.repository.LogoRepository;
import com.tuespot.service.LogoService;

@Service
public class LogoServiceImpl implements LogoService {

	@Autowired
	LogoRepository repository;

	@Override
	public LogoModel addLogo(LogoModel model) {
		Logo slideshow = new Logo();
		slideshow.setImgUrl(model.getImgUrl());
		slideshow.setTitle(model.getTitle());
		Logo save = this.repository.save(slideshow);

		LogoModel response = new LogoModel();
		response.setId(save.getId());
		response.setImgUrl(save.getImgUrl());
		response.setTitle(save.getTitle());
		return response;
	}

	@Override
	public List<LogoModel> getLogo() {
		List<LogoModel> arrayList = new ArrayList<>();
		List<Logo> findAll = this.repository.findAll();
		findAll.forEach(data -> {
			LogoModel response = new LogoModel();
			response.setId(data.getId());
			response.setImgUrl(data.getImgUrl());
			response.setTitle(data.getTitle());
			arrayList.add(response);
		});
		return arrayList;
	}

	@Override
	public LogoModel getLogoBy(Long id) {
		Logo slideshow = this.repository.findById(id)
				.orElseThrow(() -> new ValueNotFoundException("value not present with userId" + id));
		LogoModel response = new LogoModel();
		response.setId(slideshow.getId());
		response.setImgUrl(slideshow.getImgUrl());
		response.setTitle(slideshow.getTitle());
		return response;
	}

	@Override
	public LogoModel updateLogo(LogoModel model) {
		Logo slideshow = new Logo();
		slideshow.setId(model.getId());
		slideshow.setImgUrl(model.getImgUrl());
		slideshow.setTitle(model.getTitle());
		Logo save = this.repository.save(slideshow);

		LogoModel response = new LogoModel();
		response.setId(save.getId());
		response.setImgUrl(save.getImgUrl());
		response.setTitle(save.getTitle());
		return response;
	}

	@Override
	public Map<String, String> deleteLogoBy(Long id) {
		Logo slideshow = this.repository.findById(id)
				.orElseThrow(() -> new ValueNotFoundException("value not present with userId" + id));
		this.repository.delete(slideshow);

		Map<String, String> map = new HashMap<>();
		map.put("message", "User deleted successfully");
		return map;
	}
}
