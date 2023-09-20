package com.teamp.spring.tp.dto;
import java.sql.Timestamp;

import lombok.Data;

@Data
public class BoardVO {
	private int b_no;
	private String b_title;
	private String b_content;
	private String b_writer;
	private Timestamp b_writedate;
	private int b_likecount;
	private int b_readcount;
	private String b_category;
}