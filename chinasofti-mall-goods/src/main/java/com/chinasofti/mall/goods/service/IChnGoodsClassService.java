package com.chinasofti.mall.goods.service;


import com.chinasofti.mall.common.entity.goods.ChnGoodsClass;
import com.chinasofti.mall.common.service.IBaseService;
import com.chinasofti.mall.common.utils.ResponseInfo;

import net.sf.json.JSONObject;

public interface IChnGoodsClassService extends IBaseService<ChnGoodsClass>{
	
	public JSONObject selectByExample(ChnGoodsClass chnGoodsClass);
	
	public int deleteById(String ids);
	
	public ResponseInfo queryClass(String classId);
}
