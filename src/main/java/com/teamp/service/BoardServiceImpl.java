package com.teamp.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamp.mapper.BoardMapper;
import com.teamp.spring.dto.BoardVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class BoardServiceImpl implements BoardService{

	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
	@Override
	public ArrayList<BoardVO> getList() {
		log.info("비지니스 계층===========");
		return mapper.getList();
	}
}
