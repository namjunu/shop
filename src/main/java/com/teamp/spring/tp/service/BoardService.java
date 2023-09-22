package com.teamp.spring.tp.service;

import java.util.ArrayList;

import com.teamp.spring.tp.dto.BoardVO;
import com.teamp.spring.tp.dto.PagingVO;
import com.teamp.spring.tp.dto.ReplyVO;


public interface BoardService {
	public int countBoard();
	public ArrayList<BoardVO> getList(PagingVO pvo);
	public int countBoardCategory(String category);
	public ArrayList<BoardVO> getListCategory(PagingVO pvo);
	public BoardVO read(int no);
	public void upCount(int no);
	public void write(BoardVO bvo);
	public void delete(int no);
	public void edit(BoardVO bvo);
	public void replyWrite(ReplyVO rvo);
	public ArrayList<ReplyVO> replyList(int bno);
}
