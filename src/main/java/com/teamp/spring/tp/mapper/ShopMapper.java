package com.teamp.spring.tp.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.teamp.spring.tp.dto.CartItem;
import com.teamp.spring.tp.dto.ProductInfo;

public interface ShopMapper {

	List<ProductInfo> getAllProducts();
    
    ProductInfo getProductById(int productId);
    
    List<ProductInfo> searchProducts(String keyword);
    
    List<ProductInfo> selectProductsByCategory(String category);
    
    List<ProductInfo> searchProductsByCategoryAndKeyword(Map<String, Object> params);

    void insertIntoCart(@Param("userId") String userId, 
            @Param("productId") int productId, 
            @Param("quantity") int quantity);
    void saveCart(String userId, Map<Integer, Integer> cart);

    Map<Integer, CartItem> getCart(String userId);
}
