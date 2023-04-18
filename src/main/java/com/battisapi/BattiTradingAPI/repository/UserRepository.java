package com.battisapi.BattiTradingAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.battisapi.BattiTradingAPI.entity.User;




public interface UserRepository extends JpaRepository<User,Integer> {
	
	List<User> findByEmail(String email);
	
	User findByEmailAndPassword(String email,String password);
	
	List<User> findByEmailOrMobileNumber(String email,String mobileNumber);
	
	 @Query(value = "SELECT U.id,U.aadhar,U.accountnumber,U.nameasperaccount,U.ifsc,U.pan,U.password,U.role,U.gender,U.address,U.city,U.pin,U.bankname,U.branchname,U.first_name,U.last_name,U.email,U.mobile_number,P.planid FROM user U INNER JOIN userplans P on P.userid=U.id", nativeQuery = true)
	    public List<User> getUsersWithPlans();
	 
	

}
