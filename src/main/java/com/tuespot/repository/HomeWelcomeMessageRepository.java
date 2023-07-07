package com.tuespot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tuespot.entity.HomeWelcomeMessage;

public interface HomeWelcomeMessageRepository extends JpaRepository<HomeWelcomeMessage, Long>{

}
