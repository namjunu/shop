package com.teamp.spring.tp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	@PostMapping("/createID")
	public String createID(UserInfo id) {
		log.info("아이디 만드는 중.");
		service.createID(id);
		log.info("아이디를 만들었음");
		return "redirect:/";
	}
	@GetMapping("/createID")
	public void createID() {
	}
	@GetMapping("/test")
	public void test() {
		log.info("testest");
	}

}
