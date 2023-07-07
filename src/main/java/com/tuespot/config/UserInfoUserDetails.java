package com.tuespot.config;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.tuespot.entity.UserInfo;

public class UserInfoUserDetails implements UserDetails{
	
	
	private String name;
	private String password;
	private List<GrantedAuthority> authorities; 
	
	public UserInfoUserDetails(UserInfo info) {
		this.name = info.getUserName();
		this.password = info.getPassword();
//		this.authorities = Arrays.stream(info.getRoles().split(","))
//				.map(SimpleGrantedAuthority)
//				.collect(Collectors.toList());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return name;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
