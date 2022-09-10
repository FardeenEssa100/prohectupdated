package com.itc.main.repository;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.opentest4j.AssertionFailedError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.itc.main.entity.News;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class NewsRepositoryTest {

	@Autowired
	private NewsRepository newsRepository;
		


		@Test
		@Order(1)
		public void testNotNull() {
			assertNotNull(newsRepository);
		}
		
		
		@Test
		@Order(2)
		public void saveAccountTest() {
			News us=new News(123456,"Bombbom"," tamil","for sure","00/09/2020","lookup","knknkn","mercy",7654);
			News u=this.newsRepository.save(us);
			assertEquals(u.getUserId(),us.getUserId());
          

			System.out.println("--SUCCESS SAVE PRODUCT TEST--");
			
		}
		

}