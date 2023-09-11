package com.teamp.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.temp.jang.kiosk.KioskScreen;
import com.temp.jang.kiosk.KioskScreen;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
@RequestMapping("jang")
public class JangController {

	@RequestMapping("/Kiosk")
	public void Kisok() {
		new KioskScreen();
	}
	
}
