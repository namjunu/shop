package com.teamp.spring.tp.mapper;

import com.teamp.spring.tp.dto.UserInfo;

public interface LoginMapper {
	public void createID(UserInfo id);

	public int loginCheck(UserInfo id);

	public int checkID(String id);
}
