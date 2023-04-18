package com.battisapi.BattiTradingAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.battisapi.BattiTradingAPI.entity.Payout;

public interface PayoutRepository extends JpaRepository<Payout,Integer> {

	List<Payout> findByuserid(Integer userid);
	List<Payout> findByuseridAndPlanidOrderByDuedate(Integer userid,Integer planid);
}
