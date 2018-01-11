/**
 * 
 */
package com.alex.pojo;

import java.util.List;

/**
 * Solr搜索结果类
 * 
 * @author Alex
 *
 */
public class SearchResult
{
	// 搜索结果集列表
	private List<Region> regionList;
	// 总记录数
	private Long recordCount;
	// 总页数
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
