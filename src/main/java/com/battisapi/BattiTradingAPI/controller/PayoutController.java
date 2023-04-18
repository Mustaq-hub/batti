package com.battisapi.BattiTradingAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.battisapi.BattiTradingAPI.entity.Payout;
import com.battisapi.BattiTradingAPI.entity.PayoutDetails;
import com.battisapi.BattiTradingAPI.service.PayoutService;

@RestController
@CrossOrigin(exposedHeaders = {"Access-Control-Allow-Origin","Access-Control-Allow-Credentials"})
public class PayoutController {
	
	@Autowired
	private PayoutService payoutService;
	
	@PostMapping("/addpayout")
	public Payout addpayout(@RequestBody Payout payout)
	{
		return payoutService.savePayout(payout);
	}
	@PostMapping("/updatepayout")
	public Payout updatepayout(@RequestBody Payout payout)
	{
		return payoutService.UpdatePayout(payout);
	}
	@GetMapping("/GetPayoutbyUserID")
	public List<Payout> GetPayoutbyUserID(@RequestParam Integer userid)
	{
		return payoutService.GetPayoutDetailsByUserID(userid);
	}
	@GetMapping("/GetPayoutbyPlanID")
	public List<Payout> GetPayoutbyPlanID(@RequestParam Integer userid,@RequestParam Integer planid)
	{
		return payoutService.GetPayoutDetailsByPlanID(userid,planid);
	}
	@GetMapping("/GetPayoutReminder")
	public List<PayoutDetails> GetPayoutReminder()
	{
		return payoutService.GetPendingPayoutDetails();
	}
	

}
