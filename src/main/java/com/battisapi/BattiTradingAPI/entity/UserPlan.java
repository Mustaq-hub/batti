package com.battisapi.BattiTradingAPI.entity;

import javax.persistence.Entity;

import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class UserPlan {
	
	@Id	
	private int id;		
	private String firstname;
	private String lastname;
	private String email;
	private String mobile_number;
	private String planid;
	private String fromdate;
	private String active;
	private String amount;
	private String name;
	
	
	
	

}
