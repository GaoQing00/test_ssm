package com.exe.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
/**
 * 测试拦截器1
 * 拦截器的机制是基于 aop 的
 * @author Administrator
 *
 */
public class HandlerInterceptor2 implements HandlerInterceptor {

	//进入Handler方法之前执行
	//用于身份认证、身份授权
	//比如身份认证，如果认证不通过表示当前用户没有登陆，需要此方法拦截不再执行
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		System.out.println("第2个拦截器HandlerInterceptor1-->preHandle");
		
		//return false 表示拦截，不向下执行
		//return true 表示执行
		return true;
	}

	//进入Handler方法之后，返回modelAndView之前
	//应用场景从modelAndView出发：将公用的模型数据（比如菜单导航）在这里传递视图，也可以在这里同一指定视图
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {
		
		System.out.println("第2个拦截器HandlerInterceptor1-->postHandle");
		
		
	}
	
	//执行Handler完成，执行此方法
	//应用场景：统一异常处理，统一日志处理
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception modelAndView)
			throws Exception {
		
		System.out.println("第2个拦截器HandlerInterceptor1-->afterCompletion");
		
	}


}
