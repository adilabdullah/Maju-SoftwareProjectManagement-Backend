package com.print.service;

import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.print.model.FileUpload;
import com.print.model.Quotation;
import com.print.repository.FileUploadRepo;
import com.print.repository.QuotationRepo;

@Service
public class FileUploadService {

	@Autowired
	FileUploadRepo fileUploadRepo;
	
	Date date=new Date();
	SimpleDateFormat  df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String curDate=df.format(date);
	
	public String save(int user_session,String enquiry_no,Map<String,MultipartFile> files)
	{

		return fileUpload(user_session,enquiry_no,files);
	}
	
	
	
	public String fileUpload(int user_session,String enquiry,Map<String,MultipartFile> files)
	{
		  String ext="";
			//	  return "Success";
				    String path="D:\\NodeJs\\";
				  Date date = new Date();
			      SimpleDateFormat ft=new SimpleDateFormat ("dd/MM/yyyy-hh:mm:ss");
				  
		          System.out.println(user_session);
		          System.out.println(enquiry);
			    try {
			    	path=path+user_session+"_"+enquiry;
			    	System.out.println(path);
			    	File f1 = new File(path);  
			         f1.mkdir();
			        
			        	   
			        	  Iterator <String> it = files.keySet().iterator();       //keyset is a method  
			    		  while(it.hasNext())  
			    		  {  
			    		   String key=it.next();  
		                   ext=FileUploadService.getExtension(files.get(key).getOriginalFilename()).toUpperCase();
			    		   if(!ext.contains("PDF") && !ext.contains("DOCX") && !ext.contains("DOC"))
			    		   {       
			    			   FileUtils.deleteDirectory(new File(path));
			    			   return "File format not correct "+files.get(key).getOriginalFilename();  
		                       
			    		   }
			    		   else
			    		   {
			    			   if(files.get(key).getSize()/1024>2048)
			    			   {
			    			       FileUtils.deleteDirectory(new File(path));
			    				   return "File size exceeded "+files.get(key).getOriginalFilename();
			    			   }
			    			   else
			    			   {
			    				   files.get(key).transferTo(new File(path+"\\"+key.toUpperCase()+"."+FileUploadService.getExtension(files.get(key).getOriginalFilename())));   
			    				   fileUploadRepo.save(new FileUpload(1,
					    					user_session,
					    					user_session,
					    					enquiry,
					    					path+"\\"+key.toUpperCase()+"."+FileUploadService.getExtension(files.get(key).getOriginalFilename()),
					    					FileUploadService.getExtension(files.get(key).getOriginalFilename()),
					    					String.valueOf(files.get(key).getSize()),
					    					Timestamp.valueOf(curDate),null));
					    			
					    			//fileUploadRepo.save(fl);
			    			   }
			    		   }
			    	
			    		  }  
			    			
			    		  return "Success";
			          
			         
			    } catch (Exception e) {
			      return e.getMessage();
			    }   
			   
	}
	
	
	  public static String getExtension(String filename) {
		    return FilenameUtils.getExtension(filename);
		}
	
}
