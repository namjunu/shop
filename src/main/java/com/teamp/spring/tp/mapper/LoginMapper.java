package com.teamp.spring.tp.mapper;

import com.teamp.spring.tp.dto.UserInfo;

public interface LoginMapper {
	public void createID(UserInfo id);
	public boolean LoginTest(String U_ID,String U_PW);
}