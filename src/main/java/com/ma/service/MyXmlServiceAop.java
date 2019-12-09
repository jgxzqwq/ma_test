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
        System.out.println("前置通知:" );
       Object[] args= point.getArgs();
       
       for(int i=0;i<args.length;i++){
    	   if(args[i] instanceof HttpServletRequest){
    		   HttpServletRequest request=(HttpServletRequest)args[i];
    		   request.getSession().setMaxInactiveInterval(60*60);;
    		   Cookie[] cookies= request.getCookies();
    	       for (Cookie cookie : cookies) {
    	   	   if(cookie.getName().equals("user")){
    	   		   cookie.setMaxAge(60*60);
    	    			System.out.println(cookie.getName()+cookie.getValue());
    	    	   }

    		}
    		   
    	   }
       }
      
       
  
       
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
    
    
    
   
	}

