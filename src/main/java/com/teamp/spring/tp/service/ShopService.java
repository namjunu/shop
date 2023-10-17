package com.teamp.spring.tp.service;

import java.util.List;
import java.util.Map;
import com.teamp.spring.tp.dto.ProductInfo;
import com.teamp.spring.tp.dto.CartItem;

public interface ShopService {
    
    List<ProductInfo> getAllProducts();
    
    ProductInfo getProductById(int productId);
    
    List<ProductInfo> searchProducts(String keyword);
    
    List<ProductInfo> selectProductsByCategory(String category);
    
    List<ProductInfo> searchProductsByCategoryAndKeyword(Map<String, Object> params);
    
    void saveCartToDatabase(String userId, Map<Integer, Integer> cart);
    Map<Integer, CartItem> getCartFromDatabase(String userId);
}
