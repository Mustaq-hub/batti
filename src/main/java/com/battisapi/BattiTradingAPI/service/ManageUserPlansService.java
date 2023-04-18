package com.battisapi.BattiTradingAPI.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.battisapi.BattiTradingAPI.entity.InvestmentPlan;
import com.battisapi.BattiTradingAPI.entity.ManageUserPlans;

import com.battisapi.BattiTradingAPI.repository.UserPlanRepository;


@Service
public class ManageUserPlansService {
	
	private static final Logger logger = LoggerFactory.getLogger(ManageUserPlansService.class);
	@Autowired
	private UserPlanRepository userPlanRepository;
	
	@Autowired
	private InvestmentPlanService investmentPlanService;
	
	
	
	 private final JdbcTemplate jdbcTemplate;
	
	 @Autowired
	    public ManageUserPlansService(JdbcTemplate jdbcTemplate) {
	        this.jdbcTemplate = jdbcTemplate;
	    }
	public ManageUserPlans saveUserPlan(ManageUserPlans manageUserPlans)
	{
		return userPlanRepository.save(manageUserPlans);
	}
	
	public ManageUserPlans getUserPlanbyID(int id)
	{
		return userPlanRepository.findById(id).orElse(null);
	}
	public List<ManageUserPlans> getPlansbyUserID(Integer userid) {
		return userPlanRepository.findPlansByuserid(userid);
	}
	public ManageUserPlans getPlanbyUserIDAndPlanID(Integer userid,Integer planid) {
		return userPlanRepository.findPlanByUseridAndPlanid(userid,planid);
	}
	public ManageUserPlans UpdateUserPlan(ManageUserPlans manageUserPlans)
	{
		ManageUserPlans existingUserPlan=userPlanRepository.findById(manageUserPlans.getId()).orElse(null);
		existingUserPlan.setPlanid(manageUserPlans.getPlanid());
		existingUserPlan.setActive(manageUserPlans.getActive());
		existingUserPlan.setFromDate(manageUserPlans.getFromDate());
		existingUserPlan.setEndDate(manageUserPlans.getEndDate());		
		return userPlanRepository.save(existingUserPlan);	
	}
	public ManageUserPlans AddAmountforPlan(ManageUserPlans manageUserPlans)
	{
		
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		 java.util.Date dueDate=new java.util.Date();
		 logger.info("User id {} and planid {}", manageUserPlans.getUserid(),manageUserPlans.getPlanid());
		ManageUserPlans existingUserPlan=userPlanRepository.findPlanByUseridAndPlanid(manageUserPlans.getUserid(),manageUserPlans.getPlanid());
		
		try {
			dueDate = sdf.parse(manageUserPlans.getPaidOn());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		existingUserPlan.setAmount(manageUserPlans.getAmount());
		existingUserPlan.setPaidOn(dueDate.toString());
		existingUserPlan.setModeofPayment(manageUserPlans.getModeofPayment());
		logger.info("Existing plan", existingUserPlan);
		InvestmentPlan investmentPlan=new InvestmentPlan();
		investmentPlan=investmentPlanService.getPlanbyId(existingUserPlan.getPlanid());
		String sql = "CALL my_proc(?, ?,?,?,?,?)";
	    jdbcTemplate.update(sql, manageUserPlans.getUserid(), manageUserPlans.getPlanid(),investmentPlan.getPayoutValue(),dueDate,investmentPlan.getDuration(),investmentPlan.getPayoutFrequency());
		
		return userPlanRepository.save(existingUserPlan);	
	}
	

}
