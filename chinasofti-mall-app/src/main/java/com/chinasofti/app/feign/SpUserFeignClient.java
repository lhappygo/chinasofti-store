package com.chinasofti.app.feign;



import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chinasofti.app.hystrix.AdvertiseFeignClientHystrix;
import com.chinasofti.app.hystrix.SpUserFeignClientHystrix;
import com.chinasofti.mall.common.entity.spuser.SpUser;
import com.chinasofti.mall.common.utils.ResponseInfo;

import net.sf.json.JSONObject;




/**
* @ClassName: SpUserFeignClient
* @Description: 前端用户的feign消费类
* @author xiaozhiliang
* @date 
* @version
*/
@FeignClient(name = "userService" , fallback = SpUserFeignClientHystrix.class)
public interface SpUserFeignClient {
	
	
	/**
	 * 
	* @Title: signUp
	* @Description: 前端用户注册
	* @param spUser
	* @return: String
	* @throws:
	 */
	@RequestMapping(value = "/spUser/signUp")
	public ResponseInfo signUp(@RequestBody(required=false) SpUser spUser);

	/**
	* @Title: 
	* @Description: 前端用户登录
	* @param: spUser
	* @return: String
	* @throws
	*/
	@RequestMapping(value = "/spUser/signIn")
	public ResponseInfo signIn(@RequestBody(required=false) SpUser spUser);
	
	
}