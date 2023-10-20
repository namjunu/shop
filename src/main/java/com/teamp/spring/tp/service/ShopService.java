package com.teamp.spring.tp.service;

import java.util.List;
import java.util.Map;
import com.teamp.spring.tp.dto.ProductInfo;
import com.teamp.spring.tp.dto.PurchaseInfo;
import com.teamp.spring.tp.dto.CartItem;
import com.teamp.spring.tp.dto.OrdersInfo;

public interface ShopService {
    
    List<ProductInfo> getAllProducts();    
    ProductInfo getProductById(int P_NO);    
    List<ProductInfo> searchProducts(String keyword);    
    List<ProductInfo> selectProductsByCategory(String P_CATEGORY);    
    List<ProductInfo> searchProductsByCategoryAndKeyword(Map<String, Object> params);
    void updateProduct(ProductInfo productInfo);
    
    
    void saveCartToDatabase(String U_ID, Map<Integer, Integer> cart);    
    List<CartItem> getCartFromDatabase(String U_ID);    
    void updateCartQuantity(String U_ID, int p_NO, int quantity);    
    void removeFromCart(String U_ID, int p_NO);   
    int findCartItem(String U_ID, int p_NO);
    List<OrdersInfo> getOrderById(Integer O_ID);
	void removeOrder(Integer O_ID, Integer P_NO);
	void createPurchase(String U_ID);
	Integer getOrderId();
	void createOrder(OrdersInfo orderInfo, int generatedOrderId);
	OrdersInfo getOneOrderById(Integer O_ID, Integer P_NO);
	
	List<PurchaseInfo> getPurchaseHistory(String U_ID);
}
