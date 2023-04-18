package com.battisapi.BattiTradingAPI.repository;



import org.springframework.data.jpa.repository.JpaRepository;


import com.battisapi.BattiTradingAPI.entity.InvestmentPlan;

public interface PlanRepository extends JpaRepository<InvestmentPlan,Integer> {
	
	
}
