package com.print.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.print.model.Quotation;
import com.print.model.UserContact;
import com.print.repository.QuotationRepo;
import com.print.repository.UserContactRepo;

@Service
public class UserContactService {
	@Autowired
	UserContactRepo userContactRepo;
	
	Date date=new Date();
	SimpleDateFormat  df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String curDate=df.format(date);
	
	public void save(UserContact u)
	{
		UserContact us=new UserContact(1,
				u.getUSER_ID(),
				u.getSESSION_ID(),
				u.getCONTACT_TYPE(),
				u.getCONTACT_VALUE(),
				u.getIS_CONFIRM(),
				Timestamp.valueOf(curDate),null);
		
		userContactRepo.save(us);
	}
}
