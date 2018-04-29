package com.parttime.service;

import com.parttime.entity.Company;
import com.parttime.entity.User;
import com.parttime.util.Result;

public interface UserService {

	Result<Object> login(User user);
	
	Result<Object> login1(Company user);

	Result<Object> getUser(String useranme);
	
	Result<Object> getUser1(String useranme);

	Result<Object> editInfo(User user);

	Result<Object> register(User user);
	
	Result<Object> register1(Company user);

	Result<Object> editCompany(Company company);
}
