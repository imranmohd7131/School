package com.tuespot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tuespot.entity.Logo;

@Repository
public interface LogoRepository extends JpaRepository<Logo, Long>{
	
	

}
