package com.teamp.spring.tp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.teamp.spring.tp.dto.BoardVO;
import com.teamp.spring.tp.dto.PagingVO;
import com.teamp.spring.tp.dto.ReplyVO;
import com.teamp.spring.tp.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/board/*") 
@AllArgsConstructor 
@Controller
public class BoardController {


	private BoardService service;

	@GetMapping("/sessiontest")
	public String sessiontest(HttpSession session, @RequestParam(value = "id", defaultValue = "testid") String id) {
		session.setAttribute("U_ID", id);
		return "redirect:/board/BoardList";
	}
	//세션 만료시 홈이나 로그인으로 돌아가도록 변경해야함
	@GetMapping("/BoardList")
	public void BoardList(HttpSession session,
							@RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
							@RequestParam(value = "category", defaultValue = "main") String category,
							@RequestParam(value = "search", defaultValue = "") String search,
							@RequestParam(value = "searchType", defaultValue = "") String searchType,
							Model model) {
		if((session.getAttribute("U_NO") == null) || ((int)session.getAttribute("U_NO") == 0)) {
			session.setAttribute("U_NO", 0);
			model.addAttribute("lgcheck", false);
		}
		else {
			model.addAttribute("lgcheck", true);
		}
		if(category.equals("main")){
			int total = service.countBoardSearch(search, searchType);
			System.out.println("검색된 글 수 : "+total);
			PagingVO pvo = new PagingVO(total, currentPage, 10, category, search, searchType);
			model.addAttribute("category", category);
			model.addAttribute("paging", pvo);
			model.addAttribute("list", service.getListSearch(pvo));
		}else if(category.equals("my")){
			int total = service.countBoardMy((String)session.getAttribute("U_ID"));	
			PagingVO pvo = new PagingVO(total, currentPage, 10, category);
			model.addAttribute("category", category);
			model.addAttribute("paging", pvo);
			model.addAttribute("list", service.getListMy(pvo, (String)session.getAttribute("U_ID")));
		}else {
			int total = service.countBoardCategory(category);
			System.out.println("카테고리 수 :" +total);
			PagingVO pvo = new PagingVO(total, currentPage, 10, category);
			model.addAttribute("category", category);
			model.addAttribute("paging", pvo);
			model.addAttribute("list", service.getListCategory(pvo));
		}
	}

	@GetMapping("/BoardRead")
	public void BoardRead(HttpSession session, @RequestParam("no") int no, Model model) {
		service.upCount(no);
		BoardVO bvo = service.read(no);
		String sessionid = "";
		if(session.getAttribute("U_ID")==null) {
			sessionid = "Guest";
		}
		else {
			sessionid = (((String) session.getAttribute("U_ID")).replace("\'",""));
		}
		if(sessionid.equals(bvo.getB_writer().toString())) { 
			model.addAttribute("idCheck", "true");
		}
		else {
			model.addAttribute("idCheck", "false");
		}
		Boolean likeValue = false;
		if((int)session.getAttribute("U_NO") != 0) {
			likeValue = service.likeCheck(no, (int) session.getAttribute("U_NO"));
		}
		//System.out.println((int) session.getAttribute("U_NO"));
		//System.out.println(likeValue);
		model.addAttribute("likeValue", likeValue);
		model.addAttribute("read", bvo);
		model.addAttribute("replys", service.replyList(no));
	}
	@GetMapping("/BoardLike")
	public String BoardLike(HttpSession session, HttpServletRequest request,
							@RequestParam("no") int no, Model model){
		System.out.println((int)session.getAttribute("U_NO"));
		if((int)session.getAttribute("U_NO") == 0) {
			return "redirect:/board/alert";
		}
		else {
			service.likeBoard(no, (int) session.getAttribute("U_NO"));
			return "redirect:/board/BoardRead?no="+no;
		}
	}
	
	@GetMapping("/logincheck")
	public String logincheck(HttpSession session, HttpServletRequest request){
		System.out.println((int)session.getAttribute("U_NO"));
		if((int)session.getAttribute("U_NO") == 0) {
			return "redirect:/board/alert";
		}
		else {
			return "redirect:/board/BoardWrite";
		}
	}
	
	@PostMapping("/BoardWrite")
	public String BoardWrite(BoardVO bvo) {
		service.write(bvo);
		return "redirect:/board/BoardList";
	}

	@GetMapping("/BoardWrite") 
	public void BoardWrite(HttpSession session) {
		
	}

	@GetMapping("/BoardDelete")
	public String BoardDelete(@RequestParam("no") int no) {
		service.delete(no);
		return "redirect:/board/BoardList";
	}
	
	@PostMapping("/BoardEdit") 
	public String BoardEdit(BoardVO bvo) {
		service.edit(bvo);
		log.info("edit complete");
		return "redirect:/board/BoardList";
	}
	 
	@GetMapping("/BoardEdit")
	public void BoardEdit(@RequestParam("no") int no, Model model) {
		model.addAttribute("read", service.read(no));
	}
	
	@GetMapping("/ReplyWrite")
	public String ReplyWrite(HttpSession session, HttpServletRequest request,
							ReplyVO rvo, @RequestParam("b_no") int b_no) {
		System.out.println((int)session.getAttribute("U_NO"));
		if((int)session.getAttribute("U_NO") == 0) {
			return "redirect:/board/alert";
		}
		else {
			service.replyWrite(rvo);
			return "redirect:/board/BoardRead?no="+b_no;
		}
	}
	
	@GetMapping("/ReplyDelete")
	public String ReplyDelete(@RequestParam("r_no") int r_no, @RequestParam("b_no") int b_no) {
		service.replyDelete(r_no);
		return "redirect:/board/BoardRead?no="+b_no;
	}
	
	@GetMapping("/alert")
	public void alert(HttpSession session, HttpServletRequest request) {
		request.setAttribute("msg", "로그인 후 이용해주세요");
		request.setAttribute("url", "/tp");
	}
	
}