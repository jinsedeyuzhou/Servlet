package com.ebrightmoon.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.ebrightmoon.bean.NewsFeed;
import com.ebrightmoon.dao.NewsFeedDao;
import com.ebrightmoon.utils.JDBCHelper;


public class NewsFeedDaoImpl implements NewsFeedDao {

	@Override
	public List<NewsFeed> selectAllNews() {
		// TODO Auto-generated method stub
		try {
			String sql = "SELECT * FROM news_feed";
			QueryRunner runner = new QueryRunner(JDBCHelper.getDataSource());
			List<NewsFeed> newsFeeds = runner.query(sql, new BeanListHandler<NewsFeed>(NewsFeed.class));
			return newsFeeds;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public NewsFeed selectNewsById(Integer feedId) {
		// TODO Auto-generated method stub
		try {
			String sql = "SELECT * FROM news_feed WHERE feed_id=? ";
			QueryRunner runner = new QueryRunner(JDBCHelper.getDataSource());
			NewsFeed newsFeed = runner.query(sql, new BeanHandler<NewsFeed>(NewsFeed.class),feedId);
			return newsFeed;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<NewsFeed> selectTenNews() {
		// TODO Auto-generated method stub
		
		try {
			String sql = "SELECT * FROM news_feed ORDER BY update_time DESC LIMIT 10";
			QueryRunner runner = new QueryRunner(JDBCHelper.getDataSource());
			List<NewsFeed> newsFeeds = runner.query(sql, new BeanListHandler<NewsFeed>(NewsFeed.class));
			return newsFeeds;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
