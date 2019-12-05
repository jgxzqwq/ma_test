package com.ma.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ma.entity.Emp;
import com.ma.entity.Frame_bank;
import com.ma.service.Frame_bankService;
import com.ma.service.TypesService;
import com.ma.service.impl.Frame_bankServiceImpl;

@Controller
public class Frame_bankController {

	
	@Autowired
	private Frame_bankService frame_bankService;
	
	@Autowired
	private TypesService typesService;
	@RequestMapping(value = "/frame")
	public @ResponseBody String frame(@RequestParam  Integer id) {

		//Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		Gson gson=new Gson();  
		boolean result = true;
		      //  System.out.println(str);
		    // Emp emp =gson.fromJson(str,Emp.class);
				
		        Map map = new HashMap<>();
		        //List list=frame_bankService.getListDepts();
		        List<Frame_bank> list=frame_bankService.findId(id);
		        System.out.println(list);
		        map.put("给你", result);
		       map.put("list", list);
		     /*   ObjectMapper mapper = new ObjectMapper();
		        String resultString = "";
		        try {
		            resultString = mapper.writeValueAsString(map);
		        } catch (JsonProcessingException e) {
		            e.printStackTrace();
		        }*/
		        String json=gson.toJson(map);
		        return json;
	}
}
