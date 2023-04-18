package com.battisapi.BattiTradingAPI.service;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import javax.management.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.battisapi.BattiTradingAPI.dbutil.DBUtil;
import com.battisapi.BattiTradingAPI.entity.User;
import com.battisapi.BattiTradingAPI.entity.UserPlan;
import com.battisapi.BattiTradingAPI.repository.UserRepository;



@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;	
	

	
	Connection connection;
	int flag=0;
	
	public UserService() throws SQLException
	{
		connection=DBUtil.getConnection();
	}
	
	public User saveUser(User user)
	{
		return repository.save(user);
	}
	
	public List<User> saveUsers(List<User> users)
	{
		return repository.saveAll(users);
	}
	
	public List<User> getUsers()
	{
		return repository.findAll();
	}
	
	public User getUserbyID(int id)
	{
		return repository.findById(id).orElse(null);
	}
	
	
	public List<User> getUserByEmail(String email) {
		return repository.findByEmail(email);
	}
	public List<User> checkforDuplicate(String email,String mobileNumber) {
		return repository.findByEmailOrMobileNumber(email,mobileNumber);
	}
	
	public User authenticateUser(User user) {
		return repository.findByEmailAndPassword(user.getEmail(),user.getPassword());
	}
	public String deleteUserbyID(int id)
	{
		repository.deleteById(id);
		return "User removed";		
	}
	
	public User updateUser(User user)
	{
		User existingUser=repository.findById(user.getId()).orElse(null);
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setEmail(user.getEmail());
		existingUser.setAadhar(user.getAadhar());
		existingUser.setMobileNumber(user.getMobileNumber());
		existingUser.setAddress(user.getAddress());
		existingUser.setCity(user.getCity());
		existingUser.setPin(user.getPin());
		existingUser.setGender(user.getGender());
		existingUser.setBankname(user.getBankname());
		existingUser.setBranchname(user.getBranchname());
		existingUser.setNameasperaccount(user.getNameasperaccount());
		existingUser.setIfsc(user.getIfsc());
		existingUser.setAccountnumber(user.getAccountnumber());
		existingUser.setPan(user.getPan());
		return repository.save(existingUser);	
		
	}
	
	public User validateUser(String userName,String password)
	{
		User user=new User();
		try {
			
			PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM user WHERE email=? and password=?");
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, password);
			ResultSet resultSet=preparedStatement.executeQuery();
			//resultSet.absolute(1);
			if(resultSet.next())
			{
				user.setId(resultSet.getInt("id"));
				user.setAadhar(resultSet.getString("aadhar"));
				user.setEmail(resultSet.getString("email"));
				user.setFirstName(resultSet.getString("first_name"));
				user.setLastName(resultSet.getString("last_name"));
				user.setMobileNumber(resultSet.getString("mobile_number"));
				user.setAddress(resultSet.getString("address"));
				user.setCity(resultSet.getString("city"));
				user.setRole(resultSet.getString("role"));
			}
			else {
				user.setRole("INVALID");			
			}
			

			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	

	public List<User> getAllUserswithPlan()
	{
		
		List<User> users=new ArrayList<User>();
		try {
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT U.id,U.first_name,U.last_name,U.email,U.mobile_number,P.planid FROM user U INNER JOIN userplans P on P.userid=U.id");
		
		ResultSet rs=preparedStatement.executeQuery();
		while (rs.next()) {
			User user=new User();
			user.setId(rs.getInt("id"));
			user.setFirstName(rs.getString("first_name"));
			user.setLastName(rs.getString("last_name"));
			user.setEmail(rs.getString("email"));
			user.setMobileNumber(rs.getString("mobile_number"));
			user.setRole(rs.getString("planid"));
	          users.add(user);
	      }
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return users;
	}
	
	public List<User> getUserswithPlan()
	{
		return repository.getUsersWithPlans();
	}
	
	/*
	 * public List<UserPlan> getUserswithPlanDetails(String userid) { return
	 * customRespository.getUserPlans(userid); }
	 */
	public List<UserPlan> getUserswithPlanDetails(String userid)
	{
		List<UserPlan> users=new ArrayList<UserPlan>();
		try {
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT U.id,U.first_name as firstname,U.last_name as lastname,U.email,U.mobile_number,P.planid,P.from_date as fromdate,P.active,I.amount,I.name FROM user U INNER JOIN userplans P on P.userid=U.id INNER JOIN investment_plan I on I.id=P.planid WHERE U.id=?");
		preparedStatement.setString(1, userid);
		ResultSet rs=preparedStatement.executeQuery();
		while (rs.next()) {
			UserPlan user=new UserPlan();
			user.setId(rs.getInt("id"));
			user.setFirstname(rs.getString("firstname"));
			user.setLastname(rs.getString("lastname"));
			user.setEmail(rs.getString("email"));
			user.setMobile_number(rs.getString("mobile_number"));
			user.setPlanid(rs.getString("planid"));
			user.setFromdate(rs.getString("fromdate"));
			user.setActive(rs.getString("active"));
			user.setAmount(rs.getString("amount"));
			user.setName(rs.getString("name"));
	          users.add(user);
	      }
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return users;
	}
}
