/**
 * 
 */
package com.alex.pojo;

/**
 * ������ϢBean��
 * 
 * @author Alex
 *
 */
public class WeatherInfo
{
	// ����ʡ��
	private String provience;
	// ��������
	private String cityName;
	// ����
	private String weather;
	// �¶�
	private Integer temperature;
	// ����
	private String windDir;
	// ����(��λ����)
	private String windPower;
	// ����ʪ��
	private Integer humidity;
	// ������ʱ��
	private String reportTime;

	public WeatherInfo(String provience, String cityName,
			String weather, Integer temperature,
			String windDir, String windPower,
			Integer humidity, String reportTime)
	{
		this.provience = provience;
		this.cityName = cityName;
		this.weather = weather;
		this.temperature = temperature;
		this.windDir = windDir;
		this.windPower = windPower;
		this.humidity = humidity;
		this.reportTime = reportTime;
	}

	public WeatherInfo()
	{
	}

	public String getProvience()
	{
		return provience;
	}

	public void setProvience(String provience)
	{
		this.provience = provience;
	}

	public String getCityName()
	{
		return cityName;
	}

	public void setCityName(String cityName)
	{
		this.cityName = cityName;
	}

	public String getWeather()
	{
		return weather;
	}

	public void setWeather(String weather)
	{
		this.weather = weather;
	}

	public Integer getTemperature()
	{
		return temperature;
	}

	public void setTemperature(Integer temperature)
	{
		this.temperature = temperature;
	}

	public String getWindDir()
	{
		return windDir;
	}

	public void setWindDir(String windDir)
	{
		this.windDir = windDir;
	}

	public String getWindPower()
	{
		return windPower;
	}

	public void setWindPower(String windPower)
	{
		this.windPower = windPower;
	}

	public Integer getHumidity()
	{
		return humidity;
	}

	public void setHumidity(Integer humidity)
	{
		this.humidity = humidity;
	}

	public String getReportTime()
	{
		return reportTime;
	}

	public void setReportTime(String reportTime)
	{
		this.reportTime = reportTime;
	}

	@Override
	public String toString()
	{
		return "provience=" + provience + ", cityName=" + cityName + ", weather=" + weather + ", temperature=" + temperature + ", windDir=" + windDir + ", windPower=" + windPower + ", humidity=" + humidity + ", reportTime=" + reportTime;
	}

}
