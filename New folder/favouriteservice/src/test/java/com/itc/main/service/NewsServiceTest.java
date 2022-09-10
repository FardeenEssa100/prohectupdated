package com.itc.main.service;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.itc.main.entity.News;
import com.itc.main.repository.NewsRepository;
import com.itc.main.service.NewsService;



@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)

public class NewsServiceTest {
	@InjectMocks
	@Mock
	private NewsService newsService;
	private NewsRepository newsRepository;
	
	/*
	@BeforeEach
	private void setup() {
		MockitoAnnotations.initMocks(this);
	}*/
	
	@Test
	public void getNotNullTest() {
		assertThat(newsService).isNotNull();
		assertThat(newsRepository).isNotNull();
	}
	
	
	@Test
	public void testsaveProduct() {
		//Get the Object
		 News news2= new News();
		 news2.setUserId(123456);
			news2.setTitle("Bombbom");
			news2.setContent("bomb in tamil");;
			news2.setDescription("for sure");
			news2.setPublishedAt("00/09/2020");
			news2.setSourceWebsiteName("lookup");
			news2.setUrl("knknkn");
			news2.setUrlToImage("muiyu");
			news2.setId(5437);
		//when ,then
		  
		 when(this.newsRepository.save(news2))
		  .thenReturn(news2);
		
		 News p=this.newsService.save(news2);
		 assertEquals(p.getUserId(), news2.getUserId());
		 System.out.println("--SUCCESS SAVE Product--");
	}
 
	
 @Test
	public void testUserById() {
		News news2= new News();
		 news2.setUserId(123456);
			news2.setTitle("Bombbom");
			news2.setContent("bomb in tamil");;
			news2.setDescription("for sure");
			news2.setPublishedAt("00/09/2020");
			news2.setSourceWebsiteName("lookup");
			news2.setUrl("knknkn");
			news2.setUrlToImage("mercy");
			news2.setId(5437);
		
		  
		
		when(this.newsRepository.getOne(101))
		.thenReturn(news2);
		
		News p=this.newsService.getNewsById(101);
		assertEquals(p.getUserId(), news2.getUserId());
		System.out.println("--SUCCESS TEST GET BY ID--");		
	}
	
}