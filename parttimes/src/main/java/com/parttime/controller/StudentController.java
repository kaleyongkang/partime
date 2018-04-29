package com.parttime.controller;

import java.io.File;
import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.parttime.entity.User;
import com.parttime.service.UserService;
import com.parttime.util.Result;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/login")
	@ResponseBody
	public Result<Object> login(@RequestBody User user) {
		return userService.login(user);
	}
	
	@RequestMapping("/register")
	@ResponseBody
	public Result<Object> register(@RequestBody User user) {
		return userService.register(user);
	}
	
	@RequestMapping("/getUser")
	@ResponseBody
	public Result<Object> getUser(String useranme) {
		return userService.getUser(useranme);
	}
	
	@RequestMapping("/editInfo")
	@ResponseBody
	public Result<Object> editInfo(@RequestBody User user) {
		return userService.editInfo(user);
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
