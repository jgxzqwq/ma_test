package com.ma.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.ma.entity.Dept;
import com.ma.entity.UserInfo;
import com.ma.repository.UserInfoRepository;
import com.ma.service.UserInfoService;

import io.swagger.annotations.Api;

@Controller
@ResponseBody
@Api(tags="test")
public class UserInfoController {
	
	@Autowired
	private UserInfoService userInfoService;
	
	@RequestMapping(value="/updateUserInfo", method=RequestMethod.POST,produces = "application/json;charset=utf-8")
	public @ResponseBody String updateInfo(@RequestBody UserInfo userInfo) {
		/*System.out.println("xxxx");
		
		
		map.put("code",200);
		String json = gson.toJson(map);
		response.getWriter().write(json);*/
		System.out.println(userInfo.getId());
		
		UserInfo u= userInfoService.updateUserInfo(userInfo);
		System.out.println(u);
	    Gson gson=new Gson();
	    Map map=new HashMap();
	    
	    map.put("code", 200);
		//response.getWriter().write(json);
		return gson.toJson(map);
	}
	
}
