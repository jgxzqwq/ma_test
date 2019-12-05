package com.ma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ma.entity.Dept;
import com.ma.service.DeptService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


@Controller
public class DeptController {
	
	@Autowired
	private DeptService deptService;
	/**
	 * 查询所有部门信息
	 */
	@RequestMapping("/getlist")
	public String getlist(ModelMap map){
		List<Dept> depts = deptService.getListDepts();
		map.addAttribute("depts", depts);
		return "dept";
	}
	/**
	 * 添加部门
	 */
	@RequestMapping("/saveDept")
	public String save(Dept dept) {
		deptService.save(dept);
		return "redirect:getlist";
	}
	
	
	
}
