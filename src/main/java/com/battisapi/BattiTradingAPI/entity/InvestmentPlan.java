package com.battisapi.BattiTradingAPI.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name="InvestmentPlan")
public class InvestmentPlan {
	
	@Id
	@GeneratedValue
	private int id;
	
	private int amount;
	
	private String name;
	
	private String details;
	
	private int active;
	
	private int duration;
	
	private String durationType;
	
	private String payoutFrequency;
	
	private String payoutType;
	
	private int payoutValue;
	
	private String refundable;	
	

}
