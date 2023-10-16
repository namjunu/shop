package com.teamp.spring.tp.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.teamp.spring.tp.dto.ProductInfo;
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
	    public ProductInfo getProductById(int productId) {
	        return shopMapper.getProductById(productId);
	    }
}
