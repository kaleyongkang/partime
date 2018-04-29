package com.parttime.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parttime.dao.JobDao;
import com.parttime.entity.FilterFind;
import com.parttime.entity.Job;
import com.parttime.entity.Join;
import com.parttime.service.JobService;
import com.parttime.util.Result;
@Service
public class JobServiceImpl implements JobService{

	@Autowired
	private JobDao jobDao;
	public Result<Object> list() {
		Result<Object> result = new Result<Object>();
		List<Job> jobs = jobDao.findAll();
		result.setStatus(Result.SUCCESS);
		result.setData(jobs);
		return result;
	}
	public Result<Object> add(Job job) {
		job.setCreatetime(new Date());
		jobDao.add(job);
		return new Result<Object>();
	}
	public Result<Object> delete(Integer id) {
		jobDao.delete(id);
		return new Result<Object>();
	}
	public Result<Object> filterFind(FilterFind filterFind) {
		if ("工资".equals(filterFind.getOrderBy())) {
			filterFind.setOrderBy("slarry");
		} else if ("发布时间".equals(filterFind.getOrderBy())) {
			filterFind.setOrderBy("createtime");
		}
		
		if (filterFind.getOrderBy() == null || "".equals(filterFind.getOrderBy())) {
			filterFind.setOrderBy("createtime");
		}
		
		Result<Object> result = new Result<Object>();
		List<Job> jobs = jobDao.filterFind(filterFind);
		result.setStatus(Result.SUCCESS);
		result.setData(jobs);
		return result;
	}
	public Result<Object> findOne(Integer id) {
		Result<Object> result = new Result<Object>();
		Job job = jobDao.findOne(id);
		result.setStatus(Result.SUCCESS);
		result.setData(job);
		return result;
	}
	public Result<Object> joinIn(Join join) {
		join.setStatus("参加成功");
		join.setJoinTime(new Date());
		Result<Object> result = new Result<Object>();
		String status = jobDao.findJoinIn(join.getJobId(), join.getUserName());
		if ("参加成功".equals(status)) {
			result.setStatus(Result.FAILED);
			join.setStatus("已经参加");
		} else {
			jobDao.joinIn(join);
			result.setStatus(Result.SUCCESS);
		}
		result.setData(join);
		return result;
	}

	public Result<Object> findJoinList(Integer id) {
		Result<Object> result = new Result<Object>();
		List<Join> joins = jobDao.findJoinList(id);
		result.setStatus(Result.SUCCESS);
		result.setData(joins);
		return result;
	}
	
	public Result<Object> myFindJoinList(String username) {
		Result<Object> result = new Result<Object>();
		List<Job> jobs = new ArrayList<Job>();
		List<Join> joins = jobDao.myFindJoinList(username);
		for (Join join : joins) {
			Job job = jobDao.findOne(join.getJobId());
			jobs.add(job);
		}
		
		result.setStatus(Result.SUCCESS);
		result.setData(jobs);
		return result;
	}
}
