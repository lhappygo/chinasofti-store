package com.chinasofti.app.hystrix;

import java.util.List;

import org.springframework.stereotype.Component;

import com.chinasofti.app.feign.ShoppingCartFeignClient;
import com.chinasofti.mall.common.entity.order.PyShoppingCart;
import com.chinasofti.mall.common.utils.ResponseInfo;

@Component
public class ShoppingCartFeignClientHystrix implements ShoppingCartFeignClient{

	@Override
	public ResponseInfo queryPyShoppingCartListByUserId(String userId) {
		
		return new ResponseInfo();
	}

	@Override
	public ResponseInfo savePyShoppingCart(List<PyShoppingCart> goodsList) {
		return new ResponseInfo();
	}

	@Override
	public ResponseInfo updatePyShoppingCart(PyShoppingCart goodsInfo) {
		return new ResponseInfo();
	}

	@Override
	public ResponseInfo deletePyShoppingCartById(List<PyShoppingCart> goodsList) {
		return new ResponseInfo();
	}



}
