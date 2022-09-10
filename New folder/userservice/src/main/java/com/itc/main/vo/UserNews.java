package com.itc.main.vo;

import com.itc.main.entity.User;

public class UserNews {

	private User user;
	private News[] news;
	public UserNews() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserNews(User user, News[] news) {
		super();
		this.user = user;
		this.news = news;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public News[] getNews() {
		return news;
	}
	public void setNews(News[] news) {
		this.news = news;
	}
	
}
