package com.tuespot.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.tuespot.entity.UserInfo;
import com.tuespot.repository.UserInfoRepository;

@Component
public class UserInfoService implements UserDetailsService {
	
	@Autowired
	private UserInfoRepository userInfoRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserInfo> findByUserName = this.userInfoRepository.findByUserName(username);
	//	findByUserName.map(UserInfoUserDetails)
		return null;
	}

}
