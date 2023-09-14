package com.teamp.spring.tp.mapper;

import java.util.ArrayList;

import com.teamp.spring.tp.dto.BoardVO;

public interface BoardMapper {
	public ArrayList<BoardVO> getList(int limitIndex);
	public BoardVO read(int no);
	public void upCount(int no);
	public void write(BoardVO bvo);
	public void delete(int no);
	public void edit(BoardVO bvo);
}
