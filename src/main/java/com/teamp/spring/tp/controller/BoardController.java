package com.teamp.spring.tp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.teamp.spring.tp.dto.BoardVO;
import com.teamp.spring.tp.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/board/*")	//프로젝트 루트 경로 이하 /guest 상위폴더로 진입 시 여기로 진입하게 됨.  
@AllArgsConstructor	//필드 값을 매개변수로 하는 생성자를 스프링이 알아서 만들어 줌. 그리고 그런 형태의 생성자를 추가하면 스프링이 알아서 객체관리 해줌(@Auto.. 처럼)
@Controller
public class BoardController {

//	위에 @AllArgsConstructor 이걸 쓰면
//	롬복라이브러리가 아래 코드를 자동으로 삽입해줌
	
	//
//	public GuestController(GuestService service){
//		this.service = service;
//	}
	
	private BoardService service;
	
	@GetMapping("/BoardList")
	public void BoardList(@RequestParam(value="currentPage", defaultValue = "1") int currentPage, Model model) {
		model.addAttribute("list",service.getList(currentPage));
	}
		
	@GetMapping("/BoardRead")
	public void read(@RequestParam("no") int no, Model model) {
		log.info("컨트롤러 ==== 글번호 ==============="+no);
		model.addAttribute("read",service.read(no));
	}

	@PostMapping("/BoardWrite")
	public String BoardWrite(BoardVO bvo) {
		service.write(bvo);
		return "redirect:/board/BoardList";	//sendRedirect 로 이동하게 됨. // 책 p.245 참고
	}	
	
	// >>> 홈페이지/spring/guest/write (get 방식으로 오면 여기로 옴. 일반링크이동=get방식임)	
	@GetMapping("/BoardWrite")	// 책 p.239 /write 중복이지만 이건 글쓰기 화면을 위한 url 매핑
	public void BoardWrite() {
		
	}
}