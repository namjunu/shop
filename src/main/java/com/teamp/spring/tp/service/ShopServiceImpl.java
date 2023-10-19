package com.teamp.spring.tp.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.teamp.spring.tp.dto.CartItem;
import com.teamp.spring.tp.dto.OrdersInfo;
import com.teamp.spring.tp.dto.ProductInfo;
import com.teamp.spring.tp.dto.PurchaseInfo;
import com.teamp.spring.tp.mapper.ShopMapper;

@Service
public class ShopServiceImpl implements ShopService{
	 private final ShopMapper shopMapper;

	    public ShopServiceImpl(ShopMapper shopMapper) {
	        this.shopMapper = shopMapper;
	    }

	    @Override
	    public List<ProductInfo> getAllProducts() {
	        return shopMapper.getAllProducts();
	    }
	    @Override
	    public ProductInfo getProductById(int P_NO) {
	        return shopMapper.getProductById(P_NO);
	    }
	    @Override
	    public List<ProductInfo> searchProducts(String keyword) {
	        return shopMapper.searchProducts("%" + keyword + "%");
	    }
	    @Override
	    public List<ProductInfo> selectProductsByCategory(String P_CATEGORY) {
	        return shopMapper.selectProductsByCategory(P_CATEGORY);
	    }
	    @Override
	    public List<ProductInfo> searchProductsByCategoryAndKeyword(Map<String, Object> params) {
	        return shopMapper.searchProductsByCategoryAndKeyword(params);
	    }
	    @Override
	    public void updateProduct(ProductInfo productInfo) {
	        // DB에서 현재 상품 정보를 가져옵니다.
	        ProductInfo currentProduct = shopMapper.getProductById(productInfo.getP_NO());
	        
	        // 사용자가 값을 제공하지 않은 속성들을 현재 값으로 채워 넣습니다.
	        if (productInfo.getP_NAME() == null) productInfo.setP_NAME(currentProduct.getP_NAME());
	        if (productInfo.getP_PRICE() == 0) productInfo.setP_PRICE(currentProduct.getP_PRICE());
	        if (productInfo.getP_BRAND() == null) productInfo.setP_BRAND(currentProduct.getP_BRAND());
	        if (productInfo.getP_DESCRIPTION() == null) productInfo.setP_DESCRIPTION(currentProduct.getP_DESCRIPTION());
	        if (productInfo.getP_CATEGORY() == null) productInfo.setP_CATEGORY(currentProduct.getP_CATEGORY());
	        if (productInfo.getP_STOCK() == 0) productInfo.setP_STOCK(currentProduct.getP_STOCK());
	        if (productInfo.getP_IMAGE() == null) productInfo.setP_IMAGE(currentProduct.getP_IMAGE());
	        if (productInfo.getP_TAGS() == null) productInfo.setP_TAGS(currentProduct.getP_TAGS());
	        
	        // 업데이트된 상품 정보로 DB를 업데이트합니다.
	        shopMapper.updateProduct(productInfo);
	    }
	    @Override
	    public void saveCartToDatabase(String U_ID, Map<Integer, Integer> cart) {
	        shopMapper.saveCart(U_ID, cart);
	    }

	    @Override
	    public List<CartItem> getCartFromDatabase(String U_ID) {
	        return shopMapper.getCart(U_ID);
	    }
	    @Override
	    public int findCartItem(String U_ID, int P_NO) {
	        return shopMapper.findCartItem(U_ID, P_NO);
	    }
	    @Override
	    public void updateCartQuantity(String U_ID, int P_NO, int quantity) {
	        shopMapper.updateCartQuantity(U_ID, P_NO, quantity);
	    }
	    
	    @Override
	    public void removeFromCart(String U_ID, int P_NO) {
	        shopMapper.removeFromCart(U_ID, P_NO);
	    }
	    @Override
	    public void createPurchase(String U_ID) {
	        // PURCHASE_HISTORY 테이블에 구매 이력 저장
	        PurchaseInfo purchaseInfo = new PurchaseInfo();
	        purchaseInfo.setU_ID(U_ID);
	        shopMapper.savePurchaseHistory(purchaseInfo);
	    }
	    @Override
	    public Integer getOrderId() {
	    	return shopMapper.getGeneratedOrderId();
	    }
	    @Override
	    public void createOrder(OrdersInfo orderInfo, int generatedOrderId) {
	        orderInfo.setO_ID(generatedOrderId);
	        shopMapper.saveOrder(orderInfo);
	    }
	    @Override
	    public 	OrdersInfo getOneOrderById(Integer O_ID, Integer P_NO) {
	    	return shopMapper.getOneOrderById(O_ID, P_NO);
	    }
	    @Override
	    public List<OrdersInfo> getOrderById(Integer O_ID) {
	        return shopMapper.getOrderById(O_ID);
	    }

	    @Override
	    public void removeOrder(Integer O_ID, Integer P_NO) {
	        shopMapper.removeOrder(O_ID, P_NO);
	    }
	    @Override
	    public List<PurchaseInfo> getPurchaseHistory(String U_ID){
	    	return shopMapper.getPurchaseHistory(U_ID);
	    }
}
