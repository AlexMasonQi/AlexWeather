/**
 * 
 */
package com.alex.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.alex.pojo.Region;

/**
 * 城市服务映射接口
 * 
 * @author Alex
 *
 */
public interface CityMapper
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
	 * 根据输入的城市/县名称获得区域对象
	 * 
	 * @param proName
	 *            省份/自治区/直辖市/特别行政区名称
	 * @param cityName
	 *            要查询的城市/县名称
	 * @return 相应的区域对象
	 */
	public Region getCityCodeByName(@Param("provience") String proName, @Param("city") String cityName);
}
