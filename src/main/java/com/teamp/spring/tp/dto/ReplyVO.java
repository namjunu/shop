package com.teamp.spring.tp.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class ReplyVO {
	private int r_no;				//리플 primary key
	private int b_no;				//연결된 글 번호
	private String r_content;		//리플 내용
	private String r_writer;		//리플 작성자
	private Timestamp r_writedate;	//리플 작성일
	private int r_likecount;		//리플 추천기능 구현?
}
