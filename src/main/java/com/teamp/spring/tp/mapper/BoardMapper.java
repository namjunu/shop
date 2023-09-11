package com.teamp.spring.tp.mapper;

import java.util.ArrayList;

import com.teamp.spring.tp.dto.BoardVO;

public interface BoardMapper {
	public ArrayList<BoardVO> getList();
	public BoardVO read(int no);
}
