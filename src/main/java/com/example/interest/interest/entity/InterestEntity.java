package com.example.interest.interest.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dateuser")
public class InterestEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int Id;
	
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	@Column(name="username")
	private String username;
	
	@Column(name="date")
	LocalDateTime date;
	
	@Column(name="amount")
	private double amount;
	
	@Column(name="tenure")
	private int tenure;
	
	@Column(name="balance")
	private double balance;
	
//	
//	@Column(name="Withdraw")
//	private boolean withdraw;
//	

	public InterestEntity() {}

	

	


	

	

	public InterestEntity(int id, String username, LocalDateTime date, int amount, int tenure, int balance,
			boolean withdraw) {
		super();
		Id = id;
		this.username = username;
		this.date = date;
		this.amount = amount;
		this.tenure = tenure;
		this.balance = balance;
		//this.withdraw = withdraw;
	}
//	public boolean isWithdraw() {
//		return withdraw;
//	}
//
//	public boolean setWithdraw(boolean withdraw) {
//		return this.withdraw = withdraw;
//	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double curr_bal) {
		this.balance = curr_bal;
	}

	public int getTenure() {
		return tenure;
	}

	public void setTenure(int tenure) {
		this.tenure = tenure;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
		
	}

	@Override
	public String toString() {
		return "InterestEntity [username=" + username + ", date=" + date + ", amount=" + amount + "]";
	}
	
	

	
	
	

}
