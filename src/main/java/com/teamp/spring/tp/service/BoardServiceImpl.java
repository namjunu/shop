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
		return mapper.getList(pvo);
	}
	
	@Override
	public int countBoardSearch(String search, String searchType) {
		System.out.println("count board search = "+search);
		System.out.println("count board searchType = "+searchType);
		return mapper.countBoardSearch(search, searchType);
	}
	
	@Override
	public int countBoardCategory(String category) {
		return mapper.countBoardCategory(category);
	}
	
	@Override
	public ArrayList<BoardVO> getListSearch(PagingVO pvo){
		System.out.println("get list search = "+pvo.getSearch());
		System.out.println("get list searchType = "+pvo.getSearchType());
		return mapper.getListSearch(pvo);
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
	
	
	/* 추천기능 */
	//추천여부 확인
	@Override
	public Boolean likeCheck(int bno, int uno) {
		return mapper.likeCheck(bno, uno);
	}
	//추천버튼이 눌릴경우
	@Override
	public void likeBoard(int bno, int uno) {
		//기록이 있는지 확인
		Boolean check = mapper.likeCheck(bno, uno);
		System.out.println(check);
		//check값이 null이면 추천한적 없는상태 -> table에 값 생성 후 추천
		if(check == null) {
			mapper.insertLike(bno, uno);
			mapper.updateLike(bno);
		}
		//check값이 false이면 이미 추천했던 글이고 현재 추천취소상태 -> 추천
		else if(check == false) {
			mapper.updateLike(bno);
			mapper.updateLikeCheck(bno, uno);
		}
		//check값이 true이면 이미 추천했던 글이고 현재 추천한상태 -> 추천취소
		else if(check == true){
			mapper.updateLikeCancel(bno);
			mapper.updateLikeCheckCancel(bno, uno);
		}
	}
	
}
