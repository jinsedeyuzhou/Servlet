package com.ebrightmoon.bean;

/**
 * @author Administrator
 * 
 */
public class NewsFeed {
	private int id;
	private String feedTitle;
	private String feedUrl;
	private String feedImg;
	private long createTime;
	private String feedTopic;
	private int feedType;
	private String feedThumbnail;

	public String getFeedThumbnail() {
		return feedThumbnail;
	}

	public void setFeedThumbnail(String feedThumbnail) {
		this.feedThumbnail = feedThumbnail;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFeedTitle() {
		return feedTitle;
	}

	public void setFeedTitle(String feedTitle) {
		this.feedTitle = feedTitle;
	}

	public String getFeedUrl() {
		return feedUrl;
	}

	public void setFeedUrl(String feedUrl) {
		this.feedUrl = feedUrl;
	}

	public String getFeedImg() {
		return feedImg;
	}

	public void setFeedImg(String feedImg) {
		this.feedImg = feedImg;
	}

	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}

	public String getFeedTopic() {
		return feedTopic;
	}

	public void setFeedTopic(String feedTopic) {
		this.feedTopic = feedTopic;
	}

	public int getFeedType() {
		return feedType;
	}

	public void setFeedType(int feedType) {
		this.feedType = feedType;
	}

}
