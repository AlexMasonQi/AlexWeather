/**
 * 
 */
package com.alex.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * ȫ���쳣����
 * 
 * @author Alex
 *
 */
public class CustomGlobalExceptionResolver
		implements HandlerExceptionResolver
{

	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object obj, Exception exception)
	{
		// �����쳣��Ϣ
		String message = "";

		// �ж��쳣����
		if (exception instanceof CustomException)
		{
			// ����ҵ�񼶱��쳣
			message = ((CustomException) exception).getMessage();
		}
		else
		{
			// ��������ʱ�쳣
			message = "��Ǹ...������һ��΢С�����⣬������ϵ����ԱѰ��������";
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("msg", message);
		modelAndView.setViewName("error");

		return modelAndView;
	}

}
