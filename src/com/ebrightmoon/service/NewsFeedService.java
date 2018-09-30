package com.ebrightmoon.service;

import java.util.List;

import com.ebrightmoon.bean.NewsFeed;

public interface NewsFeedService {
	
	

	/**
	 * 获取所有新闻数据
	 * @return
	 */
	public List<NewsFeed> findAllNews();

	/**
	 * @param bookid
	 * @return
	 * 根据新闻id获取某一条数据
	 */
	public NewsFeed findNewsById(Integer bookid);
	
	/**
	 * @return
	 * 获取最新十条数据
	 */
	public List<NewsFeed> findTenNews();
	

}
