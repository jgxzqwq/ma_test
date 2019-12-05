package com.ma.controller;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.ma.entity.User;
import com.ma.service.MailboxService;
import com.ma.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller
@Api(tags="用户接口")
public class UserController {
	// private static Cookie cookie;
	
	@Autowired
	private UserService userService;
	@Autowired
	private MailboxService mailboxService;
	
	/*
	 * 
	 * 注意：@ApiImplicitParam的参数说明：

paramType：指定参数放在哪个地方	
header：请求参数放置于Request Header，使用@RequestHeader获取

query：请求参数放置于请求地址，使用@RequestParam获取

path：（用于restful接口）-->请求参数的获取：@PathVariable

body：（不常用）

form（不常用）

name：参数名	 
dataType：参数类型	 
required：参数是否必须传	true | false
value：说明参数的意思	 
defaultValue：参数的默认值	  
	 * */
	  @ApiOperation(value = "接口名/getMailbox", notes = "获取邮箱", httpMethod = "POST")
	    @ApiImplicitParams({
	    	@ApiImplicitParam(name = "Mailbox",value = "邮箱的账号", required = true, paramType = "query"),
          @ApiImplicitParam(name = "request",value = "HttpServletRequest", required = false, paramType = "defaultValue"),
          @ApiImplicitParam(name = "response",value = "HttpServletResponse", required = false, paramType = "defaultValue")
	           
	          
	    })
	
	@RequestMapping(value={"/getMailbox"},method=RequestMethod.POST)
	public @ResponseBody String getMailbox(@RequestParam  String Mailbox,HttpServletRequest request,HttpServletResponse response) {
		Map map=new HashMap();
		Gson gson=new Gson();
		try{
			
		mailboxService.doPost(request,response, "1727056218@qq.com", "kwtoisrxejdpcgdi", "smtp.qq.com", Mailbox);
		
//		response.setHeader("Access-Control-Allow-Origin", "*");//设置可跨域资源共享的域名，只能设置一个具体的域名，但*可以代表所有
//		response.setHeader("Access-Control-Allow-Methods","GET,POST,PUT,OPTIONS");//设置可跨域资源共享的请求方式
//	        response.setHeader("Access-Control-Allow-Credentials","true");
//	        response.setHeader("Access-Control-Allow-Headers" ,"Origin, X-Requested-With, Content-Type, Accept");
		map.put("code", 200);
		}catch (Exception e) {
			// TODO: handle exception
			map.put("code", 5000);
		}
		
		return gson.toJson(map);
	}
	
	  @ApiOperation(value = "接口名/updateUser", notes = "更改用户", httpMethod = "PUT")
	    @ApiImplicitParams({
	    	@ApiImplicitParam(name = "account",value = "用户的名字", required = true, paramType = "query"),
            @ApiImplicitParam(name = "password",value = "用户的密码", required = true, paramType = "query")
	           
	          
	    })
	
	@RequestMapping(value={"/updateUser"},method=RequestMethod.PUT)
	public @ResponseBody String updateUser(@RequestParam  String account,@RequestParam String password) {
		Map map=new HashMap();
		Gson gson=new Gson();
		try{
		password=getMD5(password);
		userService.updateUser(account, password);
		map.put("code", 200);
		}catch (Exception e) {
			// TODO: handle exception
			map.put("code", 5000);
		}
		
		return gson.toJson(map);
	}
	

	  @ApiOperation(value = "接口名/getCode", notes = "校验验证码", httpMethod = "POST")
	    @ApiImplicitParams({
	    	   @ApiImplicitParam(name = "Code",value = "验证码", required = true, paramType = "query"),
	          
	    })
	@RequestMapping(value={"/getCode"},method=RequestMethod.POST)
	public @ResponseBody String getCode(@RequestParam  String Code,HttpServletRequest sd) {
		

		Map map=new HashMap();
		Gson gson=new Gson();
	
		String sessionCode = (String) sd.getSession().getAttribute("code");
		System.out.println("sdfsdfsdfsdf"+sd.getSession().getAttribute("code"));
		
		if(sessionCode != null) {
			//  获取页面提交的验证码
			String inputCode = Code;
			System.out.println("页面提交的验证码:" + inputCode);
			if (sessionCode.toLowerCase().equals(inputCode.toLowerCase())) {
				map.put("code", 200);
			}else {
				//  验证失败
				map.put("code", 4000);
			}
		}else {
			//  验证失败
			map.put("code", 5000);
		}
		//  移除session中的验证码
		sd.removeAttribute("code");
		return gson.toJson(map);
	}
	
	  

	  @ApiOperation(value = "接口名/fineone", notes = "通过id获取用户", httpMethod = "GET")
	    @ApiImplicitParams({
	    	   @ApiImplicitParam(name = "id",value = "用户的id", required = true, paramType = "query"),
	          
	    })
	@RequestMapping(value={"/fineone"},method=RequestMethod.GET)
	public @ResponseBody String fineone(@RequestParam  Integer id) {
		
		Gson gson=new Gson();
		Map map=new HashMap();
		try{
		User user=userService.findOne(id);
		map.put("code", 200);
		map.put("user", user);
		}catch (Exception e) {
			// TODO: handle exception
			map.put("code", 5000);
		}
		
		return gson.toJson(map);
	}
	
