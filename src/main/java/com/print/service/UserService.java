package com.print.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.print.model.Quotation;
import com.print.model.Users;
import com.print.repository.UserRepository;

@Service
public class UserService {

	
	@Autowired
	UserRepository userRepository;
	
	Date date=new Date();
	SimpleDateFormat  df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String curDate=df.format(date);
	
	
	public int save(Users u)
	{
		try {
		Users us=new Users(1,
				u.getF_name(),
				u.getL_name(),
				u.getUsername(),
				u.getEmail(),
				u.getCell(),
				u.getPass(),
				u.getC_pass(),
				u.getIs_verify(),
				u.getIs_active(),
				Timestamp.valueOf(curDate),null);
		
		userRepository.save(us);
		return 1;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return 0;
		}
	}
	
	
	public int login(String username,String pass)
	{
		return userRepository.checkUser(username,pass);
	}
	
	
	public List<Users> allUser()
	{
		return userRepository.findAll();
	}
}
