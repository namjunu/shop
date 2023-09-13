package com.teamp.spring.tp.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.teamp.spring.tp.dto.BoardVO;


public interface BoardService {
	public ArrayList<BoardVO> getList(int currentPage);
	public BoardVO read(int no);
	public void write(BoardVO bvo);
}
