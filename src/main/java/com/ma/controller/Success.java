package com.ma.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.ma.entity.Emp;
import com.ma.service.EmpService;

//import com.google.gson.Gson;



@Controller
public class Success {

	//获取id(通过json)

	
	
/*	@RequestMapping(value = "/successs", produces = "application/json;charset=utf-8")
	public @ResponseBody String successs(@RequestBody Emp emp) {

	Gson gson=new Gson();
		        boolean result = true;
		      //  System.out.println(str);
		    // Emp emp =gson.fromJson(str,Emp.class);
				System.out.println(emp+"");
		    
		        Map map = new HashMap();
		        
		        map.put("给你", result);
		        ObjectMapper mapper = new ObjectMapper();
		        String resultString = "";
		        try {
		            resultString = mapper.writeValueAsString(map);
		        } catch (JsonProcessingException e) {
		            e.printStackTrace();
		        }
		        String json=gson.toJson(map);

		        return json;
	}*/
	@RequestMapping(value = {"/success"})
	public @ResponseBody String success(HttpServletRequest request,@RequestParam String name,@RequestParam Integer id) {

	Gson gson=new Gson();
		        boolean result = true;
		      //  System.out.println(str);
		    // Emp emp =gson.fromJson(str,Emp.class);
				//System.out.println(emp);
		        System.out.println(name);
		        List list=new ArrayList();
		        list.add("Hobbit霍比特人");
		        list.add("url(img/t1.jpg)");
		        list.add("写了215.6k字 · 1k喜欢");
		        Map map = new HashMap();
		        
		        map.put("给你", result);
		        map.put("list", list);
		        ObjectMapper mapper = new ObjectMapper();
		        String resultString = "";
		        try {
		            resultString = mapper.writeValueAsString(map);
		        } catch (JsonProcessingException e) {
		            e.printStackTrace();
		        }
		        String json=gson.toJson(map);

		        return json;
	}

	/*
	@RequestMapping(value = "/frame")
	public @ResponseBody String frame(@RequestParam Integer id) {

	Gson gson=new Gson();
		        boolean result = true;
		      //  System.out.println(str);
		    // Emp emp =gson.fromJson(str,Emp.class);
				
		        Map map = new HashMap<>();
		       // Frame_bank list=frame_bankService.getFrame_bank(id);
		        map.put("给你", result);
		      //  map.put("list", list);
		        ObjectMapper mapper = new ObjectMapper();
		        String resultString = "";
		        try {
		            resultString = mapper.writeValueAsString(map);
		        } catch (JsonProcessingException e) {
		            e.printStackTrace();
		        }
		        String json=gson.toJson(map);
		        return json;
	}*/
	//抛出json
/*	@RequestMapping(value="/successs",produces="text/html;charset=UTF-8")
	
		   public @ResponseBody
		    String successs() {
		        boolean result = true;
		  
		        Map<String, Boolean> map = new HashMap<>();
		        map.put("给你", result);
		        ObjectMapper mapper = new ObjectMapper();
		        String resultString = "";
		        try {
		            resultString = mapper.writeValueAsString(map);
		        } catch (JsonProcessingException e) {
		            e.printStackTrace();
		        }
		        return resultString;
		    }*/
	}
	



	
