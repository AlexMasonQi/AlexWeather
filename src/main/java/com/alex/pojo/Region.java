/**
 * 
 */
package com.alex.pojo;

/**
 * ʡ�ݳ���Bean��
 * 
 * @author Alex
 *
 */
public class Region
{
	// id���
	private Integer id;
	// ʡ��/������/ֱϽ��/�ر�����������
	private String provience;
	// ʡ��/������/ֱϽ��/�ر����������
	private Integer procode;
	// ����/������
	private String city;
	// ����/�ر��
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
