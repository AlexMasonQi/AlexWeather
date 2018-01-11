/**
 * 
 */
package com.alex.service;

import java.util.List;

import com.alex.pojo.Region;
import com.alex.pojo.SearchResult;

/**
 * ���з���ӿ�
 * 
 * @author Alex
 *
 */
public interface CityService
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
	 * ���������������������/��
	 * 
	 * @param queryString
	 *            ����������ִ�
	 * @return ������������Ķ���
	 */
	public SearchResult searchByInput(String queryString);

	/**
	 * ��������ĳ���/�����ƻ���������
	 * 
	 * @param cityName
	 *            Ҫ��ѯ�ĳ���/������
	 * @return ��Ӧ���������
	 */
	public Region getCityCodeByName(String cityName);

}
