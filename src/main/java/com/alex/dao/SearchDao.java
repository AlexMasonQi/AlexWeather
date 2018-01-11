/**
 * 
 */
package com.alex.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;

import com.alex.pojo.Region;
import com.alex.pojo.SearchResult;

/**
 * 根据输入内容检索
 * 
 * @author Alex
 *
 */
public class SearchDao
{
	@Autowired
	private HttpSolrClient solrClient;

	/**
	 * 根据输入的内容搜索城市/县
	 * 
	 * @param query
	 *            带有搜索字词的SolrQuery对象
	 * @return 带有搜索结果的对象
	 */
	public SearchResult searchByInput(SolrQuery query)
	{
		QueryResponse response = null;
		SearchResult searchResult = new SearchResult();
		try
		{
			// 执行查询，得到查询结果
			response = solrClient.query(query);
			SolrDocumentList results = response.getResults();

			// 搜索结果的总记录数
			Long count = results.getNumFound();

			// 城市列表，封装到List<Region>集合中
			List<Region> regionList = new ArrayList<>();

			// 取高亮显示结果
			Map<String, Map<String, List<String>>> highLightMap = response.getHighlighting();

			for (SolrDocument doc : results)
			{
				Region region = new Region();
				region.setId(Integer.valueOf((String) doc.getFieldValue("id")));
				region.setProvience((String) doc.getFieldValue("provience"));
				region.setProcode((Integer) doc.getFieldValue("procode"));

				// 取高亮结果
				List<String> highLightList = highLightMap.get(doc.getFieldValue("id")).get("city");
				String cityName = null;
				if (highLightList != null && highLightList.size() > 0)
				{
					cityName = highLightList.get(0);
				}
				else
				{
					cityName = (String) doc.getFieldValue("city");
				}
				region.setCity(cityName);
				region.setCitycode((Integer) doc.getFieldValue("citycode"));

				regionList.add(region);
			}

			// 设置SearchResult对象
			searchResult.setRegionList(regionList);
			searchResult.setRecordCount(count);
		}
		catch (SolrServerException | IOException e)
		{
			e.printStackTrace();
		}

		return searchResult;
	}
}
