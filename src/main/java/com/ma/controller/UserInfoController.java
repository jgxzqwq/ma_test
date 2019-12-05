package com.ma.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.ma.entity.Dept;

import io.swagger.annotations.Api;

@Controller
@ResponseBody
@Api(tags="test")
public class UserInfoController {
	
	
	@RequestMapping(value="/updateUserInfo")
	public  String updateInfo(HttpServletResponse response) throws IOException{
		/*System.out.println("xxxx");
		Map map=new HashMap();
		
		map.put("code",200);
		String json = gson.toJson(map);
		response.getWriter().write(json);*/
		Dept dept = new Dept();
		dept.setDid(1);
		dept.setDname("coco");
		Gson gson=new Gson();
		String json=gson.toJson(dept);
		//response.getWriter().write(json);
		return json;
	}
	
}
