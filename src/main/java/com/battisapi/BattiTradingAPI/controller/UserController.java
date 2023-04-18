package com.battisapi.BattiTradingAPI.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.battisapi.BattiTradingAPI.entity.User;
import com.battisapi.BattiTradingAPI.entity.UserPlan;
import com.battisapi.BattiTradingAPI.service.UserService;



@RestController
@CrossOrigin(exposedHeaders = {"Access-Control-Allow-Origin","Access-Control-Allow-Credentials"})
public class UserController {
	
	@Autowired
	private UserService service;
	
	
        
	@PostMapping("/addUser")
	public User addUSer(@RequestBody User user)
	{
		return service.saveUser(user);
	}
	
	@PostMapping("/addUsers")
	public List<User> addUSers(@RequestBody List<User> users)
	{
		return service.saveUsers(users);
	}
	
	
	@GetMapping("getAllUsers")	
	public List<User> getAllUsers()
	{
		return service.getUsers();
	}
	@GetMapping("getAllUserswithPlan")	
	public List<User> getAllUserswithPlan()
	{
		return service.getUserswithPlan();
	}
	@GetMapping("getUserswithPlanDetails")	
	public List<UserPlan> getUserswithPlanDetails(@RequestParam String userid)
	{
		return service.getUserswithPlanDetails(userid);
	}
	@GetMapping("/getUserById")
	public User getUserById(@RequestParam int id)
	{
		return service.getUserbyID(id);
	}
	
	@PostMapping("/updateUser")
	public User updateUser(@RequestBody User user)
	{
		return service.updateUser(user);
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable int id)
	{
		return service.deleteUserbyID(id);
	}
	
	@GetMapping("validateuser")
	public User validateUser(@RequestBody User user)
	{
		return service.authenticateUser(user);
	}
	
	@GetMapping("checkduplicateuser")
	public List<User> checkduplicateuser(@RequestParam String email,@RequestParam String mobileNumber)
	{
		return service.checkforDuplicate(email, mobileNumber);
	}
	
	@PostMapping("authenticateuser")
	public User authenticateuser(@RequestBody User user)
	{
		return service.authenticateUser(user);
	}
	
	@GetMapping("getuserbyemail")	
	public List<User> GetUserbyEmail(@RequestParam String email)
	{
		return service.getUserByEmail(email);
	}

}
