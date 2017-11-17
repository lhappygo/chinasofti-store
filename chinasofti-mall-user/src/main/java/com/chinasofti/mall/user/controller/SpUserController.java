package com.chinasofti.mall.user.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chinasofti.mall.common.entity.AdvertiseContents;
import com.chinasofti.mall.common.entity.spuser.SpMerchantUser;
import com.chinasofti.mall.common.entity.spuser.SpUser;
import com.chinasofti.mall.common.utils.MsgEnum;
import com.chinasofti.mall.common.utils.ResponseInfo;
import com.chinasofti.mall.user.service.SpUserService;

import net.sf.json.JSONObject;

/**
 * @author: xiaozhiliang
 * @Date:   2017年11月08日:04时48分26秒
 *
 */

@RestController
@RequestMapping("/spUser")
public class SpUserController {
	
	@Autowired
	SpUserService spUserService;
	
	@RequestMapping(value="/signUp" , method = RequestMethod.POST)
	public ResponseInfo signUp(@RequestBody(required=false) SpUser spUser) {
		ResponseInfo res = new ResponseInfo();
		if("Y".equals(spUserService.insert(spUser))){
			res.setRetCode("400010");
			res.setRetMsg("该账号已被注册");
			return res;
		}
		return dealResponseData(spUserService.insert(spUser));
			
		
	}
	
	@RequestMapping(value="/signIn" , method = RequestMethod.POST)
	public ResponseInfo signIn(@RequestBody(required=false) SpUser spUser) {
		ResponseInfo res = new ResponseInfo();
		if(spUserService.select(spUser) == null){
			res.setRetCode("400020");
			res.setRetMsg("账户或密码错误");
			return res;
		}
		return dealResponseData(spUserService.select(spUser));
	}
	
	//封装返回参数
	private ResponseInfo dealResponseData(Object obj) {
		ResponseInfo  response= new ResponseInfo();
		if(obj !=null){
			Map<String, Object> data= new HashMap<String, Object>();
			data.put("data", obj);
			response.setData(data);
			response.setRetCode(MsgEnum.SUCCESS.getCode());
			response.setRetMsg(MsgEnum.SUCCESS.getMsg());
		}else{
			response.setRetCode(MsgEnum.ERROR.getCode());
			response.setRetMsg(MsgEnum.ERROR.getMsg());
		}
		return response;
	}	
	
	
	
}