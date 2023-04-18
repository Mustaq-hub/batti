package com.battisapi.BattiTradingAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.battisapi.BattiTradingAPI.entity.ManageUserPlans;
import com.battisapi.BattiTradingAPI.service.ManageUserPlansService;



@RestController
@CrossOrigin(exposedHeaders = {"Access-Control-Allow-Origin","Access-Control-Allow-Credentials"})
public class UserPlanController {

	@Autowired
	private ManageUserPlansService manageUserPlansService;
	
	@GetMapping("/GetUserPlans")
	public List<ManageUserPlans> GetUserPlans(@RequestParam Integer Userid)
	{
		return manageUserPlansService.getPlansbyUserID(Userid);
	}
	
	@PostMapping("/AddUserPlan")
	public ManageUserPlans AddUserPlan(@RequestBody ManageUserPlans userplan)
	{
		return manageUserPlansService.saveUserPlan(userplan);
	}
	@PostMapping("/AddPayment")
	public ManageUserPlans AddPayment(@RequestBody ManageUserPlans userplan)
	{
		return manageUserPlansService.AddAmountforPlan(userplan);
	}
}
