/**
 * 
 */
package com.alex.service;

import java.util.List;

import com.alex.pojo.Region;
import com.alex.pojo.SearchResult;

/**
 * 城市服务接口
 * 
 * @author Alex
 *
 */
public interface CityService
{
	/**
	 * 根据省份/自治区/直辖市/特别行政区名称获取相应城市/县名称
	 * 
	 * @param provience
	 *            省份/自治区/直辖市/特别行政区名称
	 * @return 对应的城市/县名称
	 */
	public List<Region> getCityByProvience(String provience);

	/**
	 * 根据输入的内容搜索城市/县
	 * 
	 * @param queryString
	 *            输入的搜索字词
	 * @return 带有搜索结果的对象
	 */
	public SearchResult searchByInput(String queryString);

	/**
	 * 根据输入的城市/县名称获得区域对象
	 * 
	 * @param cityName
	 *            要查询的城市/县名称
	 * @return 相应的区域对象
	 */
	public Region getCityCodeByName(String cityName);

}
