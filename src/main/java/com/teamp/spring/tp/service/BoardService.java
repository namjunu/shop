package com.teamp.spring.tp.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.teamp.spring.tp.dto.BoardVO;
import com.teamp.spring.tp.dto.PagingVO;
import com.teamp.spring.tp.dto.ReplyVO;


public interface BoardService {
	public int countBoard();
	public ArrayList<BoardVO> getList(PagingVO pvo);
	public int countBoardSearch(String search, String searchType);
	public int countBoardCategory(String category);
	public ArrayList<BoardVO> getListSearch(PagingVO pvo);
	public ArrayList<BoardVO> getListCategory(PagingVO pvo);
	public BoardVO read(int no);
	public void upCount(int no);
	public void write(BoardVO bvo);
	public void delete(int no);
	public void edit(BoardVO bvo);
	public void replyWrite(ReplyVO rvo);
	public ArrayList<ReplyVO> replyList(int bno);
	public void replyDelete(int r_no);
	
	/* 추천기능 */
	//추천여부 확인
	public Boolean likeCheck(@Param("bno") int bno, @Param("uno") int uno);
	//추천버튼이 눌릴경우
	public void likeBoard(@Param("bno") int bno, @Param("uno") int uno);
}
