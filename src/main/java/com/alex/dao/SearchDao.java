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
 * �����������ݼ���
 * 
 * @author Alex
 *
 */
public class SearchDao
{
	@Autowired
	private HttpSolrClient solrClient;

	/**
	 * ���������������������/��
	 * 
	 * @param query
	 *            ���������ִʵ�SolrQuery����
	 * @return ������������Ķ���
	 */
	public SearchResult searchByInput(SolrQuery query)
	{
		QueryResponse response = null;
		SearchResult searchResult = new SearchResult();
		try
		{
			// ִ�в�ѯ���õ���ѯ���
			response = solrClient.query(query);
			SolrDocumentList results = response.getResults();

			// ����������ܼ�¼��
			Long count = results.getNumFound();

			// �����б���װ��List<Region>������
			List<Region> regionList = new ArrayList<>();

			// ȡ������ʾ���
			Map<String, Map<String, List<String>>> highLightMap = response.getHighlighting();

			for (SolrDocument doc : results)
			{
				Region region = new Region();
				region.setId(Integer.valueOf((String) doc.getFieldValue("id")));
				region.setProvience((String) doc.getFieldValue("provience"));
				region.setProcode((Integer) doc.getFieldValue("procode"));

				// ȡ�������
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

			// ����SearchResult����
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
