/**
 * 
 */
package com.alex.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.alex.pojo.Region;

/**
 * ���з���ӳ��ӿ�
 * 
 * @author Alex
 *
 */
public interface CityMapper
{
	/**
	 * ����ʡ��/������/ֱϽ��/�ر����������ƻ�ȡ��Ӧ����/������
	 * 
	 * @param provience
	 *            ʡ��/������/ֱϽ��/�ر�����������
	 * @return ��Ӧ�ĳ���/������
	 */
	public List<Region> getCityByProvience(String provience);

	/**
	 * ��������ĳ���/�����ƻ���������
	 * 
	 * @param proName
	 *            ʡ��/������/ֱϽ��/�ر�����������
	 * @param cityName
	 *            Ҫ��ѯ�ĳ���/������
	 * @return ��Ӧ���������
	 */
	public Region getCityCodeByName(@Param("provience") String proName, @Param("city") String cityName);
}
