package com.nse.group.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nse.group.entity.GroupInfo;
import com.nse.group.entity.User;
import com.nse.group.service.IGroupService;
import com.nse.group.service.IUserService;
import com.nse.group.service.UserService;

@RestController 
@RequestMapping("/group")
public class GroupController {

	@Autowired
	IGroupService service;
	
	
	@Autowired
	IUserService userService;
	
	
	
	@PostMapping("/add")
	public GroupInfo addGroup(@RequestBody GroupInfo group) {
		
		return service.addGroup(group);
		
	}
	
	
	@PutMapping("/add-member/{groupName}/{userName}")
	public GroupInfo addUserToGroup( @PathVariable String groupName , @PathVariable String userName) {
		
		
		GroupInfo group = service.findByGroupName(groupName);
		
		User user = userService.findByUserName(userName);
	
		System.out.println(group.toString());
		System.out.println(user.toString());
	
		
		//user.getGroupInfos().add(group);
		group.getUsers().add(user);                 
		
		//group.addUser(user);		
		
		System.out.println("After update..");
		
		System.out.println(group.toString());
		System.out.println(user.toString());
		
		return service.addGroup(group);
		
		//return group;
	}
	
	
	@GetMapping("/get/{name}")
	public GroupInfo getGroup(@PathVariable String name) {
		
		System.out.println("get name...");
		return service.findByGroupName(name);
		
	}
	
	
	@DeleteMapping("/delete/{name}")
	public ResponseEntity<String> deleteGroupByName(@PathVariable String name){
		
		service.deleteGroup(service.findByGroupName(name));
		
		return new ResponseEntity<String>("Successfully Deleted "+name , HttpStatus.OK);
	}
	
	
	@GetMapping("/getall")
	public List<GroupInfo> getAllGroups(){
		return service.getAllGroups();
	}
	
	
}
