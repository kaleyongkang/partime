package com.parttime.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.parttime.entity.FilterFind;
import com.parttime.entity.Job;
import com.parttime.entity.Join;

import java.util.List;
import java.util.Map;
@Repository
public interface JobDao {
	public List<Job> findAll();

	public void add(Job job);

	public void delete(Integer id);

	public List<Job> filterFind(FilterFind filterFind);

	public Job findOne(Integer id);

	public String findJoinIn(@Param("jobId") Integer jobId, @Param("username") String username);

	public void joinIn(Join join);

	public List<Join> findJoinList(Integer id);
	
	public List<Join> myFindJoinList(String username);
}
