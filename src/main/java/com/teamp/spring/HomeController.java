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
	
	@RequestMapping(value = "/map", method = RequestMethod.GET)
	public String showHospitalMap() {
	    // 여기에서 필요한 로직을 수행하고
	    // hospital_map.jsp를 보여주는 뷰 이름을 반환합니다.
	    return "hospital_map";
	}
	@RequestMapping(value = "/map/book", method = RequestMethod.GET)
	public String showBookPage() {
	    // 여기에서 필요한 로직을 수행하고
	    // book.jsp를 보여주는 뷰 이름을 반환합니다.
	    return "book/hopistal_book";
	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginPage() {
	    // 로그인 페이지를 보여주는 뷰 이름을 반환합니다.
	    return "login/login"; // 뷰 이름은 "login"으로 반환하십시오.
	}
	@RequestMapping(value = "/loginSuccess", method = RequestMethod.GET)
	public String showLoginSuccessPage() {
	    // 로그인 성공 페이지를 보여주는 뷰 이름을 반환합니다.
	    return "login/loginSuccess"; // 뷰 이름은 "loginsuccess"로 반환하십시오.
	}

}

