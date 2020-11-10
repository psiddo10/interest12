package com.example.interest.interest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.interest.interest.entity.InterestEntity;

public interface InterestRepo extends JpaRepository<InterestEntity, Integer> {

}
