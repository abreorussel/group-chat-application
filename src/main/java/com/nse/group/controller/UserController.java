package com.nse.group.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
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
	

	
	@PostMapping("/add")
	public User addUser(@RequestBody User user) {
		
		//user.getGroupInfos().add(groupService.findByGroupName(groupName));
		
		return userService.addUser(user);
		
	}
	
	
	@GetMapping("/get")
	public List<User> getUsers(){
		
		return userService.getUsers();
	}
	
	
}
