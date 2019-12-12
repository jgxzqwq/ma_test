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

import com.ma.entity.Frame_bank;
import com.ma.entity.Paper_records;
import com.ma.entity.User;
import com.ma.service.FrameBankService;
import com.ma.service.FrontEndBankService;
import com.ma.service.JavaAdvancedBankService;
import com.ma.service.JavaIntermediateBankService;
import com.ma.service.JavaJuniorBankService;
import com.ma.service.MistakesService;
import com.ma.service.UserService;




@Controller
public class QuestionsController {
	
	@Autowired
	private FrameBankService frameBank;

	@Autowired
	private FrontEndBankService frontEndBankService;
	
	@Autowired
	private JavaAdvancedBankService javaAdvancedBankService;
	
	@Autowired
	private JavaIntermediateBankService javaIntermediateBankService;
	
	@Autowired 
	private JavaJuniorBankService javaJuniorBankService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MistakesService mistakesService;
	
	
	@RequestMapping("ssss")
	@ResponseBody
	public Map dsf(HttpServletRequest re)
	{
		
		Map map = new HashMap();
			try {
			User user = userService.getName("10010");
			System.out.println(user.toString());
			Integer id = user.getId();

			Integer statistics = mistakesService.getStatistics(user.getId());

			List types = type(1,user.getPaper_records(),statistics);
			System.out.println("................................................................................................");
			System.out.println(types.size());
		
			 map.put("code", 200);
			 map.put("questions", types);
	
			} catch (Exception e) {
				 map.put("code", 500);
			}
		
		return map;
		
		 
		
	}

	public   List type(Integer id,Paper_records pa,Integer quantity){

		List sd = null;

		switch (1) {
		case 1:
			System.out.println(pa.getFrame_id());
			sd = frameBank.getSubject(pa.getFrame_id(), quantity);
		
			break;
		case 2:
	
			break;
		case 3:
		
			break;
		case 4:
		
			break;
		case 5:
		
			break;
		
		default:
			break;
		}
		return sd;
		
	}
	
	

		 
		
		
		
	

}
