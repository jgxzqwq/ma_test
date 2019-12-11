package com.ma.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.ma.entity.Types;
import com.ma.entity.User;
import com.ma.entity.UserInfo;
import com.ma.service.TypesService;
import com.ma.service.UserInfoService;
import com.ma.service.UserService;
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
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TypesService typesService;


	
	//初始化首页信息
	@RequestMapping(value="/Init",method=RequestMethod.GET)
	@ResponseBody 
	public UserInfo HomePageInitialization(HttpServletRequest re)
	{

		System.out.println("111");

		User name = userService.getName("10010");
		
		UserInfo conditionQuery = userInfoService.conditionQuery(name.getId());
		
	
	
		System.out.println(conditionQuery.getUser().toString());
		

	System.out.println(conditionQuery);
		return conditionQuery;
	}
	
	//每日答题
	@ResponseBody
	@RequestMapping("getQuestionTypes")
	public Map questionTypes(){
		Map map = new HashMap();
		try {
			 List<Types> types = typesService.findAll();
			 map.put("code", 200);
			 map.put("questionTypes", types);
		} catch (Exception e) {
			map.put("code",500);
		}
		return map;
	}
 
	
}
