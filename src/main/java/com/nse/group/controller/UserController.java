package com.nse.group.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nse.group.entity.User;
import com.nse.group.service.IGroupService;
import com.nse.group.service.IUserService;


@RestController
@RequestMapping("/user")
public class UserController {

	
	@Autowired
	IUserService userService;
	
	
	@Autowired
	IGroupService groupService;
	

	
	@PostMapping("/add/{groupName}")
	public User addUser(@PathVariable String groupName , @RequestBody User user) {
		
		user.getGroupInfos().add(groupService.findByGroupName(groupName));
		
		return userService.addUser(user);
		
	}
	
	
}
