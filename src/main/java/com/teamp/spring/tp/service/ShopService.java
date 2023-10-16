package com.teamp.spring.tp.service;

import java.util.List;

import com.teamp.spring.tp.dto.ProductInfo;
public interface ShopService {

	List<ProductInfo> getAllProducts();
	ProductInfo getProductById(int productId);

}
