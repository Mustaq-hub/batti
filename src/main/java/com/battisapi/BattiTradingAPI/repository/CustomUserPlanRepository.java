package com.battisapi.BattiTradingAPI.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.battisapi.BattiTradingAPI.entity.UserPlan;

public interface CustomUserPlanRepository  extends JpaRepository<UserPlan, Long> {
	
	 @Query(value="SELECT U.id,U.first_name as firstname,U.last_name as lastname,U.email,U.mobile_number,P.planid,P.from_date as fromdate,P.active,I.amount,I.name FROM user U INNER JOIN userplans P on P.userid=U.id INNER JOIN investment_plan I on I.id=P.planid WHERE U.id=?",nativeQuery = true)
	 public List<UserPlan> getUserPlans(String userid);

}
