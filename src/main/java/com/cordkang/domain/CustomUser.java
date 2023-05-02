package com.cordkang.domain;

import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;

public class CustomUser extends User{
	@Getter
	private MemberVO member;
	
	// 생성자의 첫 줄은 반드시 this 나 super 가 있어야함.
	public CustomUser(MemberVO vo){
		
		super(vo.getUserid(), vo.getUserpw(), vo.getAuths().stream().map(auth 
				-> new SimpleGrantedAuthority(auth.getAuth())).collect(Collectors.toSet()));
	    member = vo;
	}

}