	  @ApiOperation(value = "接口名/getName", notes = "通过名字获取用户", httpMethod = "GET")
	    @ApiImplicitParams({
	    	   @ApiImplicitParam(name = "account",value = "用户的名字", required = true, paramType = "query"),
	          
	    })
	@RequestMapping(value={"/getName"},method=RequestMethod.GET)
	public @ResponseBody String getName(@RequestParam  String account) {
		
		Gson gson=new Gson();
		Map map=new HashMap();
		try{
		User user=userService.getName(account);
		map.put("code", 200);
		map.put("user", user);
		}catch (Exception e) {
			// TODO: handle exception
			map.put("code", 5000);
		}
		
		return gson.toJson(map);
	}
	
	
	  @ApiOperation(value = "接口名/getUser", notes = "匹配用户", httpMethod = "GET")
	    @ApiImplicitParams({
	    	   @ApiImplicitParam(name = "account",value = "用户的名字", required = true, paramType = "query"),
	            @ApiImplicitParam(name = "password",value = "用户的密码", required = true, paramType = "query")
	          
	    })
	 /*   @ApiResponses({
	        @ApiResponse(code=4000,message="验证失败"),
	        @ApiResponse(code=200,message="成功"),
	        @ApiResponse(code=5000,message="后台错误")
	    })*/
	
	@RequestMapping(value={"/getUser"},method=RequestMethod.GET)
	public @ResponseBody String getUser(@RequestParam  String account,@RequestParam String password,HttpServletResponse response) {
		
		Gson gson=new Gson();
		Map map=new HashMap();	
		try{
		password=getMD5(password);
		User user=userService.getUser(account,password);
		map.put("code", 200);
		map.put("user", user);
		
		
		
		System.out.println(user.getAccount());
		System.out.println(user.getAccount().replaceAll(" ", ""));
		Cookie  cookie = new Cookie(getMD5(user.getAccount()),getMD5(user.getAccount()));
		
		//设置Cookie最大生存时间,以秒为单位,负数的话为浏览器进程,关闭浏览器Cookie消失 
		 cookie.setMaxAge(60*60);//设置cookie过期时间为1个小时
		//设置路径，这个路径即该工程下都可以访问该cookie 如果不设置路径，那么只有设置该cookie路径及其子路径可以访问
		cookie.setPath("/");
		cookie.setDomain("ma.xiaomy.net");
		// 将Cookie添加到Response中,使之生效 
		response.addCookie(cookie);
		System.out.println(cookie);
	    /* Cookie[] cookies = request.getCookies();//这样便可以获取一个cookie数组  
            if (null==cookies) {  
                System.out.println("没有cookie=========");  
            } else {  
                for(Cookie cookie2 : cookies){  
                    System.out.println("name:"+cookie2.getName()+",value:"+ cookie2.getValue());  
                }  
            }  
		*/
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			map.put("code", 5000);
		}
		
		return gson.toJson(map);
	}
	  
	  @ApiOperation(value = "接口名/setUser", notes = "新建用户", httpMethod = "POST")
	    @ApiImplicitParams({
	    	   @ApiImplicitParam(name = "user",value = "用户的对象", required = true, paramType = "body")
	           
	          
	    })
	 /*   @ApiResponses({
	        @ApiResponse(code=4000,message="验证失败"),
	        @ApiResponse(code=200,message="成功"),
	        @ApiResponse(code=5000,message="后台错误")
	    })*/
	  
	@RequestMapping(value={"/setUser"},method=RequestMethod.POST)
	public @ResponseBody String setUser(@RequestBody User user) {
		
		Gson gson=new Gson();
		Map map=new HashMap();
		try{
		user.setPassword(getMD5(user.getPassword()));
		
		userService.save(user);
		map.put("code", 200);
		map.put("user", user);
		}catch (Exception e) {
			// TODO: handle exception
			map.put("code", 5000);
		}
		
		return gson.toJson(map);
	}
	
  

	static private String getMD5(String password){
	      StringBuffer buf = new StringBuffer("");
		try {
	          MessageDigest md = MessageDigest.getInstance("MD5");//1.初始化MessageDigest信息摘要对象,并指定为MD5不分大小写都可以
	          md.update(password.getBytes());//2.传入需要计算的字符串更新摘要信息，传入的为字节数组byte[],将字符串转换为字节数组使用getBytes()方法完成
	          byte b[] = md.digest();//3.计算信息摘要digest()方法,返回值为字节数组

	          int i;//定义整型
	        //声明StringBuffer对象
	    
	          for (int offset = 0; offset < b.length; offset++) {
	            i = b[offset];//将首个元素赋值给i
	            if (i < 0)
	              i += 256;
	            if (i < 16)
	              buf.append("0");//前面补0
	            buf.append(Integer.toHexString(i));//转换成16进制编码
	          }
	     
	         /* System.out.println("MD5(" + password + ",32) = " + buf.toString());//输出32位16进制字符串
	          System.out.println("MD5(" + password + ",16) = " +buf.toString().substring(8, 24 ));//输出16位16进制字符串*/	      
	          } catch (NoSuchAlgorithmException e) {
	          System.out.println(e);
	        }
		  return buf.toString().substring(8, 24);
 }
}

