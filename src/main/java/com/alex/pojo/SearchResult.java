/**
 * 
 */
package com.alex.pojo;

import java.util.List;

/**
 * Solr���������
 * 
 * @author Alex
 *
 */
public class SearchResult
{
	// ����������б�
	private List<Region> regionList;
	// �ܼ�¼��
	private Long recordCount;
	// ��ҳ��
	private Long pageNumber;

	public SearchResult(List<Region> regionList,
			Long recordCount, Long pageNumber)
	{
		this.regionList = regionList;
		this.recordCount = recordCount;
		this.pageNumber = pageNumber;
	}

	public SearchResult()
	{
	}

	public List<Region> getRegionList()
	{
		return regionList;
	}

	public void setRegionList(List<Region> regionList)
	{
		this.regionList = regionList;
	}

	public Long getRecordCount()
	{
		return recordCount;
	}

	public void setRecordCount(Long recordCount)
	{
		this.recordCount = recordCount;
	}

	public Long getPageNumber()
	{
		return pageNumber;
	}

	public void setPageNumber(Long pageNumber)
	{
		this.pageNumber = pageNumber;
	}

}
