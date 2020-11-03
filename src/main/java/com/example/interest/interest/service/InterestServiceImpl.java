package com.example.interest.interest.service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.interest.interest.entity.InterestEntity;
import com.example.interest.interest.repository.InterestRepo;




@Service
public class InterestServiceImpl implements InterestService {

	

	
	
	LocalDateTime startDate;
	
	LocalDateTime enddate;
	
	LocalDateTime date1,date2;
	
	private InterestRepo interestRepo;
	 Integer curr_bal;

	
	static ScheduledFuture<?> future;
	
	
//	public boolean isenabled() {
//		
//		if(with == true) {
//			
//			with == false;
//		}
//		return with;
//		
//	}
//	
	@Autowired
	public InterestServiceImpl(InterestRepo theInterestRepo) {
		
		interestRepo=theInterestRepo;
		
	}
	
//	@Autowired
//	RestTemplate restTemplate;

	@Override
	public List<InterestEntity> findAll() {
		return interestRepo.findAll();
	}
	

	
	

	@Override
	public InterestEntity save(InterestEntity user) throws InterruptedException{

		
//		InterestEntity user=restTemplate.getForObject(url, responseType)
		
		double bal=user.getBalance();
		double p=user.getAmount();
		boolean with = false;


		int t=user.getTenure();
		int days=t*30;
		int n=12;
		double r=0.03/365;
		
		user.setDate(LocalDateTime.now());
		
		startDate=user.getDate();
		
		enddate=startDate.plusSeconds(10);
		
		date1=startDate.plusDays(30);
		
		date2=startDate.plusDays(60);
		
		
		
		
		
		 ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
	        future = executor.scheduleAtFixedRate(new Runnable(){
	        	LocalDateTime d = startDate;
	        	double curr_bal=bal-p;
	        	
	        	
	                @Override
	                public void run() {
	                	
	                	if (d.isBefore(enddate) || d.equals(enddate) ) {
	            			
	                			double amount=p * Math.pow(1 + (r / n), n * 1);
	                			
//	            				curr_bal=curr_bal+(amount-p);	
	            				
	            				user.setBalance(curr_bal);
	            				
	            				System.out.println(curr_bal);
	            				
	            				interestRepo.save(user);
	            				
	            				d=d.plusSeconds(1);
	                }
	                	
	                	
	                	
	                	
	                	
	                	else {
	                		
	                		curr_bal=curr_bal+p;
	                		
	                		user.setBalance(curr_bal);
	                		
	                		future.cancel(true);
	                		executor.shutdown();
	                	}
	        		
	}
	                	
	                	
	                         
	                
	                
	                
	                
	                
	        },0, 1, TimeUnit.SECONDS);
		

	        return user;

	}

	@Override
	public Optional<InterestEntity> findById(Integer theid) {
		
		Optional<InterestEntity> interest=interestRepo.findById(theid);
		
		
		
		
		return interestRepo.findById(theid);
	
	}

	@Override
	public InterestEntity deleteById(Integer theid) {
		return null;

	}


	
	

}

