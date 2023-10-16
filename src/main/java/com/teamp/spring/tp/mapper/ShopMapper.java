package com.teamp.spring.tp.mapper;

import java.util.List;

import com.teamp.spring.tp.dto.ProductInfo;

public interface ShopMapper {

	List<ProductInfo> getAllProducts();
	ProductInfo getProductById(int productId);


}
