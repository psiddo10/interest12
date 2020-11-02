package com.example.interest.interest.entity;

import java.net.URL;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;


public class Driver {

	public static void main(String[] args) {

		try {
			
			
			
			ObjectMapper mapper=new ObjectMapper();
			
			InterestEntity ent = mapper.readValue(new URL("http://localhost:8009/interestapi/findall/1"), InterestEntity.class);
			
			
			
			
			System.out.println("name:"+ent.getUsername());
			
			int amount1=ent.getAmount();
			
			
			amount1=amount1+(amount1*3/100);
			
			 
			 
			 ent.setAmount(amount1);
			
			 
			 mapper.updateValue(new URL("http://localhost:8009/interestapi/findall/1"), ent);
			 
			 System.out.println("amount:"+amount1);

//			mapper.enable(SerializationFeature.INDENT_OUTPUT);
	
			
			
			
			
			
		}
		
		catch(Exception e) {
			System.out.println(e);
		}
		
		
	}

}
