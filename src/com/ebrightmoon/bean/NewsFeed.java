package com.ebrightmoon.bean;

import java.sql.Timestamp;

/**
 * @author Administrator
 * 
 */
public class NewsFeed {
	private int feedId;
	private String feedTitle;
	private String feedUrl;
	private String feedImg;
	private Timestamp updateTime;
	private String feedTopic;
	private int feedType;
	private String feedThumbnail;

	public String getFeedThumbnail() {
		return feedThumbnail;
	}

	public void setFeedThumbnail(String feedThumbnail) {
		this.feedThumbnail = feedThumbnail;
	}

	public int getFeedId() {
		return feedId;
	}

	public void setFeedId(int feedId) {
		this.feedId = feedId;
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



	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
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
