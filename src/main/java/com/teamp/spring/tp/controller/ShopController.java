package com.teamp.spring.tp.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.teamp.spring.tp.dto.UserInfo;
import com.teamp.spring.tp.dto.ProductInfo;
import com.teamp.spring.tp.service.LoginService;
import com.teamp.spring.tp.service.PwHashService;
import com.teamp.spring.tp.service.ShopService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/Shop/*")
@AllArgsConstructor
@Controller
public class ShopController {
	private final ShopService shopService;

	@GetMapping("/test")
	public void test() {
		log.info("testest");
	}
	@GetMapping("/main")
	public String showProductList(Model model) {
		List<ProductInfo> productList = shopService.getAllProducts();
        model.addAttribute("productList", productList);
		return "Shop/shop_main";
	}
}
