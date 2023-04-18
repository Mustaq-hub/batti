package com.battisapi.BattiTradingAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.battisapi.BattiTradingAPI.entity.ManageUserPlans;


public interface UserPlanRepository extends JpaRepository<ManageUserPlans,Integer> {
	List<ManageUserPlans> findPlansByuserid(Integer userID);
	ManageUserPlans findPlanByUseridAndPlanid(Integer userID,Integer planId);

}
