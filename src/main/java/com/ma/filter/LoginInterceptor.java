package com.ma.filter;
 
import java.io.IOException;
 
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.filter.OncePerRequestFilter;
 

 

 
/**
 * 登录过滤器
 * <功能详细描述>
 * 
 * 
 */
public class LoginInterceptor extends OncePerRequestFilter
{
    
    /** 登录验证过滤器 */
    
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
        throws ServletException, IOException
    {
        // 不过滤的uri
        String[] notFilter = new String[] {"/index.html","/asd.html","/login","img/profilePhoto","js/","css/"};
        
        // 请求的uri
        String uri = request.getRequestURI();
        System.out.println(uri);
        // 是否过滤
        boolean doFilter = true;
        for (String s : notFilter)
        {
        	
            if (uri.indexOf(s) != -1)
            {
            	System.out.println(s);
                // 如果uri中包含不过滤的uri，则不进行过滤
                doFilter = false;
                break;
            }
        }
        
        if (doFilter)
        {
            // 执行过滤
            // 从session中获取登录者实体
        	System.out.println("2222");
            Object obj = request.getSession().getAttribute("user");
            System.out.println(obj);
            if (null == obj)
            {
                boolean isAjaxRequest = isAjaxRequest(request);
                if (isAjaxRequest)
                {
                    response.setCharacterEncoding("UTF-8");
                    //向页面发送错误信息
                    response.sendError(HttpStatus.UNAUTHORIZED.value(), "您已经太长时间没有操作,请刷新页面");
                    return ;
                }

                response.sendRedirect("../ma/index.html");
                return;
            }
            else
            {
                // 如果session中存在登录者实体，则继续
                filterChain.doFilter(request, response);
            }
        }
        else
        {
        
        	System.out.println("111");
            // 如果不执行过滤，则继续
            filterChain.doFilter(request, response);
        }
    }
    
    /** 判断是否为Ajax请求 
     * <功能详细描述>
     * @param request
     * @return 是true, 否false 
     * @see [类、类#方法、类#成员]
     */
    public static boolean isAjaxRequest(HttpServletRequest request)
    {
        String header = request.getHeader("X-Requested-With"); 
        if (header != null && "XMLHttpRequest".equals(header)) 
            return true; 
        else 
            return false;  
    }
    
}
