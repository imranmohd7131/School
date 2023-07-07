package com.tuespot.models;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HomeWelcomeMessageModel {

	private Long id;
	private String title;
	private String description;
	private Date createdOn;
	private Date modifiedOn;

}
