package com.print.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.print.model.FileUpload;
import com.print.model.UserContact;
import com.print.service.FileUploadService;
import com.print.service.QuotationService;

@RestController
@RequestMapping("file")
public class FileUploadController {

	@Autowired
	FileUploadService fileUploadService;
	
	@PostMapping("/save")
	@ResponseBody
	public String saveFileUpload(@RequestParam int user_session,
			@RequestParam String enquiry_no,
			@RequestParam Map<String,MultipartFile> files)
	{
		try {
			return fileUploadService.save(user_session,enquiry_no,files);
		//return "Success";
		}
		catch(Exception ex)
		{
			return ex.getMessage();
		}
	}
	
}
