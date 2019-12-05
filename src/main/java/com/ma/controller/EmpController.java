package com.ma.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ma.entity.Dept;
import com.ma.entity.Emp;
import com.ma.service.DeptService;
import com.ma.service.EmpService;
import com.ma.service.impl.EmpServiceImpl;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

//@RestController
/*@RestController注解，
相当于@Controller+@ResponseBody两个注解的结合，
返回json数据不需要在方法前面加@ResponseBody注解了，
使用@RestController这个注解，就不能返回jsp,html页面，
视图解析器无法解析jsp,html页面*/
@Api(tags="员工接口")
@Controller
public class EmpController {

	//注入empservice
	@Autowired
	private EmpService empService;
	//注入deptService
	@Autowired
	private DeptService deptService;
	
	/**
	 * 查询：直接使用分页查询，这都是接口定义好的方法。不需要我们在写，方便。
	 */
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list(ModelMap map,@RequestParam(defaultValue="1",required=false,value="pageNo") Integer pageNo){
		Page<Emp> page = empService.getPage(pageNo, 3);
		map.put("page", page);
		return "emp";
	}
	
	/**
	 * 跳转到添加页面
	 */
	@RequestMapping(value="saveEmpPage",method=RequestMethod.GET)
	public String savePage(ModelMap map){
		List<Dept> depts = deptService.getListDepts();
		map.addAttribute("depts", depts);
		return "saveEmpPage";
	}

	/**
	 * 添加：ajax异步校验用户名是否存在
	 */
	@RequestMapping(value="/checkName",method=RequestMethod.POST)
	@ResponseBody
	public String checkName(String ename){
		Emp emp = empService.getByName(ename);
		System.out.println(emp);
		if(emp != null){
			return "1";
		}else{
			return "0";
		}
	}
	
	/**
	 * 添加
	 */
	@RequestMapping(value="/saveEmp",method=RequestMethod.POST)
	public String save(Emp emp){
		System.out.println(new Date());
		emp.setEid(3);
		emp.setTime(new Date());
		System.out.println(emp);
		empService.save(emp);
		return "redirect:/list";
	}
	/**
	 * 根据id查询
	 */
	@RequestMapping(value="/getById",method=RequestMethod.GET)
	public void getById(Integer eid){
		Emp emp = empService.getById(eid);
	}
	/**
	 * 跳转到修改页面
	 */
	@RequestMapping("/updatePage")
	public String updatePage(Integer eid,ModelMap map){
		//先查询
		Emp emp = empService.getById(eid);
		map.addAttribute("emp", emp);
		return "updatePage";
	}
	/**
	 * 修改
	 */
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(Emp emp,ModelMap map){
		empService.update(emp);
		return "redirect:/list";
	}
	/**
	 * 删除
	 */
	@RequestMapping(value="/deleteEmp",method=RequestMethod.GET)
	public String deleteEmp(Integer eid){
		empService.deleteEmp(eid);
		return "redirect:/list";
	}
	   @RequestMapping(value="/api", method=RequestMethod.POST)
	    @ApiOperation(value = "接口名/list", notes = "查询所有员工", httpMethod = "POST")
	    @ApiImplicitParams({
	            @ApiImplicitParam(name = "length",value = "参数1", required = true, paramType = "path"),
	            @ApiImplicitParam(name = "size",value = "参数2", required = true, paramType = "query"),
	            @ApiImplicitParam(name = "page",value = "参数3", required = true, paramType = "header"),
	            @ApiImplicitParam(name = "total",value = "参数4", required = true, paramType = "form"),
	            @ApiImplicitParam(name = "start",value = "参数5",dataType = "string", paramType = "body")
	    })
	    public String register(){
	        return "has permission";
	    }
	
}
