package com.teamp.spring.tp.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class UserInfo {
	private String U_ID; //받아오는 유저 id 
	private String U_PW; //받아오는 유저 pw
	private int U_NO;	//유저의 고유 번호
	private String U_NAME;	//유저의 이름
	private int U_POINT;	//유저가 가지고 있는 포인트
	private String U_ADDRESS;	//유저의 주소
	private String U_EMAIL;	//유저의 이메일
	private String U_PHONE;	//유저의 전화번호
	private Timestamp U_TIMESTAMP;	//유저의 마지막 접속기록
}
