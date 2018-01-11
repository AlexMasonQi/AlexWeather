/**
 * 
 */
package com.alex.pojo;

/**
 * 省份城市Bean类
 * 
 * @author Alex
 *
 */
public class Region
{
	// id编号
	private Integer id;
	// 省份/自治区/直辖市/特别行政区名称
	private String provience;
	// 省份/自治区/直辖市/特别行政区编号
	private Integer procode;
	// 城市/县名称
	private String city;
	// 城市/县编号
	private Integer citycode;

	public Region(String provience, Integer procode,
			String city, Integer citycode)
	{
		this.provience = provience;
		this.procode = procode;
		this.city = city;
		this.citycode = citycode;
	}

	public Region()
	{
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getProvience()
	{
		return provience;
	}

	public void setProvience(String provience)
	{
		this.provience = provience;
	}

	public Integer getProcode()
	{
		return procode;
	}

	public void setProcode(Integer procode)
	{
		this.procode = procode;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public Integer getCitycode()
	{
		return citycode;
	}

	public void setCitycode(Integer citycode)
	{
		this.citycode = citycode;
	}

}
