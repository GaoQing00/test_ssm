package com.exe.ssm.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 全局异常处理器
 * @author Administrator
 *
 */
public class CustomExceptionResolver implements HandlerExceptionResolver {

	/**
	 * 	 @param ex 系统 抛出的异常
	 */
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		//handler就是处理器适配器要执行Handler对象（只有method）
		
		//解析出异常类型
		//如果该异常是系统自定义的异常，直接取出异常信息，在错误页面展示
//		String message = null;
//		if(ex instanceof CustomException){
//			message = ((CustomException)ex).getMessage();
//		}else{			
//			//如果该异常不是系统自定义的异常，构造一个自定义的异常类型（信息为"位置错误"）
//			message = "位置错误";
//		}
		
		//上边的代码变为
		CustomException customException = null;
		if(ex instanceof CustomException){
			customException = (CustomException)ex;
		}else{
			customException = new CustomException("未知错误");
		}
		//错误信息
		String message = customException.getMessage();
		
		ModelAndView modelAndView = new ModelAndView();
		//将错误信息传递到页面
		modelAndView.addObject("message",message);
		//指向错误页面
		modelAndView.setViewName("error");
		return modelAndView;
	}

	
}
