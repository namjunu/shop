package com.teamp.spring.tp.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.teamp.spring.tp.dto.BoardVO;
import com.teamp.spring.tp.dto.PagingVO;

public interface BoardMapper {
	public int countBoard();
	public ArrayList<BoardVO> getList(PagingVO pvo);
	public int countBoardCategory(String category);
	public ArrayList<BoardVO> getListCategory(PagingVO pvo);
	public BoardVO read(int no);
	public void upCount(int no);
	public void write(BoardVO bvo);
	public void delete(int no);
	public void edit(BoardVO bvo);
}
