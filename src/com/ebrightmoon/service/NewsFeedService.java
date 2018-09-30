package com.ebrightmoon.service;

import java.util.List;

import com.ebrightmoon.bean.NewsFeed;

public interface NewsFeedService {
	
	

	/**
	 * ��ȡ������������
	 * @return
	 */
	public List<NewsFeed> findAllNews();

	/**
	 * @param bookid
	 * @return
	 * ��������id��ȡĳһ������
	 */
	public NewsFeed findNewsById(Integer bookid);
	
	/**
	 * @return
	 * ��ȡ����ʮ������
	 */
	public List<NewsFeed> findTenNews();
	

}
