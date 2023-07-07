package com.tuespot.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarouselModel {
	
	private Long id;
	private String title;
	private String imgUrl;

}
