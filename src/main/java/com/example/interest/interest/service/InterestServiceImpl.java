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
import com.example.interest.interest.entity.RestEntity;
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
//	
//	RestEntity userIn= restTemplate.getForObject("http://pocketbits.onerooftechnologies.com/api/v1/User/UserDetailsByMobileNo?token=0B3B4681-4AB2-42F3-A730-55B2512AE31F-87801&device_type=3&Mobile_no=8087562646", RestEntity.class);

	@Override
	public List<InterestEntity> findAll() {
		return interestRepo.findAll();
	}
	

	
	

	@Override
	public InterestEntity save(InterestEntity user,boolean activeFlag) throws InterruptedException{

		
//		InterestEntity user=restTemplate.getForObject(url, responseType)
		
		double bal=user.getBalance();
		double p=user.getAmount();
		

		boolean isApproved=false;
		boolean request_for_withdrawl=false;
		boolean with=false;
		int t=user.getTenure();
		int days=t*30;
		int n=12;
		double r=0.03/365;
		
		
		
		user.setDate(LocalDateTime.now());
		
		startDate=user.getDate();
		
		enddate=startDate.plusSeconds(120);
		user.setEnddate(enddate);
		
		
		
		if(user.isApproval() == false) {
			interestRepo.save(user);
		}
		else {
		 ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
	        future = executor.scheduleAtFixedRate(new Runnable(){
	        	
	        	LocalDateTime d = startDate;
	        	double princ=p;
	        	LocalDateTime d2= enddate;
	        	double curr_bal=bal-princ;
	        	
	        	LocalDateTime d3=user.getRandomdate();
	        	
	        	LocalDateTime d4=user.getEnddate();

	                @Override
	                public void run() {
	                	
	            		

	                	System.out.println(d.isBefore(user.getEnddate()) + ""+ !user.isWithdraw()  );
	                	
	                	if (d.isBefore(user.getEnddate()) && user.isWithdraw()  ) {
	            			
	                			 princ=princ* Math.pow(1 + (r / n), n * 1);
	                			
	                			
	                			user.setAmount(princ);
	            				
	            				System.out.println(princ);
	            				
	            				interestRepo.save(user);
	            				
	            				d=d.plusSeconds(1);
	            				
	            				
	                }
	                	
//	                
	                	
	                	else {
	                		
	                		curr_bal=curr_bal+princ;
	                		
	                		user.setBalance(curr_bal);
	                		System.out.println(curr_bal);
	                		future.cancel(true);
	                		executor.shutdown();
	                	}
	                	
	                	
	                	
	        		
	                	}
	               
                	
	                	
	                         
	                
	                
	                          
	                
	                
	        },0, 4, TimeUnit.HOURS);
		
		}
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

	
	@Override
	public boolean findApproval(boolean flag) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public InterestEntity disp(InterestEntity user) {
		return interestRepo.save(user);
	}

	
	


	
	
	

}

