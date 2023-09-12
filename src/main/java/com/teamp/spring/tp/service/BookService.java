package com.teamp.spring.tp.service;

import com.teamp.spring.tp.dto.BookInfo;

public interface BookService {
	String makeBook(String U_ID, String U_PW, BookInfo Info);
}