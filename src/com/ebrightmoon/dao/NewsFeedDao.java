package com.ebrightmoon.dao;

import java.util.List;
import com.ebrightmoon.bean.NewsFeed;


public interface NewsFeedDao {

	/**
	 * 获取所有新闻数据
	 * @return
	 */
	public List<NewsFeed> selectAllNews();

	/**
	 * @param bookid
	 * @return
	 * 根据新闻id获取某一条数据
	 */
	public NewsFeed selectNewsById(Integer bookid);
	
	/**
	 * @return
	 * 获取最新十条数据
	 */
	public List<NewsFeed> selectTenNews();
	
	/**
	 * 新增一条新闻
	 * @param newsFeed
	 * @return
	 */
	public Integer insertNewsFeed(NewsFeed newsFeed);
}
