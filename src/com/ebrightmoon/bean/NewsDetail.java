package com.ebrightmoon.bean;

/**
 * @author Administrator
 */
public class NewsDetail {
	
	private int deTailId;
	private int newsId;
	private NewsFeed newsFeed;
	private String content;
	public int getDeTailId() {
		return deTailId;
	}
	public void setDeTailId(int deTailId) {
		this.deTailId = deTailId;
	}
	public int getNewsId() {
		return newsId;
	}
	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}
	public NewsFeed getNewsFeed() {
		return newsFeed;
	}
	public void setNewsFeed(NewsFeed newsFeed) {
		this.newsFeed = newsFeed;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	
}
