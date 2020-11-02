package com.example.interest.interest.service;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.util.StringBuilders;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

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
	
	public InterestServiceImpl(InterestRepo theInterestRepo) {
		
		interestRepo=theInterestRepo;
		
	}

	@Override
	public List<InterestEntity> findAll() {
		return interestRepo.findAll();
	}
	

	
	

	@Override
	public InterestEntity save(InterestEntity user) throws InterruptedException{

		
		
		
		double bal=user.getBalance();
		double p=user.getAmount();
		
		boolean with=user.
		
		int t=user.getTenure();
		
		int days=t*30;
		int n=365;
		double r=0.03/365;
		
		user.setDate(LocalDateTime.now());
		
		startDate=user.getDate();
		
		enddate=startDate.plusDays(days);
		
		date1=startDate.plusDays(30);
		
		date2=startDate.plusDays(60);
		
		
		LocalDateTime d = startDate;
		
		 ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
	        future = executor.scheduleAtFixedRate(new Runnable(){
	        	double curr_bal=bal-p;
	                @Override
	                public void run() {
	                	if (d.isBefore(enddate) || d.equals(enddate) ) {
	            			
	                			double amount=p * Math.pow(1 + (r / n), n * t);
	                			
	            				curr_bal=curr_bal+(amount-p);	
	            				
	            				user.setBalance(curr_bal);
	            				
	            				interestRepo.save(user);
	                }
	                	
	                	
	                	else if(with == true) {
	                		
	                		curr_bal=curr_bal+p;
	                		
	                		user.setBalance(curr_bal);
	                		
	                		future.cancel(true);
	                		executor.shutdown();
	                		
	                	}
	                	
	                	
	                	else {
	                		
	                		curr_bal=curr_bal+p;
	                		
	                		user.setBalance(curr_bal);
	                		
	                		future.cancel(true);
	                		executor.shutdown();
	                	}
	        		
	}
	                
	                
	                
	                
	                
	                
},0, 1, TimeUnit.SECONDS);
		

	return interestRepo.save(user);


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

