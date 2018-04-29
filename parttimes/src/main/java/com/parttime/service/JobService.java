package com.parttime.service;

import com.parttime.entity.FilterFind;
import com.parttime.entity.Job;
import com.parttime.entity.Join;
import com.parttime.util.Result;

public interface JobService {

	Result<Object> list();

	Result<Object> add(Job job);

	Result<Object> delete(Integer id);

	Result<Object> filterFind(FilterFind filterFind);

	Result<Object> findOne(Integer id);

	Result<Object> joinIn(Join join);

	Result<Object> findJoinList(Integer id);
	
	Result<Object> myFindJoinList(String username);
}
