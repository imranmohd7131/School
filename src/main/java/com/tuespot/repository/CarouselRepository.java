package com.tuespot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tuespot.entity.Carousel;

@Repository
public interface CarouselRepository extends JpaRepository<Carousel, Long>{

}
