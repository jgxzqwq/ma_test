package com.ma.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.sound.sampled.Line;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ma.entity.User;
import com.ma.service.QuestionsBankService;
import com.ma.service.UserService;




@Controller
public class QuestionsController {
	

	@Autowired
	private QuestionsBankService questionsBankService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("getQuestions")
	@ResponseBody
	public Map dsf(HttpServletRequest re,@RequestParam  Integer type)
	{
		
		Map map = new HashMap();
			
			User user = userService.getName("10086");
			System.out.println(user.getPaper_records());
			
			
			
			List questions = questionsBankService.getQuestions(user, type);
			for (Object object : questions) {
				System.out.println(object);
			}
			
			map.put("code", 200);
			 
			 map.put("questions", questions);
	
			System.out.println("1212");
			
			
		
		return map;
		
		 
		
	}

	
}
	
	

		 
		
		
		
	


