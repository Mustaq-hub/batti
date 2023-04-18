package com.battisapi.BattiTradingAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.battisapi.BattiTradingAPI.entity.InvestmentPlan;
import com.battisapi.BattiTradingAPI.repository.PlanRepository;

@Service
public class InvestmentPlanService {
	
	@Autowired
	private PlanRepository planRepository;
	
	public InvestmentPlan savePlan(InvestmentPlan plan)
	{
		return planRepository.save(plan);
	}
	
	public List<InvestmentPlan> getAllPlans()
	{
		return planRepository.findAll();
	}
	
	public InvestmentPlan getPlanbyId(int id)
	{
		return planRepository.findById(id).orElse(null);
	}
	
	public InvestmentPlan updatePlan(InvestmentPlan plan)
	{
		InvestmentPlan existingPlan=planRepository.findById(plan.getId()).orElse(null);
		existingPlan.setAmount(plan.getAmount());
		existingPlan.setDetails(plan.getDetails());
		existingPlan.setName(plan.getName());
		return planRepository.save(existingPlan);
		
	}

}
