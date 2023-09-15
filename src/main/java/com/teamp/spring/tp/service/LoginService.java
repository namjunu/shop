package com.teamp.spring.tp.service;

import com.teamp.spring.tp.dto.UserInfo;

public interface LoginService {
	public void createID(UserInfo id);

	public int loginCheck(UserInfo id);
	
	public int checkID(String U_ID); 
	
	public UserInfo getInfo(String U_ID);
}
