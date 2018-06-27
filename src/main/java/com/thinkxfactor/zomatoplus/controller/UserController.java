package com.thinkxfactor.zomatoplus.controller;


//import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thinkxfactor.zomatoplus.models.User;
import com.thinkxfactor.zomatoplus.repository.UserRepository;



@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/add")
	public User addUser(@RequestBody User user) {
		
		User persistedUser=userRepository.save(user);
		return persistedUser;
	}
	

	@PostMapping("/login")
	public User userLogin(@RequestParam("Username") String username, @RequestParam("Password") String password)
	{
		return userRepository.findByNameAndPassword(username,password);
	}
	/*public User userLogin(@RequestParam("Username") String username, @RequestParam("Password") String password) {
		
		User usr=new User();
		usr.setUsername(username);
		usr.setPassword(password);
		return usr;
	}*/
	
	@GetMapping("/getAll")
	public List<User> getAll() {
		
		List<User> listofusers=userRepository.findAll();
		return listofusers;
		
	}
	
	@PostMapping("/create")
	public User userCreate(@RequestBody User user)
	{
		System.out.println(user.toString());
		return user;
	}
	
}
