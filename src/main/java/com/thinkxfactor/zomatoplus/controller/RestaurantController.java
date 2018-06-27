package com.thinkxfactor.zomatoplus.controller;

//import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thinkxfactor.zomatoplus.models.Item;
import com.thinkxfactor.zomatoplus.models.Restaurant;
import com.thinkxfactor.zomatoplus.repository.ItemsRepository;
import com.thinkxfactor.zomatoplus.repository.RestaurantRepository;

	@RestController
	@RequestMapping("/restaurant")
	public class RestaurantController {
		
		@Autowired
		private RestaurantRepository restaurantRepository;
		
		@Autowired
		private ItemsRepository itemRepository;
		
		
		@PostMapping("/create")
		public Restaurant restCreate(@RequestBody Restaurant rest1) {
			
			Restaurant persistedRestaurant=restaurantRepository.save(rest1);
			return persistedRestaurant;
		}
		
		@GetMapping("/getall")
		public List<Restaurant> getAll()
		{
			List<Restaurant> rests=restaurantRepository.findAll();
			return rests;
		}
		
		@PostMapping("/additem")
		public Item addItem(@RequestBody Item food) {
			Item persistedItem=itemRepository.save(food);
			return persistedItem;
		}
	}
	
