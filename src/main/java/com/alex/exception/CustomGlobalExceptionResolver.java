/**
 * 
 */
package com.alex.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 全局异常处理
 * 
 * @author Alex
 *
 */
public class CustomGlobalExceptionResolver
		implements HandlerExceptionResolver
{

	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object obj, Exception exception)
	{
		// 保存异常信息
		String message = "";

		// 判断异常类型
		if (exception instanceof CustomException)
		{
			// 处理业务级别异常
			message = ((CustomException) exception).getMessage();
		}
		else
		{
			// 处理运行时异常
			message = "抱歉...出现了一点微小的问题，请您联系管理员寻求解决方案";
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("msg", message);
		modelAndView.setViewName("error");

		return modelAndView;
	}

}
