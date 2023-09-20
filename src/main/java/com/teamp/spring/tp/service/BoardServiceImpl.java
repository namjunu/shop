package com.teamp.spring.tp.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamp.spring.tp.dto.BoardVO;
import com.teamp.spring.tp.dto.PagingVO;
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
		log.info("비지니스 계층===========");
		return mapper.getList(pvo);
	}
	
	@Override
	public ArrayList(BoardVO) getListCategory(PagingVO pvo, String category){
		return mapper.getListCategory(pvo, category);
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
}
