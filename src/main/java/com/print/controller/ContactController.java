package com.print.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.print.model.Quotation;
import com.print.model.UserContact;
import com.print.service.QuotationService;
import com.print.service.UserContactService;

@RestController
@RequestMapping("contact")
public class ContactController {

	
	@Autowired
	UserContactService userContactService;
	
	@GetMapping("/view")
	@ResponseBody
	public String viewQuotation()
	{
		return "This is sample response message";
	}
	
	
	@PostMapping("/save")
	@ResponseBody
	public String saveQuotation(@RequestBody UserContact usr)
	{
		try {
			userContactService.save(usr);
		return "Success";
		}
		catch(Exception ex)
		{
			return ex.getMessage();
		}
	}
}
