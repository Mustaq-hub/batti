package com.battisapi.BattiTradingAPI.service;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DBService {
	
	private JdbcTemplate jdbcTemplate;

	  public DBService(JdbcTemplate jdbcTemplate) {
	    this.jdbcTemplate = jdbcTemplate;
	  }
	  
	  public String AddPayoutDueDates(int userid, int planid,int amount,Date startdate,int duration,String frequency) {
		    SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
		      .withProcedureName("my_proc");

		    Map<String, Object> inParams = new HashMap<>();
		    inParams.put("userid", userid);
		    inParams.put("planid", planid);
		    inParams.put("amount", amount);
		    inParams.put("startdate", startdate);
		    inParams.put("duration", duration);
		    inParams.put("frequency", frequency);

		    Map<String, Object> outParams = simpleJdbcCall.execute(inParams);

		    return (String) outParams.get("result");
		  }

}
