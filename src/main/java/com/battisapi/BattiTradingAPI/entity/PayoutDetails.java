package com.battisapi.BattiTradingAPI.entity;


public class PayoutDetails {
	
	private int id;
	private String firstname;
	private String lastname;
	private String email;
	private String mobilenumber;
	private int planid;
	private String paidon;
	private String duedate;
	private int amount;
	private String name;
	private String payoutfrequency;
	
	public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getfirstName() {
        return firstname;
    }
    
    public void setfirstName(String firstname) {
        this.firstname = firstname;
    }
    
    public String getlastName() {
        return lastname;
    }
    
    public void setlastName(String lastname) {
        this.lastname = lastname;
    }
    public String getemail() {
        return email;
    }
    
    public void setemail(String email) {
        this.email = email;
    }
    public String getMobilenumber() {
        return mobilenumber;
    }
    
    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }
    
    public int getPlanid() {
        return planid;
    }
    
    public void setPlanid(int planid) {
        this.planid = planid;
    }
    
    public String getPaidon() {
        return paidon;
    }
    
    public void setPaidon(String paidon) {
        this.paidon = paidon;
    }
    
    public String getDuedate() {
        return duedate;
    }
    
    public void setDuedate(String duedate) {
        this.duedate = duedate;
    }
    
    public int getAmount() {
        return amount;
    }
    
    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getPayoutfrequency() {
        return payoutfrequency;
    }
    
    public void setPayoutfrequency(String payoutfrequency) {
        this.payoutfrequency = payoutfrequency;
    }
	

}
