package com.itc.main.vo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class News {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private Integer userId;
	private String title;
	private String description;
	private String content;
	private String publishedAt;
	private String sourceWebsiteName;
	private String url;
    private String urlToImage;
	public News() {
		super();
		// TODO Auto-generated constructor stub
	}
	public News(int id, Integer userId, String title, String description, String content, String publishedAt,
			String sourceWebsiteName, String url, String urlToImage) {
		super();
		this.id = id;
		this.userId = userId;
		this.title = title;
		this.description = description;
		this.content = content;
		this.publishedAt = publishedAt;
		this.sourceWebsiteName = sourceWebsiteName;
		this.url = url;
		this.urlToImage = urlToImage;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPublishedAt() {
		return publishedAt;
	}
	public void setPublishedAt(String publishedAt) {
		this.publishedAt = publishedAt;
	}
	public String getSourceWebsiteName() {
		return sourceWebsiteName;
	}
	public void setSourceWebsiteName(String sourceWebsiteName) {
		this.sourceWebsiteName = sourceWebsiteName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUrlToImage() {
		return urlToImage;
	}
	public void setUrlToImage(String urlToImage) {
		this.urlToImage = urlToImage;
	}
    
}
