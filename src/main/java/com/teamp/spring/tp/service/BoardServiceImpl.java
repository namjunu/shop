package com.teamp.spring.tp.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamp.spring.tp.dto.BoardVO;
import com.teamp.spring.tp.dto.PagingVO;
import com.teamp.spring.tp.dto.ReplyVO;
import com.teamp.spring.tp.mapper.BoardMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class BoardServiceImpl implements BoardService{

	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
	@Override
	public ArrayList<BoardVO> getList(PagingVO pvo) {
		log.info("ºñÁö´Ï½º °èÃþ===========");
		return mapper.getList(pvo);
	}
	
	@Override
	public int countBoardCategory(String category) {
		return mapper.countBoardCategory(category);
	}
	
	@Override
	public ArrayList<BoardVO> getListCategory(PagingVO pvo){
		return mapper.getListCategory(pvo);
	}
	
	@Override
	public int countBoard() {
		return mapper.countBoard();
	}
	
	@Override
	public BoardVO read(int no) {
		return mapper.read(no);
	}
	
	@Override
	public void upCount(int no) {
		mapper.upCount(no);
	}
	
	@Override
	public void write(BoardVO bvo) {
		mapper.write(bvo);
	}
	
	@Override
	public void delete(int no) {
		mapper.delete(no);
	}
	
	@Override
	public void edit(BoardVO bvo) {
		log.info("edit complete");
		mapper.edit(bvo);
	}
	
	
	//´ñ±Û
	@Override
	public void replyWrite(ReplyVO rvo) {
		mapper.replyWrite(rvo);
	}
	
	@Override
	public ArrayList<ReplyVO> replyList(int bno){
		return mapper.replyList(bno);
	}
	
	@Override
	public void replyDelete(int r_no) {
		mapper.replyDelete(r_no);
	}
	
}
