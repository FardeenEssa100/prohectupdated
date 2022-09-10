package com.itc.main.vo;

import com.itc.main.entity.User;

public class ResponseTemplateVO {

	private User user;
	private News news;
	private UserNews usernews;
	public ResponseTemplateVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ResponseTemplateVO(User user, News news, UserNews usernews) {
		super();
		this.user = user;
		this.news = news;
		this.usernews = usernews;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public News getNews() {
		return news;
	}
	public void setNews(News news) {
		this.news = news;
	}
	public UserNews getUsernews() {
		return usernews;
	}
	public void setUsernews(UserNews usernews) {
		this.usernews = usernews;
	}
	
	
}
