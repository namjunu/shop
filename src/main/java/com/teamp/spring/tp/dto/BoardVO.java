package com.teamp.spring.tp.dto;
import java.sql.Timestamp;

import lombok.Data;

@Data
public class BoardVO {
	private int no;
	private String title;
	private String content;
	private String writer;
	private Timestamp writedate;
	private int readcount;
	private String category;
}