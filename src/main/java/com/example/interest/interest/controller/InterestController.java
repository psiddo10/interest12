package com.example.interest.interest.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.interest.interest.entity.InterestEntity;
import com.example.interest.interest.service.InterestService;

@RestController
@RequestMapping("/interestapi")
public class InterestController {

	private InterestService interestService;
	
//	@Autowired
//	private RestTemplate restTemplate;
//	
//	
	
	
	
	@Autowired
	public InterestController(InterestService theInterestService) {
		interestService=theInterestService;
	}
	
	@GetMapping("/findall")
	public List<InterestEntity> findAll(){
		
		return interestService.findAll();
		
	}
	
	
	
	
	@PostMapping("/findall")
	public InterestEntity findall(@RequestParam(required = false) boolean activeFlag,@RequestBody InterestEntity user) throws InterruptedException {
		
		
		return interestService.save(user,activeFlag);
		
		
		
	}
	
	@PostMapping("/findalldisp")
	public InterestEntity findalldisp(@RequestBody InterestEntity user) throws InterruptedException {
		
		
		return interestService.disp(user);
		
		
		
	}
	
	
	
	
	
	@GetMapping("/findall/{theid}")
	public Optional<InterestEntity> findById(@PathVariable  Integer theid) {
		
		return interestService.findById(theid);
	}
	
	
	
	
//	@PutMapping("/findalldate")
//	public InterestEntity update(@RequestBody InterestEntity user) throws InterruptedException {
//		
//		LocalDateTime date=LocalDateTime.now();
//		
//		user.setEnddate(date);
//		return user;
//		
//	}
	
	

	
	
}