package com.nse.group.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nse.group.entity.GroupInfo;
import com.nse.group.service.IGroupService;

@RestController 
@RequestMapping("/group")
public class GroupController {

	@Autowired
	IGroupService service;
	
	
	
	@PostMapping("/add")
	public GroupInfo addGroup(@RequestBody GroupInfo group) {
		
		return service.addGroup(group);
		
	}
	
	
	@GetMapping("/get/{name}")
	public GroupInfo getGroup(@PathVariable String name) {
		
		return service.findByGroupName(name);
		
	}
	
	
}
