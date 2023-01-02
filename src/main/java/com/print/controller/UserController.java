package com.print.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lowagie.text.DocumentException;
import com.print.model.LoginUser;
import com.print.model.Response;
import com.print.model.UserContact;
import com.print.model.Users;
import com.print.report.UserPDFEXport;
import com.print.service.UserContactService;
import com.print.service.UserService;

@RestController
@RequestMapping("user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	
	
	@Autowired
	UserService userService;
	
	@CrossOrigin
	@PostMapping("/save")
	@ResponseBody
	public Response saveUser(@RequestBody Users usr)
	{
		try {
			userService.save(usr);
		return new Response("Success",100);
		}
		catch(Exception ex)
		{
			return new Response(ex.getMessage(),95);
		}
	}
	
	@CrossOrigin
	@PostMapping("/login")
	@ResponseBody
	public Response loginUser(@RequestBody LoginUser lu)
	{
		try {
			if(userService.login(lu.getUsername(),lu.getPassword())==1)
			{
				return new Response("Success",100);
			}
			else
			{
				return new Response("Invalid credentials",95);
			}

		}
		catch(Exception ex)
		{
			return new Response(ex.getMessage(),95);
		}
	}
	
	
    @GetMapping("/pdf")
    public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
         
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);
         
        List<Users> listUsers = userService.allUser();
         
        UserPDFEXport exporter = new UserPDFEXport(listUsers);
        exporter.export(response);
         
    }
	
}
