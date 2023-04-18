package com.battisapi.BattiTradingAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.battisapi.BattiTradingAPI.entity.InvestmentPlan;
import com.battisapi.BattiTradingAPI.service.InvestmentPlanService;

@RestController
@CrossOrigin(exposedHeaders = {"Access-Control-Allow-Origin","Access-Control-Allow-Credentials"})
public class PlanController {
	
	@Autowired
	private InvestmentPlanService investmentPlanService;
	
	@GetMapping("/getAllPlans")
	public List<InvestmentPlan> getAllPlans()
	{
		return investmentPlanService.getAllPlans();
	}
	@GetMapping("/getPlanDetails")
	public InvestmentPlan getPlanDetails(@RequestParam Integer id)
	{
		return investmentPlanService.getPlanbyId(id);
	}
	@PostMapping("addPlan")
	public InvestmentPlan addPlan(@RequestBody InvestmentPlan plan)
	{
		return investmentPlanService.savePlan(plan);
	}
	
	@PutMapping("updatePlan")
	public InvestmentPlan updatePlan(@RequestBody InvestmentPlan plan)
	{
		return investmentPlanService.updatePlan(plan);
	}

}
