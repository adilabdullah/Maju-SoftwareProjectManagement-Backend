package com.print.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.print.model.Quotation;
import com.print.service.QuotationService;

@RestController
@RequestMapping("quotation")
public class QuotationController {

	@Autowired
	QuotationService quotationService;
	
	@PostMapping("/save")
	@ResponseBody
	public String saveQuotation(@RequestBody Quotation quo)
	{
		try {
		quotationService.save(quo);
		return "Success";
		}
		catch(Exception ex)
		{
			return ex.getMessage();
		}
	}
	
	
}
