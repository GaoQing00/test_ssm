package com.exe.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
/**
 * 测试拦截器1
 * 拦截器的机制是基于 aop 的
 * @author Administrator
 *
 */
public class LoginInterceptor implements HandlerInterceptor {

	//进入Handler方法之前执行
	//用于身份认证、身份授权
	//比如身份认证，如果认证不通过表示当前用户没有登陆，需要此方法拦截不再执行
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		//获取请求url
		String url = request.getRequestURI();
		//判断url是否是公开地址（实际使用时将公开地址配置在配置文件中）
		//这里公开地址时登陆提交地址
		if(url.indexOf("login.action")>=0){
			//如果进行登陆提交,放行
			return true;
		}
		//判断session
		HttpSession session = request.getSession();
		//从session中取出用户身份信息
		String username = (String) session.getAttribute("username");
		if(username!=null){
			//身份存在，放行
			return true;
		}
		
		//执行到这里表示用户身份需要认证，跳转到登陆页面
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		
		//这是错误的，视图解析器才加前后缀
		//request.getRequestDispatcher("login").forward(request, response);
		
		//return false 表示拦截，不向下执行
		//return true 表示执行
		return false;
	}

	//进入Handler方法之后，返回modelAndView之前
	//应用场景从modelAndView出发：将公用的模型数据（比如菜单导航）在这里传递视图，也可以在这里同一指定视图
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {
		
		System.out.println("LoginInterceptor-->postHandle");
		
		
	}
	
	//执行Handler完成，执行此方法
	//应用场景：统一异常处理，统一日志处理
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception modelAndView)
			throws Exception {
		
		System.out.println("LoginInterceptor-->afterCompletion");
		
	}


}
