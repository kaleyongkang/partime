package com.parttime.dao;

import org.springframework.stereotype.Repository;

import com.parttime.entity.Company;
import com.parttime.entity.User;

@Repository
public interface UserDao {
	public User findByUsername(String userName);
	public void insertUser(User user);
	public void updateUser(User user);
	public void insertUser1(Company user);
	public Company findByUsername1(String username);
	public void editCompany(Company company);
}
