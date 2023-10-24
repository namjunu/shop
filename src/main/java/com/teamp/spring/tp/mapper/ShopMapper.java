package com.teamp.spring.tp.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.teamp.spring.tp.dto.CartItem;
import com.teamp.spring.tp.dto.OrdersInfo;
import com.teamp.spring.tp.dto.ProductInfo;
import com.teamp.spring.tp.dto.PurchaseInfo;

public interface ShopMapper {

	List<ProductInfo> getAllProducts();    
    ProductInfo getProductById(int P_NO);    
    List<ProductInfo> searchProducts(String keyword);    
    List<ProductInfo> selectProductsByCategory(String P_CATEGORY);  
    List<ProductInfo> searchProductsByCategoryAndKeyword(Map<String, Object> params);
    void updateProduct(ProductInfo productInfo);
	void insertProduct(ProductInfo productInfo);
	
    void insertIntoCart(@Param("U_ID") String U_ID, 
            @Param("P_NO") int P_NO, 
            @Param("quantity") int quantity);
    void saveCart(@Param("U_ID") String U_ID, @Param("cart") Map<Integer, Integer> cart);
    List<CartItem> getCart(@Param("U_ID") String U_ID);  
    // Adding the method to update the quantity of a product in the cart
    void updateCartQuantity(@Param("U_ID") String U_ID, 
                            @Param("P_NO") int P_NO, 
                            @Param("quantity") int quantity);                            
    // Adding the method to remove a product from the cart
    void removeFromCart(@Param("U_ID") String U_ID, 
                        @Param("P_NO") int P_NO);   
    int findCartItem(@Param("U_ID") String U_ID, @Param("P_NO") int P_NO);
	void savePurchaseHistory(PurchaseInfo purchaseInfo);
	Integer getGeneratedOrderId();
	void saveOrder(OrdersInfo orderInfo);
	List<OrdersInfo> getOrderById(Integer O_ID);
	void removeOrder(Integer O_ID, Integer P_NO);
	OrdersInfo getOneOrderById(Integer o_ID, Integer P_NO);
	List<PurchaseInfo> getPurchaseHistory(String U_ID);

}
