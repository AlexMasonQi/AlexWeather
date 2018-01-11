/**
 * 
 */
package com.alex.exception;

/**
 * 自定义异常处理
 * 
 * @author Alex
 *
 */
public class CustomException extends Exception
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1025962215233159389L;

	private String message;

	@Override
	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

}
