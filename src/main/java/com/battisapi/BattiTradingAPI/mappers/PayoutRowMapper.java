package com.battisapi.BattiTradingAPI.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;


import org.springframework.jdbc.core.RowMapper;

import com.battisapi.BattiTradingAPI.entity.PayoutDetails;

public class PayoutRowMapper implements RowMapper<PayoutDetails> {
	
	@Override
    public PayoutDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		PayoutDetails payout = new PayoutDetails();
//		if(rs.next()==true)
//		{	
//		payout.setId(rs.getInt("id"));
//		payout.setfirstName(rs.getString("firstname"));
//		payout.setlastName(rs.getString("lastname"));
//		payout.setemail(rs.getString("email"));
//		payout.setMobilenumber(rs.getString("mobilenumber"));
//		payout.setPlanid(rs.getInt("planid"));
//		payout.setPaidon(rs.getString("paidon"));
//		payout.setDuedate(rs.getString("duedate"));
//		payout.setAmount(rs.getInt("amount"));
//		payout.setName(rs.getString("name"));
//		payout.setPayoutfrequency(rs.getString("payoutfrequency"));
//		}
        return payout;
    }

}
