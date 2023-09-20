package com.teamp.spring.tp.controller;



import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.teamp.spring.tp.controller.LoginController;
import com.teamp.spring.tp.dto.UserInfo;
import com.teamp.spring.tp.service.LoginService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/Login/*")
@AllArgsConstructor
@Controller
public class LoginController {
	private LoginService service;
	

	@GetMapping("/test")
	public void test() {
		log.info("testest");
	}
	@GetMapping("/createID") //회원가입 창 보내기
	public void createID() {
	}
	@PostMapping("/createID") //회원가입
	public String createID(UserInfo id) {
		log.info("아이디 만드는 중.");
		service.createID(id);
		log.info("아이디를 만들었음");
		return "redirect:/";
	}
	@PostMapping("/checkID") //회원가입 도중 ID가 중복되는지 확인하는 함수
	@ResponseBody // 이 어노테이션을 추가하여 JSON 응답을 생성
	public Map<String, Boolean> checkID(String C_ID) {
		log.info("검색할 아이디 : "+C_ID);
		int howmany = service.checkID(C_ID); //C_ID와 같은 id인 회원정보가 있는지 탐색
		log.info("검색된 아이디 갯수는 "+howmany);
	    Map<String, Boolean> response = new HashMap<>(); //응답을 저장하는 response 해시맵 생성
	    if (howmany == 0) {
	        response.put("valid", true); //C_ID와 같은 id를 가진 회원정보가 없으면 valid를 true로 저장
	        log.info("valid를 true로");
	    } else {
	        response.put("valid", false); //C_ID와 같은 id를 가진 회원정보가 있으면 valid를 false로
	        log.info("valid를 false로");
	    }
	    return response;
	}
	@PostMapping("loginCheck") //로그인
	public String loginCheck(UserInfo id,HttpSession session,RedirectAttributes redirectAttributes) {
		boolean loginSuccess; //로그인 성공 판단 boolean
		if(service.loginCheck(id)== 1) { //id, pw를 넣었을 때 count되는 값이 있으면 1
			loginSuccess = true;
		} else {
			loginSuccess = false;
		}
		if(loginSuccess) {
			session.setAttribute("id",id.getU_ID()); //id 세션에 로그인된 U_ID값을 넣음
			return "redirect:/Login/getInfo"; //유저정보를 세션에 저장하는 동작 수행
		} else {
			redirectAttributes.addFlashAttribute("message", "로그인 실패, 아이디또는 비밀번호가 일치하지 않습니다");
			return "redirect:/";
		}
	}
	@GetMapping("/getInfo") //유저정보를 세션에 저장
	public String getInfo(HttpSession session) {
		String id= (String) session.getAttribute("id");
		log.info(id);
		UserInfo userInfo = service.getInfo(id);
		session.setAttribute("U_NO",userInfo.getU_NO());
		session.setAttribute("U_NAME",userInfo.getU_NAME());
		session.setAttribute("U_ADDRESS",userInfo.getU_ADDRESS());
		session.setAttribute("U_EMAIL",userInfo.getU_EMAIL());
		session.setAttribute("U_PHONE",userInfo.getU_PHONE()); //
		session.setAttribute("U_POINT",userInfo.getU_POINT());
		session.setAttribute("U_TIMESTAMP",userInfo.getU_TIMESTAMP());
		log.info("U_TIMESTAMP는 :"+ session.getAttribute("U_TIMESTAMP"));
		return "redirect:/";
	}
	
	@GetMapping("/editInfo") //회원정보 수정 페이지로 이동
	public void editInfo() {
	}
	@PostMapping("/editInfo") //받은 정보로 회원정보 수정
	public String editInfo(UserInfo id) {
		log.info(id.getU_ID()+"의 정보를 수정했습니다.");
		service.editInfo(id);
		return "redirect:/";
	}
	
	@GetMapping("/editPw") //비밀번호 재설정 페이지로 이동
	public void editPw() {
	}
	@PostMapping("/editPw") //입력한 비밀번호로 재설정
	public String editPw(UserInfo id) {
		log.info(id.getU_ID()+id.getU_PW());
		service.editPw(id);
		return "redirect:/";
	}
	
	@PostMapping("/logOut") //세션에 저장된 id를 삭제
	public String logout(HttpSession session) {
		session.removeAttribute("id");
		return "redirect:/";
	}
	@PostMapping("/addPoint")
	public String addPoint(@RequestParam("addPoint") int addPoint, UserInfo id, HttpSession session) {
		int currentPoint = (int)session.getAttribute("U_POINT");
		currentPoint += addPoint;
		session.setAttribute("U_POINT", currentPoint);
		id.setU_POINT(currentPoint);
		service.setPoint(id);
		return "redirect:/";
	}
	@PostMapping("/usePoint")
	public String usePoint(@RequestParam("usePoint") int usePoint, UserInfo id, HttpSession session) {
		int currentPoint = (int)session.getAttribute("U_POINT");
		currentPoint -= usePoint;
		session.setAttribute("U_POINT", currentPoint);
		id.setU_POINT(currentPoint);
		service.setPoint(id);
		return "redirect:/";
	}
	
	
	
}
