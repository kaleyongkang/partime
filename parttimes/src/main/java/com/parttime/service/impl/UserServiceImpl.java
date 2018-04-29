package com.parttime.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parttime.dao.UserDao;
import com.parttime.entity.Company;
import com.parttime.entity.User;
import com.parttime.service.UserService;
import com.parttime.util.Result;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	
	public Result<Object> login(User user) {
		Result<Object> result = new Result<Object>();
		User userFromDB = userDao.findByUsername(user.getUsername());
		if (userFromDB != null && userFromDB.getPassword().equals(user.getPassword())) {
			result.setStatus(Result.SUCCESS);
			result.setData(userFromDB);
			result.setMsg("登录成功！");
			return result;
		}
		
		result.setStatus(Result.FAILED);
		result.setMsg("用户名或者密码错误！");
		return result;
	}
	
	public Result<Object> register(User user) {
		Result<Object> result = new Result<Object>();
		User userFromDB = userDao.findByUsername(user.getUsername());
		if (userFromDB == null) {
			userDao.insertUser(user);
			result.setStatus(Result.SUCCESS);
			result.setMsg("注册成功！");
			return result;
		}

		result.setStatus(Result.FAILED);
		result.setMsg("用户名已经存在！");
		return result;
	}

	public Result<Object> getUser(String useranme) {
		Result<Object> result = new Result<Object>();
		User user = userDao.findByUsername(useranme);
		result.setStatus(Result.SUCCESS);
		result.setData(user);
		result.setMsg("查询成功");
		return result;
	}
	
	public Result<Object> getUser1(String useranme) {
		Result<Object> result = new Result<Object>();
		Company user = userDao.findByUsername1(useranme);
		result.setStatus(Result.SUCCESS);
		result.setData(user);
		result.setMsg("查询成功");
		return result;
	}

	public Result<Object> editInfo(User user) {
		Result<Object> result = new Result<Object>();
		userDao.updateUser(user);
		result.setStatus(Result.SUCCESS);
		result.setMsg("插入成功");
		return result;
	}

	public Result<Object> login1(Company user) {
		Result<Object> result = new Result<Object>();
		Company userFromDB = userDao.findByUsername1(user.getUsername());
		if (userFromDB != null && userFromDB.getPassword().equals(user.getPassword())) {
			result.setStatus(Result.SUCCESS);
			result.setData(userFromDB);
			result.setMsg("登录成功！");
			return result;
		}
		
		result.setStatus(Result.FAILED);
		result.setMsg("用户名或者密码错误！");
		return result;
	}

	public Result<Object> register1(Company user) {
		Result<Object> result = new Result<Object>();
		Company userFromDB = userDao.findByUsername1(user.getUsername());
		if (userFromDB == null) {
			userDao.insertUser1(user);
			result.setStatus(Result.SUCCESS);
			result.setMsg("注册成功！");
			return result;
		}

		result.setStatus(Result.FAILED);
		result.setMsg("用户名已经存在！");
		return result;
	}

	public Result<Object> editCompany(Company company) {
		Result<Object> result = new Result<Object>();
		userDao.editCompany(company);
		result.setStatus(Result.SUCCESS);
		result.setMsg("插入成功");
		return result;
	}
}
