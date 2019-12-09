package com.ma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ma.entity.UserInfo;
import com.ma.service.UserInfoService;
import com.ma.service.impl.UserInfoServiceImpl;
/**
 * 
 * 首页处理
 *
 */
@Controller
public class HomeController {
  
	@Autowired
	private UserInfoService userInfoService;
	@RequestMapping("index.html")
	@ResponseBody
	public UserInfo HomePageInitialization()
	{

		
		UserInfo conditionQuery = userInfoService.conditionQuery(1);
		

	
		return conditionQuery;
	}
	
	
}
