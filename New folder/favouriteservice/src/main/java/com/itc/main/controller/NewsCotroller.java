package com.itc.main.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itc.main.entity.News;
import com.itc.main.repository.NewsRepository;
import com.itc.main.service.NewsService;

@RestController
@RequestMapping("/api/")
public class NewsCotroller {

	@Autowired
	private NewsService newsservice;
	
	@Autowired
	private NewsRepository newsrepository;
	
	@PostMapping("save")
	public ResponseEntity<News> save(@RequestBody News news ){
		News g=this.newsservice.save(news);
		return new ResponseEntity<News>(g, HttpStatus.CREATED);
	}
	@GetMapping("news")
	public ResponseEntity<List<News>> getAllNews(){
		List<News> list=this.newsservice.getAllNews();
		return new ResponseEntity<List<News>>(list, HttpStatus.OK);
	}
	
	@GetMapping("news/{newsId}")
	public ResponseEntity<News> getNewsById(@PathVariable("newsId") int newsId){
		News f=this.newsservice.getNewsById(newsId);
			   return new ResponseEntity<News>(f, HttpStatus.OK);
	}
	
	@GetMapping("favourite/{userId}")
	public ResponseEntity<List<News>> getFavoritesByUserId(@PathVariable("userId") int userId){
		List<Integer> favIds = newsrepository.getFavoritesByUserId(userId);
		List<News> news = favIds.stream().map((favorite) -> newsrepository.findById(favorite).get()).collect(Collectors.toList());
		return new ResponseEntity<List<News>>(news, HttpStatus.OK);
	}
}
