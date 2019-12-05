package com.ma.service;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
 
public class MyXmlServiceAop {
 
    public void beforeHandler(JoinPoint point) {
//        System.out.println("前置通知:" );
//        Object[] args= point.getArgs();
//        HttpServletRequest request=(HttpServletRequest)args[1];
//        
//     Cookie[] cookies= request.getCookies();
//       for (Cookie cookie : cookies) {
//    	   if(cookie.getName().equals(getMD5(args[0].toString()))){
//    		   cookie.setMaxAge(60*60);
//    			System.out.println(cookie.getName()+cookie.getValue());
//    	   }
//	
//	}
       
    }
 
    public void aroundHandler(ProceedingJoinPoint jointPoint) {
    	 final ExecutorService exec = Executors.newSingleThreadExecutor();
     	try {
     		
     		   Callable<String>  call = new Callable<String>(){
     	           
    	            public String call() throws Exception{
    	                //Thread.sleep(1000 * 5);
    	                System.out.println("环绕通知开始");
    	                try {
						 jointPoint.proceed();
						} catch (Throwable e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
    	             
    	                return "线程执行完";
    	            }
    	        };
         
         
             

 	        Future<String> future = exec.submit(call);
 	        String obj = null;
 	        try{
 	            obj = future.get(1000 * 6,TimeUnit.MILLISECONDS);
 	            System.out.print("任务成功返回"+obj);
 	        }catch(InterruptedException e){
 	            e.printStackTrace();
 	        }catch(ExecutionException e){
 	            e.printStackTrace();
 	        }catch(TimeoutException e){
 	            e.printStackTrace();
 	        }
 	        exec.shutdown();
         } catch (Throwable e) {
             
         }
        System.out.println("环绕通知结束");
    }
   /* public void afterHandler(HttpServletRequest request,String name) {
        System.out.println("后置通知");
        Cookie[] cookies= request.getCookies();
        for (Cookie cookie : cookies) {
     	   if(cookie.getName().equals(getMD5(name))){
     		   cookie.setMaxAge(60*60);
     			System.out.println(cookie.getName());
     	   }
 	
 	}
        
       // session.setMaxInactiveInterval(arg0);
    }*/
    public void throwExceptionHandler(Throwable ex) {
        System.out.println("异常通知:" + ex.getMessage());
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

