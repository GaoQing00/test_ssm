package com.exe.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exe.ssm.po.ItemsCustom;

/**
 * json交互测试
 * @author Administrator
 *
 */

@Controller
public class JsonTest {

	//请求json（商品信息），输出json（商品信息）
	//@RequestBody 将请求的商品信息的json串转成itemsCustom对象
	//@ResponseBody 将itemsCustom转成json输出
	@RequestMapping("/requestJson")
	public @ResponseBody ItemsCustom requestJson(@RequestBody ItemsCustom itemsCustom){
		
		//@ResponseBody 将itemsCustom转成json输出
		return itemsCustom;
	}
	
	//请求key/value（商品信息），输出json（商品信息）
	@RequestMapping("/responseJson")
	public @ResponseBody ItemsCustom responseJson(ItemsCustom itemsCustom){
			
		//@ResponseBody 将itemsCustom转成json输出
		return itemsCustom;
	}
}
