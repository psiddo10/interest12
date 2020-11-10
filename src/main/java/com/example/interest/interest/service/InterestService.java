package com.example.interest.interest.service;

import java.util.List;
import java.util.Optional;

import com.example.interest.interest.entity.InterestEntity;
import com.example.interest.interest.repository.InterestRepo;

public interface InterestService {

	
	public List<InterestEntity> findAll();
	
	public InterestEntity save(InterestEntity user,boolean activeFlag) throws InterruptedException;
	

	Optional<InterestEntity> findById(Integer theid);
	

	
	public InterestEntity deleteById(Integer theid);

	public boolean findApproval(boolean flag);
	
	public InterestEntity disp(InterestEntity user);

	
}
