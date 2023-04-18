package com.battisapi.BattiTradingAPI.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="userplans")
public class ManageUserPlans {
	
	@Id
	@GeneratedValue
	private int id;
	
	private int userid;
	
	private int planid;
	
	private int active;
	
	private String fromDate;
	
	private String endDate;
	
	private String paidOn;
	
	private String amount;
	
	private String modeofPayment;
	

}
