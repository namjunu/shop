package com.teamp.spring;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.teamp.jang.kiosk.KioskScreen;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("/Kiosk")
	public void Kisok() {
		new KioskScreen();
	}
	

	@RequestMapping(value = "/map", method = RequestMethod.GET)
	public String showHospitalMap() {
	    // hospital_map.jsp를 보여주는 뷰 이름을 반환합니다.
	    return "hospital_map";
	}
	@RequestMapping(value = "/searchMap", method = RequestMethod.GET)
	public String showSearchMap() {
	    // hospital_map.jsp를 보여주는 뷰 이름을 반환합니다.
	    return "search_map";
	}
	@RequestMapping(value = "/reservationMain", method = RequestMethod.GET)
	public String showReservationMainPage() {
	    // 예약 관리 메인 페이지를 보여주는 뷰 이름을 반환합니다.
	    return "reservation/reservationMain"; // 뷰 이름은 "reservationMain"으로 반환하십시오.
	}
}

