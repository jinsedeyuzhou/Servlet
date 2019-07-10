package com.ebrightmoon.dao;

import java.util.List;
import com.ebrightmoon.bean.NewsFeed;


public interface NewsFeedDao {

	/**
	 * ��ȡ������������
	 * @return
	 */
	public List<NewsFeed> selectAllNews();

	/**
	 * @param bookid
	 * @return
	 * ��������id��ȡĳһ������
	 */
	public NewsFeed selectNewsById(Integer id);
	
	/**
	 * @return
	 * ��ȡ����ʮ������
	 */
	public List<NewsFeed> selectTenNews();
	
	/**
	 * ����һ������
	 * @param newsFeed
	 * @return
	 */
	public Integer insertNewsFeed(NewsFeed newsFeed);
}
