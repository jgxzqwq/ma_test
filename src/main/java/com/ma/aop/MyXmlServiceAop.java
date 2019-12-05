package com.ma.aop;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.aspectj.lang.ProceedingJoinPoint;
 
public class MyXmlServiceAop {
 
	 public void beforeHandler(String name, int age) {


	    	
	    	
	    }
	 
	    public void aroundHandler(ProceedingJoinPoint jointPoint) {
	       
	    	 final ExecutorService exec = Executors.newSingleThreadExecutor();
		     
		 
		    
	    	
	    	try {
	    		   Callable<String>  call = new Callable<String>(){
	    	           
	   	            public String call() throws Exception{
	   	                Thread.sleep(1000 * 5);
	   	                return "线程执行完";
	   	            }
	   	        };
	            System.out.println("环绕通知开始");
	            String name = (String) jointPoint.proceed();
	            jointPoint.proceed();
	            System.out.println(name + "环绕通知结束");
	            

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
	    }
	 
	    public void afterHandler() {
	        System.out.println("后置通知");
	    }
	    
	    public void returnHandler(Object name) { //在返回通知中获取返回值
	        System.out.println("返回通知:" + name);
	    }
	 
	    public void throwExceptionHandler(Throwable ex) {
	        System.out.println("异常通知:" + ex.getMessage());
	    }
	}

