package com.tuespot.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogoModel {

	private Long id;
	private String title;
	private String imgUrl;

}
