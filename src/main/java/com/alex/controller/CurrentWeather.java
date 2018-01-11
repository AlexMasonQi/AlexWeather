/**
 * 
 */
package com.alex.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.alex.pojo.Region;
import com.alex.pojo.SearchResult;
import com.alex.pojo.WeatherInfo;
import com.alex.service.CityService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * 当前地区天气
 * 
 * @author Alex
 *
 */
@Controller
@RequestMapping("/current")
public class CurrentWeather
{
	private final String REST_SERVICE_URI = "http://restapi.amap.com/v3/weather/weatherInfo";

	@Autowired
	private CityService cityService;

	@RequestMapping("/test")
	public String test()
	{
		return "test";
	}

	/**
	 * 根据省份/自治区/直辖市/特别行政区名称获取相应城市/县名称
	 * 
	 * @param provience
	 *            省份/自治区/直辖市/特别行政区名称
	 * @return 相应的城市/县名称集合
	 */
	@RequestMapping("/selectcity")
	@ResponseBody
	public List<Region> getCityByProvience(@RequestBody String provience)
	{
		List<Region> regionList = null;
		try
		{
			String pro = URLDecoder.decode(provience, "utf-8");
			pro = pro.substring(pro.lastIndexOf("=") + 1);
			regionList = cityService.getCityByProvience(pro);
		}
		catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}

		return regionList;
	}

	/**
	 * 根据输入的内容列出可能的搜索结果
	 * 
	 * @param inputValue
	 *            输入的要搜索的内容
	 * @return 可能的搜索结果
	 */
	@RequestMapping("/search")
	@ResponseBody
	public List<Region> searchCity(@RequestBody String inputValue)
	{
		inputValue = inputValue.substring(inputValue.lastIndexOf("=") + 1);
		List<Region> resultList = null;
		try
		{
			String queryValue = URLDecoder.decode(inputValue, "utf-8");
			SearchResult searchResult = cityService.searchByInput(queryValue);
			resultList = new ArrayList<>();
			for (Region region : searchResult.getRegionList())
			{
				resultList.add(region);
			}
		}
		catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}

		return resultList;
	}

	@RequestMapping("/query")
	@ResponseBody
	public WeatherInfo getWeatherByCity(@RequestBody String city)
	{
		// 获取输入值
		city = city.substring(city.lastIndexOf("=") + 1);
		WeatherInfo weaInfo = null;

		try
		{
			String city_name = URLDecoder.decode(city, "utf-8");
			Region region = cityService.getCityCodeByName(city_name);

			// 解析天气数据
			RestTemplate restTemplate = new RestTemplate();
			String weatherInfo = restTemplate.getForObject(REST_SERVICE_URI + "?city={1}&key={2}", String.class, region.getCity(), "9efdbebd516eaa5bba01f70e74b3a589");
			JSONObject jsonObj = JSON.parseObject(weatherInfo);
			JSONArray arr = jsonObj.getJSONArray("lives");

			JSONObject info = null;

			// 判断输入地址或定位地址是否重名
			if (arr.size() > 1)
			{
				// 如果重名
				for (int i = 0; i < arr.size(); i++)
				{
					JSONObject tmpRegion = arr.getJSONObject(i);
					if (tmpRegion.getString("province").equals(region.getProvience()))
					{
						info = tmpRegion;
						break;
					}
				}
			}
			else
			{
				info = arr.getJSONObject(0);
			}

			// 封装对象
			weaInfo = new WeatherInfo();
			weaInfo.setProvience(info.getString("province"));
			weaInfo.setCityName(info.getString("city"));
			weaInfo.setWeather(info.getString("weather"));
			weaInfo.setTemperature(Integer.valueOf(info.getString("temperature")));
			weaInfo.setWindDir(info.getString("winddirection"));
			weaInfo.setWindPower(info.getString("windpower"));
			weaInfo.setHumidity(Integer.valueOf(info.getString("humidity")));
			weaInfo.setReportTime(info.getString("reporttime"));
		}
		catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
		return weaInfo;
	}

}
