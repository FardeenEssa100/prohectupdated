package com.itc.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.itc.main.entity.AuthRequest;
import com.itc.main.entity.User;
import com.itc.main.service.UserService;
import com.itc.main.util.JwtUtil;
import com.itc.main.vo.News;
import com.itc.main.vo.UserNews;

@RestController
public class UserController {
	@Autowired
	private UserService userservice;

	 @Autowired
	    private JwtUtil jwtUtil;
	 
	 @Autowired
	private RestTemplate restTemplate;
	 
     @Autowired
     private AuthenticationManager authenticationManager;
	    
	 @GetMapping("/")
	 public String welcome() {
	    return "Hello world";
	 }

	 @PostMapping("/authenticate")
	 public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
		 try {
	            authenticationManager.authenticate(
	                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
	            );
	            
	        } catch (Exception ex) {
	            throw new Exception("inavalid username/password");
	        }
	        return jwtUtil.generateToken(authRequest.getUserName());
	    }
	    
	 @PostMapping("/save")
	 public ResponseEntity<User> save(@RequestBody User user){
		 System.out.println("---User Controller---");
		 User u=this.userservice.save(user);
	     return new ResponseEntity<User>(u, HttpStatus.CREATED);
		}
	 
	 @GetMapping("/{userId}")
	 public User findUserById(@PathVariable("userId") int userId) {
		 return this.userservice.findById(userId);
	}
	 
	 
	 @GetMapping("news/{userId}")
	 public ResponseEntity<UserNews> getFavoritesByUser(@PathVariable("userId") int userId){
		 User user=this.userservice.findById(userId);
		 News[] favorite=restTemplate.getForObject("http://localhost:9991/api/news/"+ Integer.toString(userId),News[].class);
		 UserNews usernews=new UserNews();
		 usernews.setUser(user);
		usernews.setNews(favorite);
		
		return new ResponseEntity<UserNews>(usernews,HttpStatus.OK);
	 }

	 
}