package com.print.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Service;

import com.print.model.Quotation;
import com.print.repository.QuotationRepo;

@Service
public class QuotationService {

	@Autowired
	QuotationRepo quotationRepo;
	
	Date date=new Date();
	SimpleDateFormat  df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String curDate=df.format(date);
	
	
	public void save(Quotation q)
	{
		Quotation qt=new Quotation(1,
				q.getUSER_ID(),
				q.getSESSION_ID(),
				q.getENQUIRY_NO(),
				q.getUSER_NAME(),
				q.getLENGTH_Y(),
				q.getWIDTH_X(),
				q.getHEIGHT_Z(),
				q.getDIMENSION_TYPE(),
				q.getPAPER_TYPE(),
				q.getPAPER_GSM(),
				q.getDESCRIPTIONS(),
				q.getQUANTITY(),
				q.getCURRENCY(),
				q.getIS_ANSWERED(),
				q.getUNIT_PRICE(),
				Timestamp.valueOf(curDate),null);
		
		quotationRepo.save(qt);
	}
	
	
	
}
