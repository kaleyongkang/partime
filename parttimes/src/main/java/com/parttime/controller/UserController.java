package com.parttime.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.parttime.entity.Company;
import com.parttime.entity.User;
import com.parttime.service.UserService;
import com.parttime.util.Result;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	 @Autowired  
    private HttpServletRequest request; 
	
	@RequestMapping("/login")
	@ResponseBody
	public Result<Object> login(@RequestBody Company user) {
		return userService.login1(user);
	}
	
	@RequestMapping("/register")
	@ResponseBody
	public Result<Object> register(@RequestBody Company user) {
		return userService.register1(user);
	}
	
	@RequestMapping("/getUser")
	@ResponseBody
	public Result<Object> getUser(String useranme) {
		return userService.getUser(useranme);
	}
	
	@RequestMapping("/getUser1")
	@ResponseBody
	public Result<Object> getUser1(String useranme) {
		return userService.getUser1(useranme);
	}
	
	@RequestMapping("/editInfo")
	@ResponseBody
	public Result<Object> editInfo(@RequestBody User user) {
		return userService.editInfo(user);
	}
	
	@RequestMapping("/editCompany")
	@ResponseBody
	public Result<Object> editCompany(@RequestBody Company company) {
		return userService.editCompany(company);
	}
	
    @RequestMapping("/upload")
    public Result<Object> uploadFile(@RequestParam(value = "file" , required = true) MultipartFile file) {
    	try {
   			byte[] bytes = file.getBytes();
			String basePath = "D:\\upload";
			FileOutputStream fos = new FileOutputStream(new File(basePath, file.getOriginalFilename()));
			fos.write(bytes);
			fos.close();
			String path = basePath + file.getOriginalFilename();
			User user = new User();
			user.setFile(path);
			Result<Object> editInfo = editInfo(user);
			return editInfo;
	     } catch (Exception e) {
			e.printStackTrace();
		}
		return null;
    
    }
}
