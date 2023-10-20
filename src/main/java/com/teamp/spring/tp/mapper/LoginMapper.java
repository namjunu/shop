package com.teamp.spring.tp.mapper;

import com.teamp.spring.tp.dto.UserInfo;

public interface LoginMapper {
	public void createID(UserInfo id);
 
	public int loginCheck(UserInfo id);

	public int checkID(String id);

	public UserInfo getInfo(String u_ID);

	public void editPw(UserInfo id);

	public void editInfo(UserInfo id);

	public void setPoint(UserInfo id);

	public void deleteMember(UserInfo id);
}

