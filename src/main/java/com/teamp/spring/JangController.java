package com.teamp.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.teamp.jang.kiosk.KioskIns1;
import com.teamp.jang.kiosk.KioskIns4;
import com.teamp.jang.kiosk.KioskInsFinal;
import com.teamp.jang.kiosk.KioskScreen;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
@RequestMapping("jang")
public class JangController {

	@RequestMapping("/Kiosk")
	public void Kisok() {
		KioskInsFinal kioskScreen = new KioskInsFinal();
		kioskScreen.KioskGUI();
		
	}
	
}
