/**
 * 
 */
package com.chinasofti.mall.web.entrance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.chinasofti.mall.common.entity.spuser.SpMerchantUser;
import com.chinasofti.mall.web.entrance.feign.SpMerchantUserFeignClient;

import net.sf.json.JSONObject;

/**
 * @ClassName: SpUserController.java
 * @Description: TODO
 * @author zhoushanshan
 * @Date: 2017年11月2日 下午4:51:30
 * @parma <T>
 */
@RestController
@RequestMapping("/spUser")
public class SpMerchantUserController {
    @Autowired
	private SpMerchantUserFeignClient spUserFeignClient;
    
    @RequestMapping("/index")
	public ModelAndView toIndex(){
		return new ModelAndView("/spuser/spuser");
	}
	
	/**
	 * 查询列表
	 * @param spMerchantUser
	 * @return
	 */
	@RequestMapping("/list")
	public String selectBySpUser(SpMerchantUser spMerchantUser){
		JSONObject jsonlist = spUserFeignClient.selectBySpUser(spMerchantUser);
		return jsonlist.toString();
		
	}
	
	/**
	 * 根据ID查询
	 * @param ids
	 * @return
	 */
	@RequestMapping("/select/{ids}")
	public SpMerchantUser selectByGoodsClassById(@PathVariable String ids){
		SpMerchantUser spMerchantUser = spUserFeignClient.selectSpUserById(ids);
		return spMerchantUser;
	}
	
	/**
	 * 通过主键删除
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "delete/{ids}")
	public String orderDeleteById(@PathVariable String ids) {

		return spUserFeignClient.deleteById(ids);

	}
}
