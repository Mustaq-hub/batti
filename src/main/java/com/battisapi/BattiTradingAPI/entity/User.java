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
@Table(name="User")
public class User {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String mobileNumber;
	
	private String aadhar;	
	
	private String gender;
	
	private String address;
	
	private String city;
	
	private String pin;
	
	private String bankname;
	
	private String branchname;
	
	private String accountnumber;
	
	private String nameasperaccount;
	
	private String ifsc;
	
	private String pan;
	
	private String password;
	
	private String role;
	

}
