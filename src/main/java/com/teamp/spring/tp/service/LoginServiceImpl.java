package com.teamp.spring.tp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamp.spring.tp.dto.UserInfo;

import com.teamp.spring.tp.mapper.LoginMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class LoginServiceImpl implements LoginService{
	@Setter(onMethod_ = @Autowired)
	private LoginMapper mapper;	
	
	
	@Override
	public void createID(UserInfo id) {
		mapper.createID(id);
	}	
}