package com.tuespot.service;

import java.util.List;
import java.util.Map;

import com.tuespot.models.LogoModel;

public interface LogoService {

	public LogoModel addLogo(LogoModel SlideshowModel);

	public List<LogoModel> getLogo();

	public LogoModel getLogoBy(Long id);
	
	public LogoModel updateLogo(LogoModel SlideshowModel);
	
	public Map<String, String> deleteLogoBy(Long id);

}
