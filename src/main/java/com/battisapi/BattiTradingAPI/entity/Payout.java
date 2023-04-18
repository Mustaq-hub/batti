package com.battisapi.BattiTradingAPI.entity;

import java.sql.Date;

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
@Table(name="payout")
public class Payout {
	
	@Id
	@GeneratedValue
	private int id;
	
	private int userid;
	
	private int planid;
	
	private int amount;
	
	private Date paidon;
	
	private String comments;
	
	private String modeofpayment;
	
	private Date duedate;

}
