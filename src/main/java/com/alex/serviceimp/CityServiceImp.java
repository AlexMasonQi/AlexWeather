/**
 * 
 */
package com.alex.serviceimp;

import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alex.dao.CityMapper;
import com.alex.dao.SearchDao;
import com.alex.pojo.Region;
import com.alex.pojo.SearchResult;
import com.alex.service.CityService;

/**
 * ���з���ʵ����
 * 
 * @author Alex
 *
 */
@Service
public class CityServiceImp implements CityService
{
	@Autowired
	private CityMapper cityMapper;

	@Autowired
	private SearchDao searchDao;

	private final Integer ROWS = 10;

	@Override
	public List<Region> getCityByProvience(String provience)
	{
		return cityMapper.getCityByProvience(provience);
	}

	@Override
	public SearchResult searchByInput(String queryString)
	{
		// ����SolrQuery����
		SolrQuery query = new SolrQuery();
		queryString = "*" + queryString + "*";

		// ������������
		if (queryString != null && !"".equals(queryString))
		{
			query.setQuery(queryString);
		}
		else
		{
			query.setQuery("*:*");
		}

		// ���÷�ҳ
		query.setStart(0);
		query.setRows(ROWS);

		// ����Ĭ��������
		query.set("df", "city");

		// ����������ʾ
		query.setHighlight(true);

		// ���ø����ֶ�
		query.addHighlightField("city");

		// ���ø���ǰ��׺
		query.setHighlightSimplePre("<em style='color:red;'>"); // ǰ׺
		query.setHighlightSimplePost("</em>"); // ��׺

		// ����dao�㷽�������SearchResult����
		SearchResult result = searchDao.searchByInput(query);

		// �����������Ŀ
		Long count = result.getRecordCount();

		// ������ҳ��
		Long pageCount = count / ROWS;
		if (count % ROWS > 0)
		{
			pageCount++;
		}

		result.setPageNumber(pageCount);

		return result;
	}

	@Override
	public Region getCityCodeByName(String cityName)
	{
		String[] regionArr = cityName.split(":");
		return cityMapper.getCityCodeByName(regionArr[0], regionArr[1]);
	}

}
