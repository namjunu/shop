package com.teamp.spring.tp.controller;

import java.util.ArrayList;
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
import org.springframework.web.servlet.ModelAndView;

import com.teamp.spring.tp.dto.CartItem;
import com.teamp.spring.tp.dto.OrdersInfo;
import com.teamp.spring.tp.dto.ProductInfo;
import com.teamp.spring.tp.dto.PurchaseInfo;
import com.teamp.spring.tp.dto.UserInfo;
import com.teamp.spring.tp.service.LoginService;
import com.teamp.spring.tp.service.ShopService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/Shop/*")
@Controller
@AllArgsConstructor
public class ShopController {
    private final ShopService shopService;
	private LoginService loginService;

    @GetMapping("/test") // 테스트테스트
    public void test() {
        log.info("testest");
    }

    @GetMapping("/main") // 쇼핑 버튼을 눌렀을 때
    public String showProductList(Model model) {
    	log.info("showProductList 실행");
        List<ProductInfo> productList = shopService.getAllProducts();
        model.addAttribute("productList", productList);
        return "Shop/shop_main";
    }

    @GetMapping("/productDetail") // 상품의 상세정보 페이지
    public ModelAndView productDetail(@RequestParam("P_NO") int P_NO) {
    	log.info("productDetail 실행");
        ModelAndView mv = new ModelAndView("Shop/product_detail");
        ProductInfo product = shopService.getProductById(P_NO);
        mv.addObject("product", product);
        return mv;
    }

    @GetMapping("/productList")
    public String productList(Model model,
                              @RequestParam(value = "P_CATEGORY", required = false) String P_CATEGORY,
                              @RequestParam(value = "keyword", required = false) String keyword) {
        log.info("productList 검색 실행");
        if (P_CATEGORY != null && !P_CATEGORY.isEmpty() && keyword != null && !keyword.isEmpty()) {
            log.info("카테고리 =" + P_CATEGORY + ", 키워드 =" + keyword);
            model.addAttribute("productList",
                    shopService.searchProductsByCategoryAndKeyword(Map.of("P_CATEGORY", P_CATEGORY, "keyword", "%" + keyword + "%")));
        } else if (P_CATEGORY != null && !P_CATEGORY.isEmpty()) {
            log.info("카테고리 =" + P_CATEGORY + ", 키워드 없음");
            model.addAttribute("productList", shopService.selectProductsByCategory(P_CATEGORY));
        } else if (keyword != null && !keyword.isEmpty()) {
            log.info("카테고리 = 없음, 키워드 =" + keyword);
            model.addAttribute("productList", shopService.searchProducts(keyword));
        } else {
            log.info("카테고리, 키워드 없음");
            model.addAttribute("productList", shopService.getAllProducts());
        }
        return "Shop/shop_main";
    }
    @PostMapping("/updateProduct") // 제품 정보 업데이트
    public String updateProduct(ProductInfo productInfo) {
    	log.info(productInfo.getP_NO()+"의 정보 업데이트");
        shopService.updateProduct(productInfo);
        return "redirect:/Shop/productDetail?P_NO=" + productInfo.getP_NO();
    }
    @GetMapping("/insertProduct") //제품 추가
    public String insertProduct(HttpSession session) {
    	String U_ID = (String) session.getAttribute("U_ID");
    	log.info(U_ID+"로 로그인");
    	if("admin".equals(U_ID)) {
    		return "Shop/insertProduct";
    	} else {
    	log.info("관리자가 아닙니다.");
    	return "redirect:/Shop/main";
    	}
    }
    @PostMapping("/insertProduct") //제품 정보 받아서 제품 추가 서비스
    public String insertProduct(ProductInfo productInfo) {
    	shopService.insertProduct(productInfo);
    	return "redirect:/Shop/main";
    }
    @PostMapping("/addToCart")
    public String addToCart(@RequestParam("P_NO") int P_NO,
                            @RequestParam("quantity") int quantity,
                            HttpSession session) {
        log.info("addToCart 실행");
        log.info("P_NO는 " + P_NO + ", quantity는 " + quantity);
        String U_ID = (String) session.getAttribute("U_ID");
        Map<Integer, Integer> cart = (Map<Integer, Integer>) session.getAttribute("cart");

        if (cart == null) {
            cart = new HashMap<>();
        }

        Integer existingQuantity = cart.get(P_NO); // 기존 수량 확인

        if (existingQuantity != null) {
            // 이미 카트에 있는 상품인 경우 수량을 더해줌
        	log.info("카트에서 상품 발견.");
            cart.put(P_NO, quantity + existingQuantity);
        } else {
            // 카트에 없는 상품인 경우 추가
        	log.info("카트에 상품 없음.");
            cart.put(P_NO, quantity);
        }

        session.setAttribute("cart", cart);

        // Only interact with the database if the user is logged in
        if (U_ID != null) {
            int existingQuantityDB = shopService.findCartItem(U_ID, P_NO);
            if (existingQuantityDB > 0) {
                // If product exists in the database, update the quantity
            	log.info("카트DB에서 상품 발견");
                shopService.updateCartQuantity(U_ID, P_NO, quantity + existingQuantityDB);
            } else {
                // If product doesn't exist in the database, save the cart to the database
            	log.info("카트DB에 상품 없음");
                shopService.saveCartToDatabase(U_ID, cart);
            }
        }

        return "redirect:/Shop/main";
    }


    @PostMapping("/updateCart")
    public String updateCart(@RequestParam("P_NO") int P_NO,
                             @RequestParam("quantity") int quantity,
                             HttpSession session) {
    	log.info(P_NO+"번 상품의 수량을"+quantity+"로 업데이트");
        String U_ID = (String) session.getAttribute("U_ID");
        Map<Integer, Integer> cart = (Map<Integer, Integer>) session.getAttribute("cart");

        if (cart == null) {
            cart = new HashMap<>();
        }

        cart.put(P_NO, quantity);
        session.setAttribute("cart", cart);

        if (U_ID != null) {
            shopService.saveCartToDatabase(U_ID, cart);
        }

        return "redirect:/Shop/cart";
    }

    @GetMapping("/testId")
    public void testId(HttpSession session) {
        String userId = (String) session.getAttribute("U_ID");
        log.info(userId);
    }

    @GetMapping("/cart")
    public String getCart(HttpSession session, Model model) {
        String U_ID = (String) session.getAttribute("U_ID");
        List<CartItem> cartFromDB;
        if (U_ID != null) {
            // 로그인 상태: DB의 카트 정보를 가져옴
            cartFromDB = shopService.getCartFromDatabase(U_ID);
        } else {
            // 로그아웃 상태: 세션의 카트 정보를 가져옴
            Map<Integer, Integer> cart = (Map<Integer, Integer>) session.getAttribute("cart");

            // 세션에 카트 정보가 없을 경우 빈 리스트로 초기화
            if (cart == null) {
                cart = new HashMap<>();
            }

            cartFromDB = new ArrayList<>();

            // 세션의 카트 정보를 CartItem 리스트로 변환하여 cartFromDB에 추가
            for (Map.Entry<Integer, Integer> entry : cart.entrySet()) {
                int P_NO = entry.getKey();
                int quantity = entry.getValue();
                CartItem cartItem = new CartItem(U_ID, P_NO, quantity);
                cartFromDB.add(cartItem);
            }
        }
            Map<Integer, ProductInfo> productDetails = new HashMap<>();
            for (CartItem item : cartFromDB) {
                ProductInfo productInfo = shopService.getProductById(item.getp_NO());
                productDetails.put(item.getp_NO(), productInfo);
            }
            model.addAttribute("productDetails", productDetails);
            model.addAttribute("cartFromDB", cartFromDB);
        return "Shop/cart";
    }
    @GetMapping("/purchaseConfirm")
    public String purchaseConfirm(HttpSession session, Model model) {
        String U_ID = (String) session.getAttribute("U_ID");
        List<CartItem> cartFromDB;
        if (U_ID != null) {
            // 로그인 상태: DB의 카트 정보를 가져옴
            cartFromDB = shopService.getCartFromDatabase(U_ID);
        } else {
            // 로그아웃 상태: 세션의 카트 정보를 가져옴
            Map<Integer, Integer> cart = (Map<Integer, Integer>) session.getAttribute("cart");

            // 세션에 카트 정보가 없을 경우 빈 리스트로 초기화
            if (cart == null) {
                cart = new HashMap<>();
            }

            cartFromDB = new ArrayList<>();

            // 세션의 카트 정보를 CartItem 리스트로 변환하여 cartFromDB에 추가
            for (Map.Entry<Integer, Integer> entry : cart.entrySet()) {
                int P_NO = entry.getKey();
                int quantity = entry.getValue();
                CartItem cartItem = new CartItem(U_ID, P_NO, quantity);
                cartFromDB.add(cartItem);
            }
        }
            Map<Integer, ProductInfo> productDetails = new HashMap<>();
            for (CartItem item : cartFromDB) {
                ProductInfo productInfo = shopService.getProductById(item.getp_NO());
                productDetails.put(item.getp_NO(), productInfo);
            }
            model.addAttribute("productDetails", productDetails);
            model.addAttribute("cartFromDB", cartFromDB);
        return "Shop/purchaseConfirm";
    }
    @PostMapping("/updateCartQuantity")
    public String updateCartQuantity(@RequestParam("P_NO") int P_NO,
                                     @RequestParam("quantity") int quantity,
                                     HttpSession session) {
        String U_ID = (String) session.getAttribute("U_ID");

        if (U_ID != null) {
        	
            shopService.updateCartQuantity(U_ID, P_NO, quantity);
        }

        return "redirect:/Shop/cart";
    }

    @PostMapping("/removeFromCart")
    public String removeFromCart(@RequestParam("P_NO") int P_NO, HttpSession session) {
        String U_ID = (String) session.getAttribute("U_ID");

        // 카트 정보 가져오기
        Map<Integer, Integer> cart = (Map<Integer, Integer>) session.getAttribute("cart");

        if (cart != null) {
            // 세션에서 해당 상품 제거
            cart.remove(P_NO);
            session.setAttribute("cart", cart);
        }

        if (U_ID != null) {
            // 로그인 상태라면 DB에서도 해당 상품 제거
            shopService.removeFromCart(U_ID, P_NO);
        }

        return "redirect:/Shop/cart";
    }
    @PostMapping("/createOrder")
    public String createOrder(HttpSession session, Model model, 
                              @RequestParam("o_NAME") String o_NAME,
                              @RequestParam("o_ADDRESS") String o_ADDRESS,
                              @RequestParam("o_PHONE") String o_PHONE) {
        // 1. Session에서 U_ID 가져오기
        String U_ID = (String) session.getAttribute("U_ID");

        // 2. createPurchase를 통해 Purchase 생성하고 O_ID 가져오기
        if(U_ID==null) {
        	log.info("U_ID가 없습니다.");
        	U_ID ="guest";
        }
        log.info(U_ID+"로 purchase 생성중");
        shopService.createPurchase(U_ID);
        log.info(U_ID+"로 purchase 생성완료");
        Integer generatedOrderId = shopService.getOrderId();
        log.info("주문번호:"+generatedOrderId);
        // 3. Session에서 Cart 정보 가져와서 Order 생성
        @SuppressWarnings("unchecked")
        Map<Integer, Integer> cart = (Map<Integer, Integer>) session.getAttribute("cart");
        int currentPoint;
        if (U_ID != null && !U_ID.equals("guest")) {
        	currentPoint = (int)session.getAttribute("U_POINT");
        } else {
        	currentPoint = 0;
        }
		

        if (cart != null) {
            for (Map.Entry<Integer, Integer> entry : cart.entrySet()) {
                int P_NO = entry.getKey();
                int quantity = entry.getValue();
                ProductInfo product = shopService.getProductById(P_NO);
                int price=product.getP_PRICE();
                int total = quantity*price;
                OrdersInfo orderInfo = new OrdersInfo();
                orderInfo.setO_ID(generatedOrderId);
                orderInfo.setP_NO(P_NO);
                orderInfo.setQUANTITY(quantity);
                orderInfo.setO_NAME(o_NAME); // JSP에서 전송된 정보 설정
                orderInfo.setO_ADDRESS(o_ADDRESS); // JSP에서 전송된 정보 설정
                orderInfo.setO_PHONE(o_PHONE); // JSP에서 전송된 정보 설정
                orderInfo.setPAYMENT_AMOUNT(total);
                // 필요한 다른 주문 정보 설정
                currentPoint += total*0.1;
                // createOrder 메서드를 호출하여 주문 생성
                shopService.createOrder(orderInfo, generatedOrderId);
            }

            // 주문 완료 후 세션의 카트 비우기
            session.removeAttribute("cart");
            if(!U_ID.equals("guest")) {
            	session.setAttribute("U_POINT", currentPoint);
            	UserInfo userInfo = new UserInfo();
            	userInfo.setU_ID(U_ID);
            	userInfo.setU_POINT(currentPoint);
            	loginService.setPoint(userInfo);
            }
        }

        // 주문 완료 후 리다이렉트 또는 다른 작업 수행
        return "redirect:/Shop/main"; // 주문 완료 후 메인 페이지로 이동
    }
    @GetMapping("/orderDetails")
    public String getOrderDetails(@RequestParam("O_ID") int O_ID, Model model) {
        // 주문번호(orderNumber)를 기반으로 주문 정보 조회
        // 이 부분에서 주문 정보를 조회하는 서비스 메서드를 호출해야 합니다.
        List<OrdersInfo> orderDetails = (List<OrdersInfo>) shopService.getOrderById(O_ID);
        if (orderDetails == null || orderDetails.isEmpty()) {
            // 주문 정보가 없는 경우에 대한 예외 처리
            // 예를 들어, 주문번호가 올바르지 않은 경우
            return "redirect:/Shop/main"; // 메인 페이지로 리다이렉트 또는 다른 처리를 수행하세요.
        }

        // 주문 정보 목록을 모델에 추가
        model.addAttribute("orderDetails", orderDetails);

        return "Shop/orderDetails"; // 주문 상세 정보 페이지로 이동
    }
    @GetMapping("/purchaseHistory")
    public String purchaseHistory(HttpSession session, Model model) {
    	String U_ID = (String) session.getAttribute("U_ID");
    	List<PurchaseInfo> purchaseList = shopService.getPurchaseHistory(U_ID);
    	model.addAttribute("purchaseList", purchaseList);
    	return "Shop/purchaseHistory";
    }

}
