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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.teamp.spring.tp.controller.LoginController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.teamp.spring.tp.dto.UserInfo;
import com.teamp.spring.tp.dto.CartItem;
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

	@GetMapping("/test") //테스트테스트
	public void test() {
		log.info("testest");
	}
	@GetMapping("/main") //쇼핑 버튼을 눌렀을 때
	public String showProductList(Model model) {
		List<ProductInfo> productList = shopService.getAllProducts();
        model.addAttribute("productList", productList);
		return "Shop/shop_main";
	}
	@GetMapping("/productDetail") //상품의 상세정보 페이지
	public ModelAndView productDetail(@RequestParam("productId") int productId) {
	    ModelAndView mv = new ModelAndView("Shop/product_detail");
	    ProductInfo product = shopService.getProductById(productId);
	    mv.addObject("product", product);
	    return mv;
	}
	@GetMapping("/productList") //키워드(검색어), 카테고리 검색 기능
	public String productList(Model model, 
							  @RequestParam(value = "category", required = false) String category,
							  @RequestParam(value = "keyword", required = false) String keyword) {
		if (category != null && keyword != null) {
			model.addAttribute("productList", shopService.searchProductsByCategoryAndKeyword(Map.of("category", category, "keyword", "%" + keyword + "%")));
		} else if (category != null) {
			model.addAttribute("productList", shopService.selectProductsByCategory(category));
		} else if (keyword != null) {
			model.addAttribute("productList", shopService.searchProducts(keyword));
		} else {
			model.addAttribute("productList", shopService.getAllProducts());
		}
		return "Shop/shop_main";
	}
	@PostMapping("/addToCart")
	public String addToCart(@RequestParam("productId") int productId,
	                        @RequestParam("quantity") int quantity,
	                        HttpSession session) {
	    String userId = (String) session.getAttribute("U_ID");
	    Map<Integer, Integer> cart = (Map<Integer, Integer>) session.getAttribute("cart");
	    
	    if (cart == null) {
	        cart = new HashMap<>();
	    }
	    
	    cart.put(productId, quantity);
	    session.setAttribute("cart", cart);
	    
	    if (userId != null) {
	        shopService.saveCartToDatabase(userId, cart);
	        session.removeAttribute("cart");
	    }
	    
	    return "redirect:/Shop/main";
	}
	@GetMapping("/cart")
	public String getCart(HttpSession session, Model model) {
	    String userId = (String) session.getAttribute("U_ID");
	    
	    if (userId != null) {
	        Map<Integer, CartItem> cartFromDB = shopService.getCartFromDatabase(userId);
	        model.addAttribute("cartFromDB", cartFromDB);
	    }
	    
	    return "/Shop/cart";
	}

}
