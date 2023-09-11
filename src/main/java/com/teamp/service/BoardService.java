package com.teamp.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.teamp.spring.dto.BoardVO;

@Service
public interface BoardService {
	public ArrayList<BoardVO> getList();
}
