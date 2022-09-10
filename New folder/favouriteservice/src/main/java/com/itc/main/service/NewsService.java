package com.itc.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itc.main.entity.News;
import com.itc.main.repository.NewsRepository;

@Service
public class NewsService {
	@Autowired
	private NewsRepository newsrepository;
	
	public News save(News news) {
		return this.newsrepository.save(news);
		
	}
	public List<News> getAllNews(){
		return this.newsrepository.findAll();
	}
	public News getNewsById(int Id) {
		Optional<News> op=this.newsrepository.findById(Id);
			if(op.isPresent()) {
				return op.get();
			}else 
				return null;
	}
	public boolean deleteNewsById(int Id) {
		this.newsrepository.deleteById(Id);
		return true;
	}
	
}
