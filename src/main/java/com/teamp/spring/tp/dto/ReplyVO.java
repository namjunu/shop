package com.teamp.spring.tp.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class ReplyVO {
	private int r_no;				
	private int b_no;				
	private String r_content;		
	private String r_writer;		
	private Timestamp r_writedate;
	private int r_likecount;	
}
