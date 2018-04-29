package com.parttime.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.parttime.entity.FilterFind;
import com.parttime.entity.Job;
import com.parttime.entity.Join;
import com.parttime.service.JobService;
import com.parttime.util.Result;

@Controller
@RequestMapping("/job")
public class JobController {
	@Autowired
	private JobService jobService;

  /*  @InitBinder
    public void initBind(WebDataBinder binder){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");  
        dateFormat.setLenient(false);  
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));   
    }*/
	
	@RequestMapping("/list")
	@ResponseBody
	public Result<Object> list() {
		return jobService.list();
	}

	@RequestMapping("/add")
	@ResponseBody
	public Result<Object> add(Job job) {
		return jobService.add(job);
	}

	@RequestMapping("/delete")
	@ResponseBody
	public Result<Object> delete(@RequestBody Job job) {
		return jobService.delete(job.getId());
	}

	@RequestMapping("/filterFind")
	@ResponseBody
	public Result<Object> filterFind(@RequestBody FilterFind filterFind) {
		return jobService.filterFind(filterFind);
	}

	@RequestMapping("/findOne")
	@ResponseBody
	public Result<Object> findOne(@RequestParam(value = "") Integer id) {
		return jobService.findOne(id);
	}

	@RequestMapping("/findJoinList")
	@ResponseBody
	public Result<Object> findJoinList(@RequestParam(value = "id") Integer id) {
		return jobService.findJoinList(id);
	}
	
	@RequestMapping(value = "/joinIn", method = RequestMethod.POST)
	@ResponseBody
	public Result<Object> joinIn(@RequestBody Join join) {
		return jobService.joinIn(join);
	}
	
	@RequestMapping(value = "/myFindJoinList", method = RequestMethod.GET)
	@ResponseBody
	public Result<Object> myFindJoinList(@RequestParam(value = "username") String username) {
		return jobService.myFindJoinList(username);
	}
}
