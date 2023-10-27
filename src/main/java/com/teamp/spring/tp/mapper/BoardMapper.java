package com.teamp.spring.tp.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.teamp.spring.tp.dto.BoardVO;
import com.teamp.spring.tp.dto.PagingVO;
import com.teamp.spring.tp.dto.ReplyVO;

public interface BoardMapper {
	
	/* 글 */
	//게시판 글 수 세기
	public int countBoard();
	//게시판 글 전부 가져오기
	public ArrayList<BoardVO> getList(PagingVO pvo);
	//게시판 검색한것에 해당하는 글 세기
	public int countBoardSearch(@Param("search")String search, @Param("searchType")String searchType);
	//게시판 카테고리에 해당하는 글 세기
	public int countBoardCategory(@Param("category")String category);
	//게시판 내가 쓴 글 세기
	public int countBoardMy(@Param("writer")String u_id);
	//게시판 검색한것에 해당하는 글 가져오기
	public ArrayList<BoardVO> getListSearch(PagingVO pvo);
	//게시판 카테고리에 해당하는 글 가져오기
	public ArrayList<BoardVO> getListCategory(PagingVO pvo);
	//게시판 내가 쓴 글 가져오기
	public ArrayList<BoardVO> getListMy(@Param("pvo")PagingVO pvo, @Param("writer")String u_id);
	//게시판 글 가져오기
	public BoardVO read(int no);
	//게시판 조회수 증가
	public void upCount(int no);
	//게시판 글 작성
	public void write(BoardVO bvo);
	//게시판 글 삭제
	public void delete(int no);
	//게시판 글 수정
	public void edit(BoardVO bvo);
	
	/* 댓글 */
	//게시판 댓글작성
	public void replyWrite(ReplyVO rvo);
	//게시판 댓글리스트 가져오기
	public ArrayList<ReplyVO> replyList(int bno);
	//게시판 댓글삭제
	public void replyDelete(int r_no);
	
	/* 추천 */
	//추천을 누른적 있는지 확인(추천을 누른상태면 true 취소한상태면 false 누른적 없다면 null)
	public Boolean likeCheck(@Param ("bno") int bno,@Param ("uno") int uno);
	//likes테이블에 값 생성
	public void insertLike(@Param ("bno") int bno,@Param ("uno") int uno);
	//board에 like값 1 증가
	public void updateLike(@Param ("bno") int bno);
	//board에 like값 1 갑소
	public void updateLikeCancel(@Param ("bno") int bno);
	//likes테이블에 likecheck값 false로 변경
	public void updateLikeCheckCancel(@Param ("bno") int bno,@Param ("uno") int uno);
	//likes테이블에 likecheck값 true로 변경
	public void updateLikeCheck(@Param ("bno") int bno,@Param ("uno") int uno);
}
