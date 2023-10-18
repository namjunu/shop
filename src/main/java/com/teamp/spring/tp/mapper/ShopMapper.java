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
            @Param("p_NO") int p_NO, 
            @Param("quantity") int quantity);
    void saveCart(@Param("userId") String userId, @Param("cart") Map<Integer, Integer> cart);


    List<CartItem> getCart(@Param("userId") String userId);
    
    // Adding the method to update the quantity of a product in the cart
    void updateCartQuantity(@Param("userId") String userId, 
                            @Param("p_NO") int p_NO, 
                            @Param("quantity") int quantity);
                            
    // Adding the method to remove a product from the cart
    void removeFromCart(@Param("userId") String userId, 
                        @Param("p_NO") int p_NO);
    
    int findCartItem(@Param("userId") String userId, @Param("p_NO") int p_NO);
}
