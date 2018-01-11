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
 * 城市服务实现类
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
		// 创建SolrQuery对象
		SolrQuery query = new SolrQuery();
		queryString = "*" + queryString + "*";

		// 设置搜索条件
		if (queryString != null && !"".equals(queryString))
		{
			query.setQuery(queryString);
		}
		else
		{
			query.setQuery("*:*");
		}

		// 设置分页
		query.setStart(0);
		query.setRows(ROWS);

		// 设置默认搜索域
		query.set("df", "city");

		// 开启高亮显示
		query.setHighlight(true);

		// 设置高亮字段
		query.addHighlightField("city");

		// 设置高亮前后缀
		query.setHighlightSimplePre("<em style='color:red;'>"); // 前缀
		query.setHighlightSimplePost("</em>"); // 后缀

		// 调用dao层方法，获得SearchResult对象
		SearchResult result = searchDao.searchByInput(query);

		// 获得总搜索数目
		Long count = result.getRecordCount();

		// 计算总页数
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
