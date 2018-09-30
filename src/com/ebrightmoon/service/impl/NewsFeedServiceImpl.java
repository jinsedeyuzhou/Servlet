package com.ebrightmoon.service.impl;

import java.util.List;

import com.ebrightmoon.bean.NewsFeed;
import com.ebrightmoon.dao.NewsFeedDao;
import com.ebrightmoon.dao.impl.NewsFeedDaoImpl;
import com.ebrightmoon.service.NewsFeedService;

public class NewsFeedServiceImpl implements NewsFeedService {

	@Override
	public List<NewsFeed> findAllNews() {
		// TODO Auto-generated method stub
		NewsFeedDao newsFeedDao = new NewsFeedDaoImpl();
		return newsFeedDao.selectAllNews();
	}

	@Override
	public NewsFeed findNewsById(Integer bookid) {
		// TODO Auto-generated method stub
		NewsFeedDao newsFeedDao = new NewsFeedDaoImpl();
		return newsFeedDao.selectNewsById(bookid);
	}

	@Override
	public List<NewsFeed> findTenNews() {
		// TODO Auto-generated method stub
		NewsFeedDao newsFeedDao = new NewsFeedDaoImpl();
		return newsFeedDao.selectTenNews();
	}

}
