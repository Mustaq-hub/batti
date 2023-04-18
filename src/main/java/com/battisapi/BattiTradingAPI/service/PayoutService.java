package com.battisapi.BattiTradingAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;


import com.battisapi.BattiTradingAPI.entity.Payout;
import com.battisapi.BattiTradingAPI.entity.PayoutDetails;
import com.battisapi.BattiTradingAPI.mappers.PayoutRowMapper;
import com.battisapi.BattiTradingAPI.repository.PayoutRepository;

@Service
public class PayoutService {
	
	@Autowired
	public PayoutRepository payoutRepository;
	
	 private final JdbcTemplate jdbcTemplate;
	 @Autowired
	    public PayoutService(JdbcTemplate jdbcTemplate) {
	        this.jdbcTemplate = jdbcTemplate;
	    }
	
	public Payout savePayout(Payout payout)
	{
		return payoutRepository.save(payout);
	}
	
	public List<Payout> GetPayoutDetailsByUserID(Integer userid)
	{
		return payoutRepository.findByuserid(userid);
	}
	public List<Payout> GetPayoutDetailsByPlanID(Integer userid,Integer planid)
	{
		return payoutRepository.findByuseridAndPlanidOrderByDuedate(userid,planid);
	}
	public Payout UpdatePayout(Payout payout)
	{
		Payout existingPayout=payoutRepository.findById(payout.getId()).orElse(null);
		existingPayout.setId(payout.getId());		
		existingPayout.setPaidon(payout.getPaidon());
		existingPayout.setModeofpayment(payout.getModeofpayment());		
		existingPayout.setComments(payout.getComments());		
		return payoutRepository.save(existingPayout);	
	}
	public List<PayoutDetails> GetPendingPayoutDetails()
	{
		List<PayoutDetails> employees = jdbcTemplate.query(" SELECT P.id,U.first_name as firstname,U.last_name as lastname,U.email,U.mobile_number as mobileNumber,P.planid,P.paidon,P.duedate,P.amount,I.name,I.payout_frequency as  payoutfrequency FROM user U \r\n"
				+ "INNER JOIN payout P on P.userid=U.id INNER JOIN investment_plan I on I.id=P.planid \r\n"
				+ "WHERE P.duedate<=curdate() AND P.paidon IS null", new PayoutRowMapper());

		return employees;
	}

}
