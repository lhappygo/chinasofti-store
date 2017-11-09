package com.chinasofti.mall.goods.service;

import com.chinasofti.mall.common.entity.goods.ChnGoodsClass;
import com.chinasofti.mall.common.service.IBaseService;

import net.sf.json.JSONObject;

public interface ChnGoodsClassService extends IBaseService<ChnGoodsClass>{
	
	JSONObject selectByExample(ChnGoodsClass chnGoodsClass);
	
	int deleteById(String ids);
	
}